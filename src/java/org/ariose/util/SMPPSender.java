package org.ariose.util;

/*
 * Copyright (c) 1996-2001
 * Logica Mobile Networks Limited
 * All rights reserved.
 *
 * This software is distributed under Logica Open Source License Version 1.0
 * ("Licence Agreement"). You shall use it and distribute only in accordance
 * with the terms of the License Agreement.
 *
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.GmlcConfiguration;

import com.logica.smpp.Data;
import com.logica.smpp.Session;
import com.logica.smpp.TCPIPConnection;
import com.logica.smpp.pdu.Address;
import com.logica.smpp.pdu.AddressRange;
import com.logica.smpp.pdu.BindReceiver;
import com.logica.smpp.pdu.BindRequest;
import com.logica.smpp.pdu.BindResponse;
import com.logica.smpp.pdu.BindTransciever;
import com.logica.smpp.pdu.BindTransmitter;
import com.logica.smpp.pdu.CancelSM;
import com.logica.smpp.pdu.CancelSMResp;
import com.logica.smpp.pdu.DataSM;
import com.logica.smpp.pdu.DataSMResp;
import com.logica.smpp.pdu.DestinationAddress;
import com.logica.smpp.pdu.EnquireLink;
import com.logica.smpp.pdu.EnquireLinkResp;
import com.logica.smpp.pdu.PDU;
import com.logica.smpp.pdu.QuerySM;
import com.logica.smpp.pdu.QuerySMResp;
import com.logica.smpp.pdu.ReplaceSM;
import com.logica.smpp.pdu.ReplaceSMResp;
import com.logica.smpp.pdu.SubmitMultiSM;
import com.logica.smpp.pdu.SubmitMultiSMResp;
import com.logica.smpp.pdu.SubmitSM;
import com.logica.smpp.pdu.SubmitSMResp;
import com.logica.smpp.pdu.UnbindResp;
import com.logica.smpp.pdu.WrongLengthOfStringException;

/**
 * Class <code>SMPPTest</code> provides all methods necessary for communication
 * with SMSC using the SMPP protocol.
 */
public class SMPPSender {
	private static Log log = LogFactory.getLog(SMPPSender.class);

	static final String copyright = "Copyright (c) 1996-2001 Logica Mobile Networks Limited\n"
			+ "This product includes software developed by Logica by whom copyright\n"
			+ "and know-how are retained, all rights reserved.\n";

	static {
		log.info(copyright);
	}

	/**
	 * Directory for creating of debug and event files.
	 */
	static final String dbgDir = "./";

	/**
	 * The debug object.
	 */
	// static Debug debug = new FileDebug(dbgDir, "test.dbg");
	/**
	 * The event object.
	 */
	// static Event event = new FileEvent(dbgDir, "test.evt");
	/**
	 * File with default settings for the application.
	 */
	static String propsFilePath = "smppSender.cfg";

	String operatorName;
	String shortCode;

	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(
			System.in));

	/**
	 * This is the SMPP session used for communication with SMSC.
	 * 
	 * @see com.logica.smpp.Session
	 */
	Session session = null;

	/**
	 * Contains the parameters and default values for this test application such
	 * as system id, password, default npi and ton of sender etc.
	 */
	Properties properties = new Properties();

	/**
	 * If the application is bound to the SMSC.
	 */
	boolean bound = false;

	/**
	 * If the application has to keep reading commands from the keyboard and to
	 * do what's requested.
	 */
	private boolean keepRunning = true;

	/**
	 * Address of the SMSC.
	 */
	String ipAddress = null;

	/**
	 * The port number to bind to on the SMSC server.
	 */
	int port = 0;

	/**
	 * The name which identifies you to SMSC.
	 */
	String systemId = null;

	/**
	 * The password for authentication to SMSC.
	 */
	String password = null;

	/**
	 * How you want to bind to the SMSC: transmitter (t), receiver (r) or
	 * transciever (tr). Transciever can both send messages and receive
	 * messages. Note, that if you bind as receiver you can still receive
	 * responses to you requests (submissions).
	 */
	String bindOption = "t";

	/**
	 * The range of addresses (mobile numbers) you want to receive messages
	 * from.
	 */
	AddressRange addressRange = new AddressRange();

	/*
	 * for information about these variables have a look in SMP 3.4
	 * specification
	 */
	String systemType = "";
	String serviceType = "";
	Address sourceAddress = new Address();
	Address destAddress = new Address();
	String scheduleDeliveryTime = "";
	String validityPeriod = "";
	String shortMessage = "";
	String numberOfDestination = "1";
	String messageId = "";
	byte esmClass = 0;
	byte protocolId = 0;
	byte priorityFlag = 0;
	byte registeredDelivery = 0;
	byte replaceIfPresentFlag = 0;
	byte dataCoding = 0;
	byte smDefaultMsgId = 0;

	/**
	 * If you attemt to receive message, how long will the application wait for
	 * data.
	 */
	long receiveTimeout = Data.RECEIVE_BLOCKING;

	public boolean stopFlag = false;

	/**
	 * Initialises the application, lods default values for connection to SMSC
	 * and for various PDU fields.
	 */
	public SMPPSender() throws IOException {
		// loadProperties(propsFilePath);
	}

	/**
	 * Sets global SMPP library debug and event objects. Runs the application.
	 */
	public void exceute(String msisdn, String responseData, String shortCode,
			GmlcConfiguration config) throws Exception {
		try {
			
			log.warn("PACKET SENT****msisdn[" + msisdn + "] responseData["
					+ responseData + "] shortcode[" + shortCode + "]");
			
			//TODO bomber
			if(stopFlag)
				return;
			
			log.info("Thread ID : " + Thread.currentThread());

			// SMPPSender test = new SMPPSender();
			// test.setPropertiesFromConfig(config);
			setDestAddressParameter(msisdn);
			if (shortCode != null)
			setSrcAddressParameter(shortCode);
			// bind();//bind testing

			String[] smsPart = CommonFunctions.splitSMS(responseData);
			// String[] smsPart = new String[]{responseData};
			for (int i = 0; i < smsPart.length; i++) {
				if (smsPart[i] == null || smsPart[i].trim().equals("")) {
					continue;
				}
				shortMessage = smsPart[i];
				submit();
			}

			// bind testing
			// unbind();

		} catch (Exception e) {
			log.error("could not send sms via smpp..", e);
			throw e;
		}
	}

	/**
	 * Displays the menu and lets you choose from available options.
	 */
	public void menu() throws Exception {
		keepRunning = true;
		String option = "1";
		int optionInt;

		while (keepRunning) {
			log.info("-  1 bind");
			log.info("-  2 submit (t/tr)");
			log.info("-  3 submit multi (t/tr)");
			log.info("-  4 data (t/tr)");
			log.info("-  5 query (t/tr)");
			log.info("-  6 replace (t/tr)");
			log.info("-  7 cancel (t/tr)");
			log.info("-  8 enquire link (t/tr)");
			log.info("-  9 unbind");
			log.info("- 10 receive message (tr/r)");
			log.info("-  0 exit");
			System.out.print("> ");
			optionInt = -1;
			try {
				option = keyboard.readLine();
				optionInt = Integer.parseInt(option);
			} catch (Exception e) {
				// debug.write("exception reading keyboard " + e);
				optionInt = -1;
			}
			switch (optionInt) {
			case 1:
				bind();
				break;
			case 2:
				submit();
				break;
			case 3:
				submitMulti();
				break;
			case 4:
				data();
				break;
			case 5:
				query();
				break;
			case 6:
				replace();
				break;
			case 7:
				cancel();
				break;
			case 8:
				enquireLink();
				break;
			case 9:
				unbind();
				break;
			case 10:
				receive();
				break;
			case 0:
				exit();
				break;
			case -1:
				// default option if entering an option went wrong
				break;
			default:
				log.info("Invalid option. Choose between 1 and 11.");
				break;
			}
		}
	}

	/**
	 * The first method called to start communication betwen an ESME and a SMSC.
	 * A new instance of <code>TCPIPConnection</code> is created and the IP
	 * address and port obtained from user are passed to this instance. New
	 * <code>Session</code> is created which uses the created
	 * <code>TCPIPConnection</code>. All the parameters required for a bind are
	 * set to the <code>BindRequest<code>
	 * and this request is passed to the <code>Session</code>'s
	 * <code>bind</code> method. If the call is successful, the application
	 * should be bound to the SMSC.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.1 BIND Operation."
	 */
	public void bind() throws Exception {
		log.info("SMPPTest.bind() called..");
		try {

			if (bound) {
				log.info("Already bound, unbind first.");
				return;
			}

			BindRequest request = null;
			BindResponse response = null;

			log.info("bindOption.." + bindOption);
			if (bindOption.compareToIgnoreCase("t") == 0) {
				request = new BindTransmitter();
			} else if (bindOption.compareToIgnoreCase("r") == 0) {
				request = new BindReceiver();
			} else if (bindOption.compareToIgnoreCase("tr") == 0) {
				request = new BindTransciever();
			} else {
				log.error("Invalid bind mode, expected t, r or tr, got "
						+ bindOption + " Operation canceled.");
				return;
			}

			log.info("ipAddress.." + ipAddress);
			log.info("port.." + port);
			TCPIPConnection connection = new TCPIPConnection(ipAddress, port);
			connection.setReceiveTimeout(GmlcConstants.CONNECTION_RCV_TIMEOUT);
			session = new Session(connection);

			log.info("systemId.." + systemId);
			log.info("password.." + password);
			log.info("systemType.." + systemType);
			log.info("addressRange.." + addressRange);

			request.setSystemId(systemId);
			request.setPassword(password);
			request.setSystemType(systemType);
			request.setInterfaceVersion((byte) 0x34);
			request.setAddressRange(addressRange);

			// send the request
			log.info("Bind request " + request.debugString());
			response = session.bind(request);
			log.info("Bind response " + response.debugString());
			log.info("Response CMD Status "+response.getCommandStatus());
			if (response.getCommandStatus() == Data.ESME_ROK) {
				log.info("SUCCESS");
				bound = true;
			}

			// manup:10mar10:bug fix:for ufone enquire link request needs
			// to be sent to server
			// sending enquireLink message repeatedly after sometime
			if (operatorName.equalsIgnoreCase("UFONE")) {
				Timer timer = new Timer();
				timer.schedule(this.new EnquieLinkTimer(),
						GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000,
						GmlcConstants.ENQUIRELINK_TIMER_TIME * 1000);
			}

		} catch (Exception e) {
			log.error("Bind operation failed. ", e);
			throw e;
		} finally {
		}
	}

	/**
	 * Ubinds (logouts) from the SMSC and closes the connection.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.2 UNBIND Operation."
	 */
	public void unbind() throws Exception {
		log.info("SMPPTest.unbind() called..");
		// debug.enter(this, "SMPPTest.unbind()");
		try {

			if (!bound) {
				log.info("Not bound, cannot unbind.");
				return;
			}

			// send the request
			log.info("Going to unbind.");
			if (session.getReceiver().isReceiver()) {
				log.info("It could take a while to stop the receiver.");
			}
			UnbindResp response = session.unbind();
			log.info("Unbind response " + response.debugString());
			bound = false;

		} catch (Exception e) {
			// //event.write(e,"");
			// //debug.write("Unbind operation failed. " + e);
			log.error("Unbind operation failed. ", e);
			throw e;
		} finally {
			// //debug.exit(this);
		}
	}

	public void setUnbindFlag() {
		bound = false;
	}

	/**
	 * Creates a new instance of <code>SubmitSM</code> class, lets you set
	 * subset of fields of it. This PDU is used to send SMS message to a
	 * specific device.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.4 SUBMIT_SM Operation."
	 */
	private void submit() throws Exception {
		log.info("SMPPTest.submit() called..");
		// debug.enter(this, "SMPPTest.submit()");

		try {
			SubmitSM request = new SubmitSM();
			SubmitSMResp response;

			// input values
			// serviceType = getParam("Service type", serviceType);
			// sourceAddress = getAddress("Source", sourceAddress);
			// destAddress = getAddress("Destination", destAddress);
			// replaceIfPresentFlag = getParam("Replace if present flag",
			// replaceIfPresentFlag);
			// shortMessage = getParam("The short message", shortMessage);
			// scheduleDeliveryTime = getParam("Schedule delivery time",
			// scheduleDeliveryTime);
			// validityPeriod = getParam("Validity period", validityPeriod);
			// esmClass = getParam("Esm class", esmClass);
			// protocolId = getParam("Protocol id", protocolId);
			// priorityFlag = getParam("Priority flag", priorityFlag);
			// registeredDelivery = getParam("Registered delivery",
			// registeredDelivery);
			// dataCoding = getParam("Data encoding", dataCoding);
			// smDefaultMsgId = getParam("Sm default msg id", smDefaultMsgId);

			// set values
			request.setServiceType(serviceType);
			request.setSourceAddr(sourceAddress);
			request.setDestAddr(destAddress);
			request.setReplaceIfPresentFlag(replaceIfPresentFlag);
			request.setShortMessage(shortMessage);
			request.setScheduleDeliveryTime(scheduleDeliveryTime);
			request.setValidityPeriod(validityPeriod);
			request.setEsmClass(esmClass);
			request.setProtocolId(protocolId);
			request.setPriorityFlag(priorityFlag);
			request.setRegisteredDelivery(registeredDelivery);
			request.setDataCoding(dataCoding);
			request.setSmDefaultMsgId(smDefaultMsgId);

			// send the request
			log.info("Submit request " + request.debugString());
			log.info("session.." + session);

			log.error("Bound State of the session is : " + session.isBound());
			log.error("Opened State of the session is : " + session.isOpened());
			// log.error("State of the session is : " + session.getState());

			response = session.submit(request);
			if (response.getCommandStatus() == Data.ESME_ROK) {
				log.error("Message submitted ...\n");
			} else {
				log.error("message failed Status = "
						+ response.getCommandStatus());
			}
			// log.info("response.."+response);
			// log.info("Submit response " + response.debugString());
			messageId = response.getMessageId();

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Submit operation failed. " + e);
			log.error("Submit operation failed. ", e);
			throw e;
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>SubmitMultiSM</code> class, lets you set
	 * subset of fields of it. This PDU is used to send SMS message to a
	 * multiple devices.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.5 SUBMIT_MULTI Operation."
	 */
	private void submitMulti() {
		// debug.enter(this, "SMPPTest.submitMulti()");

		try {
			SubmitMultiSM request = new SubmitMultiSM();
			SubmitMultiSMResp response;

			// input values and set some :-)
			serviceType = getParam("Service type", serviceType);
			sourceAddress = getAddress("Source", sourceAddress);
			numberOfDestination = getParam("Number of destinations",
					numberOfDestination);
			for (int i = 0; i < Integer.parseInt(numberOfDestination); i++) {
				request.addDestAddress(new DestinationAddress(getAddress(
						"Destination", destAddress)));
			}
			replaceIfPresentFlag = getParam("Replace if present flag",
					replaceIfPresentFlag);
			shortMessage = getParam("The short message", shortMessage);
			scheduleDeliveryTime = getParam("Schdule delivery time",
					scheduleDeliveryTime);
			validityPeriod = getParam("Validity period", validityPeriod);
			esmClass = getParam("Esm class", esmClass);
			protocolId = getParam("Protocol id", protocolId);
			priorityFlag = getParam("Priority flag", priorityFlag);
			registeredDelivery = getParam("Registered delivery",
					registeredDelivery);
			dataCoding = getParam("Data encoding", dataCoding);
			smDefaultMsgId = getParam("Sm default msg id", smDefaultMsgId);

			// set other values
			request.setServiceType(serviceType);
			request.setSourceAddr(sourceAddress);
			request.setReplaceIfPresentFlag(replaceIfPresentFlag);
			request.setShortMessage(shortMessage);
			request.setScheduleDeliveryTime(scheduleDeliveryTime);
			request.setValidityPeriod(validityPeriod);
			request.setEsmClass(esmClass);
			request.setProtocolId(protocolId);
			request.setPriorityFlag(priorityFlag);
			request.setRegisteredDelivery(registeredDelivery);
			request.setDataCoding(dataCoding);
			request.setSmDefaultMsgId(smDefaultMsgId);

			// send the request
			log.info("Submit Multi request " + request.debugString());
			response = session.submitMulti(request);
			log.info("Submit Multi response " + response.debugString());
			messageId = response.getMessageId();

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Submit Multi operation failed. " + e);
			log.info("Submit Multi operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>ReplaceSM</code> class, lets you set
	 * subset of fields of it. This PDU is used to replace certain attributes of
	 * already submitted message providing that you 'remember' message id of the
	 * submitted message. The message id is assigned by SMSC and is returned to
	 * you with the response to the submision PDU (SubmitSM, DataSM etc.).
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.10 REPLACE_SM Operation."
	 */
	private void replace() {
		// debug.enter(this, "SMPPTest.replace()");
		try {
			ReplaceSM request = new ReplaceSM();
			ReplaceSMResp response;

			// input values
			messageId = getParam("Message id", messageId);
			sourceAddress = getAddress("Source", sourceAddress);
			shortMessage = getParam("The short message", shortMessage);
			scheduleDeliveryTime = getParam("Schedule delivery time",
					scheduleDeliveryTime);
			validityPeriod = getParam("Validity period", validityPeriod);
			registeredDelivery = getParam("Registered delivery",
					registeredDelivery);
			smDefaultMsgId = getParam("Sm default msg id", smDefaultMsgId);

			// set values
			request.setMessageId(messageId);
			request.setSourceAddr(sourceAddress);
			request.setShortMessage(shortMessage);
			request.setScheduleDeliveryTime(scheduleDeliveryTime);
			request.setValidityPeriod(validityPeriod);
			request.setRegisteredDelivery(registeredDelivery);
			request.setSmDefaultMsgId(smDefaultMsgId);

			// send the request
			log.info("Replace request " + request.debugString());
			response = session.replace(request);
			log.info("Replace response " + response.debugString());

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Replace operation failed. " + e);
			log.info("Replace operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>CancelSM</code> class, lets you set
	 * subset of fields of it. This PDU is used to cancel an already submitted
	 * message. You can only cancel a message which haven't been delivered to
	 * the device yet.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.9 CANCEL_SM Operation."
	 */
	private void cancel() {
		// debug.enter(this, "SMPPTest.cancel()");
		try {
			CancelSM request = new CancelSM();
			CancelSMResp response;

			// input values
			serviceType = getParam("Service type", serviceType);
			messageId = getParam("Message id", messageId);
			sourceAddress = getAddress("Source", sourceAddress);
			destAddress = getAddress("Destination", destAddress);

			// set values
			request.setServiceType(serviceType);
			request.setMessageId(messageId);
			request.setSourceAddr(sourceAddress);
			request.setDestAddr(destAddress);

			// send the request
			log.info("Cancel request " + request.debugString());
			response = session.cancel(request);
			log.info("Cancel response " + response.debugString());

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Cancel operation failed. " + e);
			log.info("Cancel operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>DataSM</code> class, lets you set subset
	 * of fields of it. This PDU is an alternative to the <code>SubmitSM</code>
	 * and </code>DeliverSM</code>. It delivers the data to the specified
	 * device.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.7 DATA_SM Operation."
	 */
	private void data() {
		// debug.enter(this, "SMPPTest.data()");

		try {
			DataSM request = new DataSM();
			DataSMResp response;

			// input values
			serviceType = getParam("Service type", serviceType);
			sourceAddress = getAddress("Source", sourceAddress);
			destAddress = getAddress("Destination", destAddress);
			esmClass = getParam("Esm class", esmClass);
			registeredDelivery = getParam("Registered delivery",
					registeredDelivery);
			dataCoding = getParam("Data encoding", dataCoding);

			// set values
			request.setServiceType(serviceType);
			request.setSourceAddr(sourceAddress);
			request.setDestAddr(destAddress);
			request.setEsmClass(esmClass);
			request.setRegisteredDelivery(registeredDelivery);
			request.setDataCoding(dataCoding);

			// send the request
			log.info("Data request " + request.debugString());
			response = session.data(request);
			log.info("Data response " + response.debugString());
			messageId = response.getMessageId();

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Data operation failed. " + e);
			log.info("Data operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>QuerySM</code> class, lets you set subset
	 * of fields of it. This PDU is used to fetch information about status of
	 * already submitted message providing that you 'remember' message id of the
	 * submitted message. The message id is assigned by SMSC and is returned to
	 * you with the response to the submision PDU (SubmitSM, DataSM etc.).
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.8 QUERY_SM Operation."
	 */
	private void query() {
		// debug.enter(this, "SMPPTest.query()");
		try {
			QuerySM request = new QuerySM();
			QuerySMResp response;

			// input values
			messageId = getParam("Message id", messageId);
			sourceAddress = getAddress("Source", sourceAddress);

			// set values
			request.setMessageId(messageId);
			request.setSourceAddr(sourceAddress);

			// send the request
			log.info("Query request " + request.debugString());
			response = session.query(request);
			log.info("Query response " + response.debugString());
			messageId = response.getMessageId();

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Query operation failed. " + e);
			log.info("Query operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Creates a new instance of <code>EnquireSM</code> class. This PDU is used
	 * to check that application level of the other party is alive. It can be
	 * sent both by SMSC and ESME.
	 * 
	 * See "SMPP Protocol Specification 3.4, 4.11 ENQUIRE_LINK Operation."
	 */
	private void enquireLink() {
		// debug.enter(this, "SMPPTest.enquireLink()");
		try {

			EnquireLink request = new EnquireLink();
			EnquireLinkResp response;
			log.info("Enquire Link request " + request.debugString());
			response = session.enquireLink(request);
			log.info("Enquire Link response " + response.debugString());

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Enquire Link operation failed. " + e);
			log.info("Enquire Link operation failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * Receives one PDU of any type from SMSC and prints it on the screen.
	 */
	private void receive() {
		// debug.enter(this, "SMPPTest.receive()");
		try {

			PDU pdu;
			System.out.print("Going to receive a PDU. ");
			if (receiveTimeout == Data.RECEIVE_BLOCKING) {
				System.out
						.print("The receive is blocking, i.e. the application "
								+ "will stop until a PDU will be received.");
			} else {
				System.out.print("The receive timeout is " + receiveTimeout
						/ 1000 + " sec.");
			}
			pdu = session.receive(receiveTimeout);
			if (pdu != null) {
				log.info("Received PDU " + pdu.debugString());
			} else {
				log.info("No PDU received this time.");
			}

		} catch (Exception e) {
			// event.write(e, "");
			// debug.write("Receiving failed. " + e);
			log.info("Receiving failed. " + e);
		} finally {
			// debug.exit(this);
		}
	}

	/**
	 * If bound, unbinds and then exits this application.
	 */
	private void exit() throws Exception {
		// debug.enter(this, "SMPPTest.exit()");
		if (bound) {
			unbind();
		}
		keepRunning = false;
		// debug.exit(this);
	}

	/**
	 * Prompts the user to enter a string value for a parameter.
	 */
	private String getParam(String prompt, String defaultValue) {
		String value = "";
		String promptFull = prompt;
		promptFull += defaultValue == null ? "" : " [" + defaultValue + "] ";
		System.out.print(promptFull);
		try {
			value = keyboard.readLine();
		} catch (IOException e) {
			// event.write(e, "");
			// debug.write("Got exception getting a param. " + e);
		}
		if (value.compareTo("") == 0) {
			return defaultValue;
		} else {
			return value;
		}
	}

	/**
	 * Prompts the user to enter a byte value for a parameter.
	 */
	private byte getParam(String prompt, byte defaultValue) {
		return Byte.parseByte(getParam(prompt, Byte.toString(defaultValue)));
	}

	/**
	 * Prompts the user to enter an integer value for a parameter.
	 */
	private int getParam(String prompt, int defaultValue) {
		return Integer
				.parseInt(getParam(prompt, Integer.toString(defaultValue)));
	}

	/**
	 * Prompts the user to enter an address value.
	 */
	private Address getAddress(String type, Address address)
			throws WrongLengthOfStringException {
		byte ton = getParam(type + " address TON", address.getTon());
		byte npi = getParam(type + " address NPI", address.getNpi());
		String addr = getParam(type + " address", address.getAddress());
		address.setTon(ton);
		address.setNpi(npi);
		address.setAddress(addr);
		return address;
	}

	/**
	 * Loads configuration parameters from the file with the given name. Sets
	 * private variable to the loaded values.
	 */
	public void setPropertiesFromConfig(GmlcConfiguration config)
			throws Exception {
		log.info("Setting default parameters...");
		byte ton;
		byte npi;
		String addr;
		String bindMode;
		int rcvTimeout;

		operatorName = config.getOperatorname();
		shortCode = config.getShortcode();

		ipAddress = config.getIpaddress();
//		CommonFunctions.checkNull("ipAddress", ipAddress);

		try {
			port = Integer.parseInt(config.getPort());
		} catch (Exception e) {
			throw new Exception(
					"Cannot send sms..port is not configured properly");
		}

		// port = getIntProperty("port", port);
		systemId = config.getSystemid();// properties.getProperty("system-id");
		password = config.getPassword();// properties.getProperty("password");

		try {
			ton = Byte.parseByte(config.getAddrton());
		} catch (Exception e) {
			ton = Byte.parseByte(Byte.toString(addressRange.getTon()));
		}

		try {
			npi = Byte.parseByte(config.getAddrnpi());
		} catch (Exception e) {
			npi = Byte.parseByte(Byte.toString(addressRange.getNpi()));
		}

		if (config.getAddressrange() != null)
			addr = config.getAddressrange();
		else
			addr = addressRange.getAddressRange();

		// ton = getByteProperty("addr-ton", addressRange.getTon());
		// npi = getByteProperty("addr-npi", addressRange.getNpi());
		// addr = properties.getProperty("address-range", addressRange
		// .getAddressRange());
		addressRange.setTon(ton);
		addressRange.setNpi(npi);
		try {
			addressRange.setAddressRange(addr);
		} catch (WrongLengthOfStringException e) {
			log.error("The length of address-range parameter is wrong.");
		}

		try {
			ton = Byte.parseByte(config.getSourceton());
		} catch (Exception e) {
			ton = Byte.parseByte(Byte.toString(sourceAddress.getTon()));
		}
		try {
			npi = Byte.parseByte(config.getSourcenpi());
		} catch (Exception e) {
			npi = Byte.parseByte(Byte.toString(sourceAddress.getNpi()));
		}
		// ton = getByteProperty("source-ton", sourceAddress.getTon());
		// npi = getByteProperty("source-npi", sourceAddress.getNpi());

		if (config.getSourceaddress() != null)
			addr = config.getSourceaddress();
		else
			addr = sourceAddress.getAddress();

		// addr = properties.getProperty("source-address", sourceAddress
		// .getAddress());
		setAddressParameter("source-address", sourceAddress, ton, npi, addr);

		try {
			ton = Byte.parseByte(config.getDestinationton());
		} catch (Exception e) {
			ton = Byte.parseByte(Byte.toString(destAddress.getTon()));
		}
		try {
			npi = Byte.parseByte(config.getDestinationnpi());
		} catch (Exception e) {
			npi = Byte.parseByte(Byte.toString(destAddress.getNpi()));
		}
		// ton = getByteProperty("source-ton", sourceAddress.getTon());
		// npi = getByteProperty("source-npi", sourceAddress.getNpi());
		if (config.getDestinationaddress() != null)
			addr = config.getDestinationaddress();
		else
			addr = destAddress.getAddress();

		// ton = getByteProperty("destination-ton", destAddress.getTon());
		// npi = getByteProperty("destination-npi", destAddress.getNpi());
		// addr = properties.getProperty("destination-address", destAddress
		// .getAddress());
		setAddressParameter("destination-address", destAddress, ton, npi, addr);

		if (config.getServicetype() != null)
			serviceType = config.getServicetype();
		if (config.getSystemtype() != null)
			systemType = config.getSystemtype();
		if (config.getBindmode() != null)
			bindMode = config.getBindmode();
		else
			bindMode = bindOption;
		// serviceType = properties.getProperty("service-type", serviceType);
		// systemType = properties.getProperty("system-type", systemType);
		// bindMode = properties.getProperty("bind-mode", bindOption);
		if (bindMode.equalsIgnoreCase("transmitter")) {
			bindMode = "t";
		} else if (bindMode.equalsIgnoreCase("receiver")) {
			bindMode = "r";
		} else if (bindMode.equalsIgnoreCase("transciever")) {
			bindMode = "tr";
		} else if (!bindMode.equalsIgnoreCase("t")
				&& !bindMode.equalsIgnoreCase("r")
				&& !bindMode.equalsIgnoreCase("tr")) {
			log.info("The value of bind-mode parameter in "
					+ "the database gmlc_configuration table is wrong. "
					+ "Setting the default as t");
			bindMode = "t";
		}
		bindOption = bindMode;

		// receive timeout in the cfg file is in seconds, we need milliseconds
		// also conversion from -1 which indicates infinite blocking
		// in the cfg file to Data.RECEIVE_BLOCKING which indicates infinite
		// blocking in the library is needed.
		if (receiveTimeout == Data.RECEIVE_BLOCKING) {
			rcvTimeout = -1;
		} else {
			rcvTimeout = ((int) receiveTimeout) / 1000;
		}

		if (config.getReceivetimeout() != null)
			rcvTimeout = Integer.parseInt(config.getReceivetimeout());

		// rcvTimeout = getIntProperty("receive-timeout", rcvTimeout);
		if (rcvTimeout == -1) {
			receiveTimeout = Data.RECEIVE_BLOCKING;
		} else {
			receiveTimeout = rcvTimeout * 1000;
		}

		/*
		 * scheduleDeliveryTime validityPeriod shortMessage numberOfDestination
		 * messageId esmClass protocolId priorityFlag registeredDelivery
		 * replaceIfPresentFlag dataCoding smDefaultMsgId
		 */
	}

	/**
	 * Loads configuration parameters from the file with the given name. Sets
	 * private variable to the loaded values.
	 */
	private void loadProperties(String fileName) throws IOException {
		log.info("Reading configuration file " + fileName + "...");
		InputStream propsFile = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);

		log.info("input stream is.." + propsFile);
		properties.load(propsFile);
		propsFile.close();
		log.info("Setting default parameters...");
		byte ton;
		byte npi;
		String addr;
		String bindMode;
		int rcvTimeout;

		ipAddress = properties.getProperty("ip-address");
		port = getIntProperty("port", port);
		systemId = properties.getProperty("system-id");
		password = properties.getProperty("password");

		ton = getByteProperty("addr-ton", addressRange.getTon());
		npi = getByteProperty("addr-npi", addressRange.getNpi());
		addr = properties.getProperty("address-range", addressRange
				.getAddressRange());
		addressRange.setTon(ton);
		addressRange.setNpi(npi);
		try {
			addressRange.setAddressRange(addr);
		} catch (WrongLengthOfStringException e) {
			log.error("The length of address-range parameter is wrong.");
		}

		ton = getByteProperty("source-ton", sourceAddress.getTon());
		npi = getByteProperty("source-npi", sourceAddress.getNpi());
		addr = properties.getProperty("source-address", sourceAddress
				.getAddress());
		setAddressParameter("source-address", sourceAddress, ton, npi, addr);

		ton = getByteProperty("destination-ton", destAddress.getTon());
		npi = getByteProperty("destination-npi", destAddress.getNpi());
		addr = properties.getProperty("destination-address", destAddress
				.getAddress());
		setAddressParameter("destination-address", destAddress, ton, npi, addr);

		serviceType = properties.getProperty("service-type", serviceType);
		systemType = properties.getProperty("system-type", systemType);
		bindMode = properties.getProperty("bind-mode", bindOption);
		if (bindMode.equalsIgnoreCase("transmitter")) {
			bindMode = "t";
		} else if (bindMode.equalsIgnoreCase("receiver")) {
			bindMode = "r";
		} else if (bindMode.equalsIgnoreCase("transciever")) {
			bindMode = "tr";
		} else if (!bindMode.equalsIgnoreCase("t")
				&& !bindMode.equalsIgnoreCase("r")
				&& !bindMode.equalsIgnoreCase("tr")) {
			log.info("The value of bind-mode parameter in "
					+ "the configuration file " + fileName + " is wrong. "
					+ "Setting the default");
			bindMode = "t";
		}
		bindOption = bindMode;

		// receive timeout in the cfg file is in seconds, we need milliseconds
		// also conversion from -1 which indicates infinite blocking
		// in the cfg file to Data.RECEIVE_BLOCKING which indicates infinite
		// blocking in the library is needed.
		if (receiveTimeout == Data.RECEIVE_BLOCKING) {
			rcvTimeout = -1;
		} else {
			rcvTimeout = ((int) receiveTimeout) / 1000;
		}
		rcvTimeout = getIntProperty("receive-timeout", rcvTimeout);
		if (rcvTimeout == -1) {
			receiveTimeout = Data.RECEIVE_BLOCKING;
		} else {
			receiveTimeout = rcvTimeout * 1000;
		}

		/*
		 * scheduleDeliveryTime validityPeriod shortMessage numberOfDestination
		 * messageId esmClass protocolId priorityFlag registeredDelivery
		 * replaceIfPresentFlag dataCoding smDefaultMsgId
		 */
	}

	/**
	 * Gets a property and converts it into byte.
	 */
	private byte getByteProperty(String propName, byte defaultValue) {
		return Byte.parseByte(properties.getProperty(propName, Byte
				.toString(defaultValue)));
	}

	/**
	 * Gets a property and converts it into integer.
	 */
	private int getIntProperty(String propName, int defaultValue) {
		return Integer.parseInt(properties.getProperty(propName, Integer
				.toString(defaultValue)));
	}

	/**
	 * Sets attributes of <code>Address</code> to the provided values.
	 */
	private void setAddressParameter(String descr, Address address, byte ton,
			byte npi, String addr) {
		address.setTon(ton);
		address.setNpi(npi);
		try {
			address.setAddress(addr);
		} catch (WrongLengthOfStringException e) {
			log.error("The length of " + descr + " parameter is wrong.");
		}
	}

	/**
	 * Sets attributes of <code>Address</code> to the provided values.
	 */
	private void setDestAddressParameter(String addr) {
		try {
			destAddress.setAddress(addr);
		} catch (WrongLengthOfStringException e) {
			log.error("The length of destination address"
					+ " parameter is wrong.");
		}
	}

	/**
	 * Sets attributes of <code>Address</code> to the provided values.
	 */
	private void setSrcAddressParameter(String addr) {
		try {
			sourceAddress.setAddress(addr);
		} catch (WrongLengthOfStringException e) {
			log.error("The length of source address" + " parameter is wrong.");
		}
	}

	private class EnquieLinkTimer extends TimerTask {
		@Override
		public void run() {
			try {
				enquireLink();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				log.error("Closing EnquieLinkTimer thread.."
						+ Thread.currentThread());
				this.cancel();
			}

		}

	}

	public void setFlag() {
		stopFlag = true;

	}

	// private void checkNull(String name, String value) throws
	// Exception {
	// if (value == null && value.trim().equals("")) {
	// throw new
	// Exception("Cannot send sms.."+name+" is not configured");
	// }
	// }
}
