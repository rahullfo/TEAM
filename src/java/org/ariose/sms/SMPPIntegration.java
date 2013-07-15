package org.ariose.sms;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.GmlcConfiguration;
import org.ariose.util.ApplicationException;
import org.ariose.util.SMPPSender;

public class SMPPIntegration {
	private static Log log = LogFactory.getLog(SMPPIntegration.class);
	static Map senderMap = null;
	static Map receiverMap = null;

	public static void sendSms(String msisdn, String responseData,
			String shortCode, GmlcConfiguration config, String key)
			throws Exception {
//		log.warn("SENDING SMS..msisdn [" + msisdn + "], sms [" + responseData
//				+ "], shortcode [" + shortCode + "], config [" + config
//				+ "], key [" + key + "]");

		Object object = senderMap.get(key);
		if (object == null) {
			throw new ApplicationException(
					DocomoConstants.ERROR_SMSC_NOT_CONFIGURED,
					" No sms sender configured for operator_shortcode.." + key);
		}

		SMPPSender sender = (SMPPSender) object;

		synchronized (sender) {
			try {
				sender.bind();
				sender.exceute(msisdn, responseData, shortCode, config);
				sender.unbind();
			} catch (Exception e) {
				//log.error("FAILURE SMS..msisdn [" + msisdn + "] " + e.fillInStackTrace());
				throw e;
				// sender.setUnbindFlag();
				// sender.bind();
				// sender.exceute(msisdn, responseData, shortCode, config);
			}
		}

		//log.warn("SUCCESS SMS..msisdn [" + msisdn + "]");

	}

	public static void sendSmsViaTransceiver(String msisdn,
			String responseData, String shortCode, GmlcConfiguration config,
			String key) throws Exception {
		log.warn("SENDING SMS..msisdn [" + msisdn + "], sms [" + responseData
				+ "], shortcode [" + shortCode + "], config [" + config
				+ "], key [" + key + "]");

		log.info("receiverMap "+receiverMap);
		Object object = receiverMap;

		if(receiverMap!=null) {
			object = receiverMap.get(key);			
		}
		
		if (object == null) {
			throw new ApplicationException(
					DocomoConstants.ERROR_SMSC_NOT_CONFIGURED,
					" No RECEIVER configured for operator_shortcode.." + key);
		}

		SMPPAsyncReceiver sender = (SMPPAsyncReceiver) object;

		synchronized (sender) {
			try {
				sender.send("91"+msisdn, responseData,shortCode);
			} catch (Exception e) {
//				log.error("FAILURE SMS..msisdn [" + msisdn + "] " + e);
				throw e;
			}
		}

//		log.warn("SUCCESS SMS..msisdn [" + msisdn + "]");
	}

	public static synchronized void setMap(Map map) {
		log.info(Thread.currentThread() + " called.." + map);
		if (senderMap != null)
			return;
		senderMap = map;
	}

	public static synchronized void setReceiverMap(Map map) {
		log.info(Thread.currentThread() + " called.." + map);
		if (receiverMap != null)
			return;
		receiverMap = map;
	}
}
