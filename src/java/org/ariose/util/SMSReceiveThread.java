package org.ariose.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.GmlcConfiguration;

/**
 * 
 * @author Manu
 */
public class SMSReceiveThread extends Thread {
	private static Log log = LogFactory.getLog(SMSReceiveThread.class);

	SMPPAsyncReceiver smppAsyncReceiver = null;

	public void setSmppAsyncReceiver(SMPPAsyncReceiver smppAsyncReceiver) {
		this.smppAsyncReceiver = smppAsyncReceiver;
	}

	public void loadProperties(GmlcConfiguration config)
			throws ApplicationException {
		smppAsyncReceiver.loadProperties(config);
	}

	public void run() {
		while (true) {
			try {
				log.info(Thread.currentThread()
						+ "..thread started..SMSReceiveThread.." + this
						+ ",smppAsyncReceiver.." + smppAsyncReceiver);
				smppAsyncReceiver.execute();
			} catch (Exception e) {
				log.error("error while receiving SMPP msg..", e
						.fillInStackTrace());
			}
		}
	}

}
