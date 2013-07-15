package org.ariose.util;

import ie.omk.smpp.Connection;
import ie.omk.smpp.event.ConnectionObserver;
import ie.omk.smpp.event.ReceiverExitEvent;
import ie.omk.smpp.event.SMPPEvent;
import ie.omk.smpp.message.DeliverSM;
import ie.omk.smpp.message.SMPPPacket;
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

	String hostName = "10.82.250.50";
	int port = 5120;
	String systemID = "LBS";
	String password = "123";
	String systemType;
	int sourceTON;
	int sourceNPI;
	String sourceAddress;
	Connection myConnection;
	String mobileNo;
	/**
	 * File with default settings for the application.
	 */
	static String propsFilePath = "smppReceiver.cfg";
	EventLoggingDAO dao = null;
	public boolean stopFlag;

	public void setEventLoggingDAO(EventLoggingDAO eventDao) {
		logger.info("called..");
		this.dao = eventDao;
	}

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
			logger.error(e.getMessage(), e.fillInStackTrace());
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

		logger.info("input stream is.." + propsFile);
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
		
		
		
		//TODO bomber
		if(stopFlag){
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
				
				
				try {
					String queryString = getQueryStringFromPacket(pak);
					logger.warn("PACKET RECEIVED****" +queryString);		

					// if(queryString == null){
					// logger.error("No parameters to send at.."+GmlcConstants.SEND_SMS_URL);
					// } else {
					logger.info("Sending sms to url..");
					if (dao != null)
						dao.saveSubsRequestLog(operatorname, 0,
								GmlcConstants.LOG_CIRCLE_NAME,
								GmlcConstants.LOG_CIRCLE_ID,
								GmlcConstants.LOG_PACK_NAME,
								GmlcConstants.LOG_PACK_ID, mobileNo,
								"sms received",
								GmlcConstants.LOG_CHANNELID_RECEIVEDSMS, null,
								"41", shortCode,"");

					CommonFunctions.sendPostRequest(GmlcConstants.SEND_SMS_URL,
							queryString);
					dao.saveSubsRequestLog(operatorname, 0,
							GmlcConstants.LOG_CIRCLE_NAME,
							GmlcConstants.LOG_CIRCLE_ID,
							GmlcConstants.LOG_PACK_NAME,
							GmlcConstants.LOG_PACK_ID, mobileNo,
							"received sms sent",
							GmlcConstants.LOG_CHANNELID_RECEIVEDSMS, null,
							"42", shortCode,"");
					// }
				} catch (Exception e) {
					if (dao != null)
						dao.saveSubsRequestLog(operatorname,
								GmlcConstants.LOG_OPERATOR_ID,
								GmlcConstants.LOG_CIRCLE_NAME,
								GmlcConstants.LOG_CIRCLE_ID,
								GmlcConstants.LOG_PACK_NAME,
								GmlcConstants.LOG_PACK_ID, mobileNo, (e
										.getMessage().length() < 45) ? e
										.getMessage() : e.getMessage()
										.substring(0, 45),
								GmlcConstants.LOG_CHANNELID_RECEIVEDSMS, null,
								"43", shortCode,"");
					logger
							.error(
									"could not send recieved sms to application via http..",
									e.fillInStackTrace());
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
				logger.warn("Exception", x);
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
		String queryString = null;
		String userId = GmlcConstants.USER_ID;
		String text = GmlcConstants.TEXT;
		// String operatorId=GmlcConstants.OPERATOR_ID;
		String operatorId = operatorname;
		String rcvdShortcode = null;
		try {
			userId = pak.getSource().getAddress();
			rcvdShortcode = pak.getDestination().getAddress();
			if (rcvdShortcode == null || rcvdShortcode.equals("")) {
				throw new ApplicationException(
						"Rejecting sms since shortcode received is empty");
			}

			/*
			 * if (rcvdShortcode.length() > 4 && !rcvdShortcode.substring(0,
			 * 4).equals(shortCode)) { throw new ApplicationException(
			 * "Rejecting sms since shortcode received from packet is not the one configured"
			 * ); }
			 */

			text = ((DeliverSM) pak).getMessageText();
		} catch (ApplicationException e) {
			logger.error(e.getMessage(), e.fillInStackTrace());
			throw e;
		}

		mobileNo = userId;
		queryString = "USER_ID=" + userId + "&TEXT=" + text + "&OPERATOR_ID="
				+ operatorId + "&SHORT_CODE=" + rcvdShortcode;

		return queryString;
	}

	private void receiverExit(Connection myConnection, ReceiverExitEvent ev) {
		if (ev.getReason() != ReceiverExitEvent.EXCEPTION) {
			if (ev.getReason() == ReceiverExitEvent.BIND_TIMEOUT) {
				logger.info("Bind timed out waiting for response.");
			}
			logger.info("Receiver thread has exited: " + ev.getReason());
		} else {
			Throwable t = ev.getException();
			logger.info("Receiver thread died due to exception:");
			logger.warn("Exception", t);
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

			logger.error("Binding to SMSC with systemID " + systemID
					+ "ShortCode: " + shortCode + " Operator " + operatorname
					+ " hostName" + hostName + " port" + port);

			synchronized (this) {
				myConnection.bind(Connection.RECEIVER, systemID, password,
						systemType, sourceTON, sourceNPI, sourceAddress);

				// manup:10mar10:bug fix:for ufone enquire link request needs
				// to be sent to server
				// sending enquireLink message repeatedly after sometime

//				if (operatorname.equalsIgnoreCase("UFONE")) {
					Timer timer = new Timer();
					timer.schedule(this.new EnquieLinkTimer(),
							GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000,
							GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000);
//				}

				logger.info("Waiting for unbind...");
				wait();
			}

			myConnection.closeLink();
			// manup 8mar10 trying to fix a bug where receiver
			// stops working after 3 hrs approx.
			throw new ApplicationException(
					"Connection has closed for operator[" + operatorname
							+ "] and shortcode[" + shortCode
							+ "] hostName" + hostName + " port" + port+"...we need to create new connection");
		} catch (Exception x) {
			logger.error("error when binding SMPP receiver..for operator["
					+ operatorname + "] and shortcode[" + shortCode + "]"
					+ " hostName" + hostName + " port" + port, x
					.fillInStackTrace());
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
		logger.info("Setting default parameters from database..");
		operatorname = config.getOperatorname();
		CommonFunctions.checkNull("operatorname", operatorname);

		try {
			shortCode = config.getShortcode();
			Integer.parseInt(shortCode);
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
		stopFlag=true;
	}
}
