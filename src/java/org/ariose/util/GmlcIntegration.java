package org.ariose.util;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.GmlcConfiguration;
import org.ariose.model.GmlcResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class GmlcIntegration {
	private static Log log = LogFactory.getLog(GmlcIntegration.class);
//	static final String LOCATION_SVC_URL = "http://203.99.50.54:9210/LocationService";
//	static final String ID = "root";
//	static final String PWD = "emg_apps1";

	static Map senderMap = null;
	public static void sendPostRequest(String data, GmlcConfiguration config) throws Exception {

		// Build parameter string
		// String data = "width=50&height=100";
		try {

			// Send the request
			log.info("*******sending post request to url:"+config.getLocationsvcurl());
			log.info("*******with request as:"+data);
//			URL url = new URL(GmlcConstants.LOCATION_SVC_URL);
			URL url = new URL(config.getLocationsvcurl());
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter writer = new OutputStreamWriter(conn
					.getOutputStream());

			// write parameters
			writer.write(data);
			writer.flush();

			// Get the response
			StringBuffer answer = new StringBuffer();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				answer.append(line);
			}
			writer.close();
			reader.close();

			// Output the response
			log.info("immediate response from GMLC server is:"+answer.toString());

		} catch (MalformedURLException ex) {
			log.error("could not send request to GMLC server:"+GmlcConstants.LOCATION_SVC_URL
					+" [MalformedURLException]", ex.fillInStackTrace());
			throw ex;			
		} catch (IOException ex) {			
			log.error("could not send request to GMLC server:"+GmlcConstants.LOCATION_SVC_URL +
					"[IOException]", ex.fillInStackTrace());
			throw ex;			
		}
	}

	public static String createXmlRequest(String mobileNo, GmlcConfiguration config, String operatorName) {
		String requestXml = null;
		Document dom = null;
		// create xml
		// get an instance of factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// get an instance of builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			// create an instance of DOM
			dom = db.newDocument();
			createDOMTree(dom, mobileNo, config, operatorName);
			requestXml = getStringFromDocument(dom);

		} catch (ParserConfigurationException pce) {
			// dump it
			log
					.error("Error while trying to instantiate DocumentBuilder "
							+ pce);
		}

		return requestXml;
	}

	/**
	 * The real workhorse which creates the XML structure
	 */
	private static void createDOMTree(Document dom, String mobileNo, GmlcConfiguration config, String operatorName) {

		/*
		 * <svc_init> <hdr> <client> <id>genasys</id> <pwd>secret</pwd>
		 * </client> </hdr> <slir ver="3.0.0" res_type="SYNC"> <pushaddr>
		 * <url>http://localhost:9211/LocationService </url> </pushaddr> <msids>
		 * <msid type="MSISDN">923334000043</msid> </msids> </slir> </svc_init>
		 */

		// create the root element <Books>
		Element rootEle = dom.createElement("svc_init");
		dom.appendChild(rootEle);
		Element hdrEle = createHdrElement(dom, config);
		rootEle.appendChild(hdrEle);
		Element slirEle = createSlirElement(mobileNo, dom, operatorName);
		rootEle.appendChild(slirEle);
	}

	private static Element createHdrElement(Document dom, GmlcConfiguration config) {
		/*
		 * <hdr> <client> <id>genasys</id> <pwd>secret</pwd> </client> </hdr>
		 */
		Element hdrEle = dom.createElement("hdr");
		Element clientEle = dom.createElement("client");
		Element idEle = dom.createElement("id");
		Element pwdEle = dom.createElement("pwd");
		Text idText = dom.createTextNode(config.getLocationsvcuserid());
		Text pwdText = dom.createTextNode(config.getLocationsvcpwd());

		idEle.appendChild(idText);
		pwdEle.appendChild(pwdText);
		clientEle.appendChild(idEle);
		clientEle.appendChild(pwdEle);
		hdrEle.appendChild(clientEle);

		return hdrEle;
	}

	private static Element createSlirElement(String mobileNo, Document dom, String operatorName) {
		/*
		 * <slir ver="3.0.0" res_type="SYNC"> <pushaddr>
		 * <url>http://localhost:9211/LocationService </url> </pushaddr> <msids>
		 * <msid type="MSISDN">923334000043</msid> </msids> </slir>
		 */

		Element slirEle = dom.createElement("slir");
		Element pushaddrEle = dom.createElement("pushaddr");
		Element urlEle = dom.createElement("url");
		Element msidsEle = dom.createElement("msids");
		Element msidEle = dom.createElement("msid");
		slirEle.setAttribute("ver", "3.0.0");
		slirEle.setAttribute("res_type", "SYNC");
		slirEle.appendChild(pushaddrEle);
		Text urlText = dom.createTextNode(GmlcConstants.CALLBACK_URL + "&operatorname="+operatorName);

		pushaddrEle.appendChild(urlEle);
		urlEle.appendChild(urlText);

		slirEle.appendChild(msidsEle);
		msidsEle.appendChild(msidEle);
		msidEle.setAttribute("type", "MSISDN");
		Text MSISDNText = dom.createTextNode(mobileNo);
		msidEle.appendChild(MSISDNText);

		return slirEle;
	}

	// method to convert Document to String
	private static String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (TransformerException ex) {
			log.error("[Exception]",ex.fillInStackTrace());
			return null;
		}
	}

	public static String createSmsResponse(String xmlResponse) {
		//TODO to be removed 
		//xmlResponse = readFromFile();
		
		//log.info("gmlcResponse from file is:"+xmlResponse);
		GmlcResponse responseObj = parseResponse(xmlResponse);
		if(responseObj == null){
			return null;
		}
		
		log.info("responseObj populated is:"+responseObj);
		
		String smsResponse = "msisdn:"+responseObj.getMsid()+",city:"+responseObj.getCity();
		
		log.info("smsResponse is:"+smsResponse);
		return smsResponse;
	}

	static String readFromFile(){
    	String data = null;
        String file = "gmlcData.xml";
    	try {
            StringBuffer answer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = reader.readLine()) != null) {
                answer.append(line);
            }
            data = answer.toString();
            reader.close();
			
		} catch (Exception e) {
			System.out.println("unable to read from file:"+file);
			return null;
		}
    	
    	return data;
    }

	private static GmlcResponse parseResponse(String xmlResponse) {
		log.info("..xmlResponse to be parsed.."+xmlResponse);
		GmlcResponse response = null;
		try {
			GmlcResponseParser parser = new GmlcResponseParser(xmlResponse);
			parser.execute();
			response = parser.getResponse();
			
		} catch (Exception e) {
			log.error("error while parsing gmlc xml response..",e.fillInStackTrace());
		}
		
		return response;
	}

	public static void sendGmlcServerResponse(String responseData, String operatorname) throws Exception {
		CommonFunctions.sendPostRequest(GmlcConstants.GMLC_LOCATION_RECEIVER_SVC_URL + "?operatorname="+operatorname,responseData);
	}

	public static void sendSms(String msisdn, String responseData,String shortCode, GmlcConfiguration config, String key) throws Exception {
		log.info("searching SMPPSender on key.." + key);
		
		SMPPSender sender = (SMPPSender)senderMap.get(key);
		if (sender == null) {
			throw new ApplicationException(
					"no sms sender configured for operator_shortcode.."
							+ key);
		}
		
	
		/*
		SMPPSender sender = new SMPPSender(); 
		sender.setPropertiesFromConfig(config);
		log.info("Config .." + config);
		*/

		/*
		synchronized (sender) {
		
			try {
                               sender.exceute(msisdn, responseData, shortCode, config);
                       } catch (Exception e) {
                               sender.setUnbindFlag();
                               sender.bind();
                               sender.exceute(msisdn, responseData, shortCode, config);
                       }
		}
		*/


		synchronized (sender) {
		
			try {
                               sender.exceute(msisdn, responseData, shortCode, config);
                       } catch (Exception e) {
                               sender.setUnbindFlag();
                               sender.bind();
                               sender.exceute(msisdn, responseData, shortCode, config);
                       }
		}

	}

	public static void setMap(HashMap operatorShortcodeAndSMPPSenderHashMap) {
		senderMap = operatorShortcodeAndSMPPSenderHashMap;
	}



}
