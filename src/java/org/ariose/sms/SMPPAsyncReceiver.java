package org.ariose.sms;

import ie.omk.smpp.Address;
import ie.omk.smpp.Connection;
import ie.omk.smpp.event.ConnectionObserver;
import ie.omk.smpp.event.ReceiverExitEvent;
import ie.omk.smpp.event.SMPPEvent;
import ie.omk.smpp.message.BindResp;
import ie.omk.smpp.message.DeliverSM;
import ie.omk.smpp.message.SMPPPacket;
import ie.omk.smpp.message.SubmitSM;
import ie.omk.smpp.message.SubmitSMResp;
import ie.omk.smpp.message.Unbind;
import ie.omk.smpp.message.UnbindResp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.EventLoggingDAO;
import org.ariose.model.GmlcConfiguration;
import org.ariose.util.ApplicationException;
import org.ariose.util.CommonFunctions;
import org.ariose.util.Constants;
import org.ariose.util.GmlcConstants;

/**
 * Example SMPP receiver using asynchronous communications. This example
 * demonstrates asynchronous communications by implementing the
 * ConnectionObserver interface and directly handling all receiver events.
 * 
 * @see ie.omk.smpp.examples.ParseArgs ParseArgs for details on running this
 *      class.
 */
public class SMPPAsyncReceiver implements ConnectionObserver {

	private Log logger = LogFactory.getLog(SMPPAsyncReceiver.class);
	private String operatorname = null;
	private String shortCode = null;
	private String smsReceiverUrl = null;
	private static int msgCount = 0;

	// Start time (once successfully bound).
	private long start = 0;

	// End time (either send an unbind or an unbind received).
	private long end = 0;

	String hostName;
	int port;
	String systemID;
	String password;
	String systemType;
	int sourceTON;
	int sourceNPI;
	String sourceAddress;
	Connection myConnection;
	String mobileNo;
	/**
	 * File with default settings for the application.
	 */
	// static String propsFilePath = "smppReceiver.cfg";
	EventLoggingDAO dao = null;
	// SubscriberDAO subscriberDAO = null;
	public boolean stopFlag;
	private String SEND_SMS_URL = "http://localhost:8080/cmsportal/UninorSubscription.html";

	public void setEventLoggingDAO(EventLoggingDAO eventDao) {
		logger.info("called..");
		this.dao = eventDao;
	}

	// /**
	// * @param subscriberDAO
	// * the subscriberDAO to set
	// */
	// public void setSubscriberDAO(SubscriberDAO subscriberDAO) {
	// this.subscriberDAO = subscriberDAO;
	// }

	/**
	 * @param smsReceiverUrl
	 *            the smsReceiverUrl to set
	 */
	public void setSmsReceiverUrl(String smsReceiverUrl) {
		this.smsReceiverUrl = smsReceiverUrl;
	}

	public void setProperties(String filename) {
		logger.info("called..");
		try {
			loadProperties(filename);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * Loads configuration parameters from the file with the given name. Sets
	 * private variable to the loaded values.
	 */
	private void loadProperties(String fileName) throws IOException,
			ApplicationException {
		logger.info("Reading configuration file " + fileName + "...");

		InputStream propsFile = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);

		logger.info("Input stream is.." + propsFile);
		if (propsFile == null) {
			throw new ApplicationException("no such file present.." + fileName);
		}

		Properties properties = new Properties();
		properties.load(propsFile);
		propsFile.close();
		logger.info("Setting default parameters...");

		operatorname = properties.getProperty("operatorname");
		CommonFunctions.checkNull("operatorname", operatorname);

		try {
			shortCode = properties.getProperty("shortCode");
			Integer.parseInt(shortCode);
		} catch (Exception e) {
			throw new ApplicationException(
					"Cannot send sms..shortCode is not configured properly");
		}

		hostName = properties.getProperty("hostName");
		CommonFunctions.checkNull("hostName", hostName);

		try {
			port = Integer.parseInt(properties.getProperty("port"));
		} catch (Exception e) {
			throw new ApplicationException(
					"Cannot send sms..port is not configured properly");
		}

		systemID = properties.getProperty("systemID");
		CommonFunctions.checkNull("systemID", systemID);

		password = properties.getProperty("password");
		CommonFunctions.checkNull("password", password);

		systemType = properties.getProperty("systemType", systemType);
		try {
			sourceTON = Integer.parseInt(properties.getProperty("sourceTON",
					String.valueOf(sourceTON)));
		} catch (Exception e) {
		}
		try {
			sourceNPI = Integer.parseInt(properties.getProperty("sourceNPI",
					String.valueOf(sourceNPI)));
		} catch (Exception e) {
		}
		sourceAddress = properties.getProperty("sourceAddress", sourceAddress);

		logger.info("values set from property file are.." + "hostName.."
				+ hostName + ",port.." + port + ",systemID.." + systemID
				+ ",password.." + password + ",systemType.." + systemType
				+ ",sourceTON.." + sourceTON + ",sourceNPI.." + sourceNPI
				+ ",sourceAddress.." + sourceAddress);
	}

	// This is called when the connection receives a packet from the SMSC.
	public void update(Connection r, SMPPEvent ev) {
		switch (ev.getType()) {
		case SMPPEvent.RECEIVER_EXIT:
			receiverExit(r, (ReceiverExitEvent) ev);
			break;
		}
	}

	public void packetReceived(Connection myConnection, SMPPPacket pak) {

		// TODO bomber
		if (stopFlag) {
			return;
		}
		// logger.info("packet received..with commandId.."+pak.getCommandId());

		switch (pak.getCommandId()) {

		// Bind transmitter response. Check it's status for success...
		case SMPPPacket.BIND_RECEIVER_RESP:
			if (pak.getCommandStatus() != 0) {
				logger.info("Error binding to the SMSC. Error = "
						+ pak.getCommandStatus());
			} else {
				this.start = System.currentTimeMillis();
				logger.info("Successfully bound. Waiting for message"
						+ " delivery..");

				synchronized (this) {
					// on exiting this block, we're sure that
					// the main thread is now sitting in the wait
					// call, awaiting the unbind request.
				}
			}
			break;

		// Submit message response...
		case SMPPPacket.DELIVER_SM:
			if (pak.getCommandStatus() != 0) {
				logger.info("Deliver SM with an error! "
						+ pak.getCommandStatus());

			} else {
				++msgCount;
				logger.info("deliver_sm: "
						+ Integer.toString(pak.getSequenceNum()) + ": \""
						+ ((DeliverSM) pak).getMessageText() + "\"");

				String operatorName = "Uninor";
				int operatorId = 9;
				String circleName = "";// TODO
				int circleId = 0;// TODO
				String packName = "";
				int packId = 0;
				String subscriberNumber = pak.getSource().getAddress();
				if (subscriberNumber != null && subscriberNumber.length() > 10) {
					subscriberNumber = subscriberNumber.substring(
							subscriberNumber.length() - 10,
							subscriberNumber.length());
				}

				String keyword = ((DeliverSM) pak).getMessageText();
				int channelId = 0;
				String requestTime = CommonFunctions.getCurrentDate();
				String subscriptionStatus = "";
				String shortcode = pak.getDestination().getAddress();
				String request = "SMS Request with Message Text as - "
						+ Integer.toString(pak.getSequenceNum()) + ": \""
						+ ((DeliverSM) pak).getMessageText() + "\"";

				try {
					String queryString = getQueryStringFromPacket(pak);

					if (dao != null)
						dao.saveSubsRequestLog(operatorName, operatorId,
								circleName, circleId, packName, packId,
								subscriberNumber, keyword, channelId,
								requestTime, subscriptionStatus, shortcode,
								request);

					logger.info("queryString - " + queryString);
					logger.info("Sending sms to CORTEX url..");
					try {
						CommonFunctions.sendRequestToGateway(SEND_SMS_URL + "?"
								+ queryString);
					} catch (Exception e) {
						// this case will never come!!
						throw new ApplicationException(
								Constants.APP_ERROR_IN_CONNECTION,
								"Error Connecting to Cortex URL");
					}

				} catch (ApplicationException e) {

					if (dao != null)
						dao.saveSubsRequestLog(operatorName, operatorId,
								circleName, circleId, packName, packId,
								subscriberNumber, keyword, channelId,
								requestTime,
								"Error " + e.getId() + " - " + e.getMessage(),
								shortcode, request);

					logger.error(
							"Could not send recieved sms to application via http..",
							e);
				}

			}
			break;

		// Unbind request received from server..
		case SMPPPacket.UNBIND:
			this.end = System.currentTimeMillis();
			logger.info("\nSMSC has requested unbind! Responding..");
			try {
				UnbindResp ubr = new UnbindResp((Unbind) pak);
				myConnection.sendResponse(ubr);

				synchronized (this) {
					notify();
				}
			} catch (IOException x) {
				logger.info("Exception", x);
			} finally {
				endReport();
			}
			break;

		// Unbind response..
		case SMPPPacket.UNBIND_RESP:
			this.end = System.currentTimeMillis();
			logger.info("\nUnbound.");
			synchronized (this) {
				notify();
			}
			endReport();
			break;

		default:
			// logger.info("\nUnexpected packet received! Id = 0x"
			// + Integer.toHexString(pak.getCommandId()));
		}

	}

	// String shortCode = GmlcConstants.SHORT_CODE;

	private String getQueryStringFromPacket(SMPPPacket pak)
			throws ApplicationException {
		/*
		 * 1. Get shortcode,keyword,subscriberNumber
		 * 
		 * 2. Call url
		 * 
		 * http://localhost:8080/cmsportal/UninorSubscription.html?NotifyType=
		 * ActivateUser
		 * &SID=8423343592&Keyword=Myfriend_KEYWORD&Source=SMS&Shortcode
		 * =$shortcode
		 */
		String queryString = "NotifyType=$NotifyType&SID=$SID&Keyword=$Keyword&Source=SMS&Shortcode=$Shortcode";
		String sid = null;
		String keyword = null;
		String shortcode = null;
		String NotifyType = null;
		try {
			sid = pak.getSource().getAddress();
			shortcode = pak.getDestination().getAddress();
			keyword = ((DeliverSM) pak).getMessageText();
			if (keyword == null) {
				throw new ApplicationException(
						Constants.APP_RSP_INCORRECT_KEYWORD, "Keyword is Empty");
			}

			if (keyword.contains("DCT")) {
				NotifyType = "DeactivateUser";
			} else if (keyword.contains("ACT")) {
				NotifyType = "ActivateUser";
			} else {
				throw new ApplicationException(
						Constants.APP_RSP_INCORRECT_KEYWORD,
						"Keyword does not have ACT or DCT");
			}

			queryString = queryString.replace("$NotifyType", NotifyType)
					.replace("$SID", sid).replace("$Keyword", keyword)
					.replace("$Shortcode", shortcode);

		} catch (ApplicationException e) {
			logger.error(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			throw new ApplicationException(Constants.APP_ERROR_SMS_PACKET_RCVD,
					"Error in Packet Recieved");
		}

		logger.info("queryString is - " + queryString);
		return queryString;
	}

	private void receiverExit(Connection myConnection, ReceiverExitEvent ev) {
		if (ev.getReason() != ReceiverExitEvent.EXCEPTION) {
			if (ev.getReason() == ReceiverExitEvent.BIND_TIMEOUT) {
				logger.error("Bind timed out waiting for response.");
			}
			logger.error("Receiver thread has exited: " + ev.getReason());
		} else {
			Throwable t = ev.getException();
			logger.error("Receiver thread died due to exception:");
			logger.error("Exception", t);
			endReport();
		}
		synchronized (this) {
			notify();
		}
	}

	// Print out a report
	private void endReport() {
		logger.info("deliver_sm's received: " + msgCount);
		logger.info("Start time: " + new Date(start).toString());
		logger.info("End time: " + new Date(end).toString());
		logger.info("Elapsed: " + (end - start) + " milliseconds.");
	}

	public void execute() throws Exception {
		try {
			myConnection = new Connection(hostName, port, true);

			// Need to add myself to the list of listeners for this connection
			myConnection.addObserver(this);

			// Automatically respond to ENQUIRE_LINK requests from the SMSC
			myConnection.autoAckLink(true);
			myConnection.autoAckMessages(true);

			// Bind to the SMSC
			logger.info("Binding to the SMSC..");

			logger.info(Thread.currentThread()
					+ " Binding to SMSC with hostName " + hostName + ", port "
					+ port);

			synchronized (this) {
				BindResp bindResp = myConnection.bind(Connection.TRANSCEIVER,
						systemID, password, systemType, sourceTON, sourceNPI,
						sourceAddress);

				// manup:10mar10:bug fix:for ufone enquire link request needs
				// to be sent to server
				// sending enquireLink message repeatedly after sometime

				// if (operatorname.equalsIgnoreCase("UFONE")) {
				Timer timer = new Timer();
				timer.schedule(this.new EnquieLinkTimer(),
						GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000,
						GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000);
				// }

				logger.info("Bind Response Id - " + bindResp);
				logger.info(Thread.currentThread() + " Successfully bound..."
						+ hostName + " " + port);

				wait();
			}

			myConnection.closeLink();
			// manup 8mar10 trying to fix a bug where receiver
			// stops working after 3 hrs approx.
			throw new ApplicationException(Constants.APP_ERROR_IN_CONNECTION,
					"Connection has closed for operator[" + operatorname
							+ "] and shortcode[" + shortCode + "] hostName"
							+ hostName + " port" + port
							+ "...we need to create new connection");
		} catch (ApplicationException x) {
			//logger.error(x.getId() + " - " + x.getMessage());
			// manup 8mar10 trying to fix a bug where receiver
			// stops working after 3 hrs approx.
			throw x;
		} catch (Exception x) {
			//logger.error(x);
			// manup 8mar10 trying to fix a bug where receiver
			// stops working after 3 hrs approx.
			throw x;
		}

	}

	/**
	 * Loads configuration parameters from the file with the given name. Sets
	 * private variable to the loaded values.
	 */
	public void loadProperties(GmlcConfiguration config)
			throws ApplicationException {
		logger.info("Setting default parameters from database.."+config);
		operatorname = config.getOperatorname();
		CommonFunctions.checkNull("operatorname", operatorname);

		try {
			shortCode = config.getShortcode();
			// Integer.parseInt(shortCode);
		} catch (Exception e) {
			throw new ApplicationException(
					"Cannot send sms..shortCode is not configured properly");
		}

		hostName = config.getSmsrhostname();
		CommonFunctions.checkNull("hostName", hostName);

		try {
			port = Integer.parseInt(config.getSmsrport());
		} catch (Exception e) {
			throw new ApplicationException(
					"Cannot send sms..port is not configured properly");
		}

		systemID = config.getSmsrsystemid();
		CommonFunctions.checkNull("systemID", systemID);
		password = config.getSmsrpassword();
		CommonFunctions.checkNull("password", password);
		systemType = config.getSmsrsystemtype();

		try {
			sourceTON = Integer.parseInt(config.getSmsrsourceton());
		} catch (Exception e) {
		}

		try {
			sourceNPI = Integer.parseInt(config.getSmsrsourcenpi());
		} catch (Exception e) {
		}

		sourceAddress = config.getSmsrsourceaddress();

		// smsReceiverUrl = config.getSmsreceiverurl();
		// CommonFunctions.checkNull("smsReceiverUrl", smsReceiverUrl);

		logger.info("values set from database are.." + "hostName.." + hostName
				+ ",port.." + port + ",systemID.." + systemID + ",password.."
				+ password + ",systemType.." + systemType + ",sourceTON.."
				+ sourceTON + ",sourceNPI.." + sourceNPI + ",sourceAddress.."
				+ sourceAddress);
	}

	private void checkNull(String name, String value)
			throws ApplicationException {
		if (value == null && value.trim().equals("")) {
			throw new ApplicationException("Cannot send sms.." + name
					+ " is not configured");
		}
	}

	private class EnquieLinkTimer extends TimerTask {
		@Override
		public void run() {
			try {
				myConnection.enquireLink();
			} catch (Exception e) {
				logger.error(e.getMessage(), e.fillInStackTrace());
				logger.error("Closing EnquieLinkTimer thread.."
						+ Thread.currentThread());
				this.cancel();
			}

		}

	}

	public void setFlag() {
		stopFlag = true;
	}

	public void send(String mdn, String sms, String shortcode) throws Exception{
		logger.info("called..");
		logger.info("Sending SMS["+sms+"] to User["+mdn+"]");
		// Submit a simple message
		// sm.setDestination(new Address(0, 0, "3188332314"));
		// sm.setMessageText("This is an example short message.");

		String[] smsPart = CommonFunctions.splitSMS(sms);
		for (int i = 0; i < smsPart.length; i++) {
			if (smsPart[i] == null || smsPart[i].trim().equals("")) {
				continue;
			}
			String shortMessage = smsPart[i];
			
			logger.info("myConnection "+myConnection.getState());
			SubmitSM sm = (SubmitSM) myConnection
					.newInstance(SMPPPacket.SUBMIT_SM);
			logger.info("SubmitSM "+sm);

			sm.setDestination(new Address(1, 1, mdn));
			sm.setMessageText(shortMessage);
			if(shortcode!=null){
				sm.setSource(new Address(1,1,shortcode));				
			}
			logger.info("Finally Sending SMS["+shortMessage+"] to User["+mdn+"]");
			SubmitSMResp smr = (SubmitSMResp) myConnection.sendRequest(sm);
			logger.info("SMS Success to User["+mdn+"] Submitted message ID: " + smr.getMessageId());
		}
		
		logger.info("ended..");
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}



}
