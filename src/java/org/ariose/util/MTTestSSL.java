package org.ariose.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

public class MTTestSSL {
	private static Log log = LogFactory.getLog(MTTestSSL.class);

	static {
		System.setProperty("javax.net.ssl.trustStore",
				"/usr/ariose/SDP_Prod_KeyStore");
	}

	static BASE64Encoder encoder = new BASE64Encoder();

	public static void sendSMS(String requestXml) throws ApplicationException {
		log.info("called REQUEST is ["+requestXml+"] ");
		String userName = Constants.DEFAULT_USERNAME;
		String password = Constants.DEFAULT_PASSWORD;
		try {

			URL httpsURL = new URL(Constants.SMS_URL);
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					if (urlHostName.equals(session.getPeerHost()))
						log.info("Verified" + session.getPeerHost() + ">>>>"
								+ urlHostName);
					else
						log.info("Warning: URL host '" + urlHostName
								+ " is different to SSLSession host "
								+ session.getPeerHost() + "'.");
					return true;
				}
			};
			log.info("setting default host name verifier");
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			HttpsURLConnection urlconn = (HttpsURLConnection) httpsURL
					.openConnection();

			// Get xml message from input file
			// File inputFile = new File(fileName);
			// FileInputStream in = new FileInputStream(requestXml);
			// byte bt[] = new byte[(int) inputFile.length()];
			// in.read(bt);
			// String xmlMsg = new String(bt);
			// in.close();
			// log.info("XML file read" + fileName);
			// Get the HTTP connection setup start time
			Calendar cal_csu = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
			String csu_starttime = sdf.format(cal_csu.getTime());
			long csu_startmillis = System.currentTimeMillis();
			// Create connection to the server
			// #URL url = new URL(server);
			// HttpURLConnection urlconn =
			// (HttpURLConnection)url.openConnection();

			// Set connection parms
			urlconn.setDoOutput(true);
			urlconn.setDoInput(true);
			urlconn.setRequestMethod("POST");
			urlconn.setRequestProperty("Connection", "Keep-Alive");
			urlconn.setRequestProperty("Keep-Alive", "header");
			urlconn.setRequestProperty("Content-Type", "text/xml");
			// Set connection authorization
			String userInfo = userName + ":" + password;
			byte[] userInfoBytes = userInfo.getBytes(); // I18n bug here!
			String authInfo = "Basic " + encoder.encode(userInfoBytes);
			urlconn.setRequestProperty("Authorization", authInfo);
			log.info("\nRequest:" + urlconn.toString());
			log.info("\nHTTPS connection established.  Sending xml request...\n");
			// Get an output stream on the connection and create a writer
			OutputStream out = urlconn.getOutputStream();
			Writer wout = new OutputStreamWriter(out);
			wout.write(requestXml);
			// Print the xml request message to the console
			log.info("xml Request Msg: " + requestXml + "\n");
			log.info("xml request message sent.  Waiting for response...\n");
			// Get the start time
			Calendar cal = Calendar.getInstance();
			String startTime = sdf.format(cal.getTime());
			long startmillis = System.currentTimeMillis();
			// Send the xml message using the HTTP connection

			log.info("xml message sent");

			// Closing connections
			wout.flush();
			wout.close();
			String resp = urlconn.getResponseMessage();
			log.info("Response From server:" + "\n" + resp);
			int resp_code = urlconn.getResponseCode();
			log.info("Response From server:" + "\n" + resp_code);
			if (resp_code != Constants.SMS_SUCCESS_RESPONSE_CODE) {
				InputStream error = urlconn.getErrorStream();
				log.error("Error Response From server:" + "\n" + error);
				throw new ApplicationException(
						Constants.ERR_SMS_RESPCODE_FAILURE,
						"Response code is not 202, it is - " + resp_code);
			}

			Calendar cal2 = Calendar.getInstance();
			String endTime = sdf.format(cal2.getTime());
			long endmillis = System.currentTimeMillis();
			long csu_elapsedTime = (startmillis - csu_startmillis);
			long elapsedTime = (endmillis - startmillis);
			// Print performance summary
			log.info("\nHTTP setup start  : " + csu_starttime);
			log.info("HTTP setup ms       : " + csu_elapsedTime + "\n");
			log.info("xmlRequest sent    : " + startTime);
			log.info("xmlResponse rcvd   : " + endTime);
			log.info("Elapsed time ms     : " + elapsedTime);

		}
		// catch exceptions
		catch (IOException e) {
			log.error(e);
			throw new ApplicationException(Constants.ERR_SMS_SENDING,
					"Connection Issue");
		} catch (ApplicationException e) {
			log.error(e);
			throw e;
		}
	} // end main

//	String REQUEST_XML_FORMAT = "";
//
//	public void sendSMS(Long subscriberNo, String sms)
//			throws ApplicationException {
//		String requestXML = REQUEST_XML_FORMAT.replace("$MDN",
//				"" + subscriberNo).replace("$SMS", sms);
//		sendSMS(requestXML);
//	}
} // end SendxmlMsg
