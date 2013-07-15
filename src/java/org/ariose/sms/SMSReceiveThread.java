package org.ariose.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.GmlcConfiguration;
import org.ariose.util.ApplicationException;

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
						+ "Thread started..SMSReceiveThread.." + this
						+ ",smppAsyncReceiver.." + smppAsyncReceiver);
				smppAsyncReceiver.execute();
			} catch (Exception e) {
				log.error("Error while Binding to SMSC gateway.." + smppAsyncReceiver.getShortCode() + ", Will try again after a minute", e);
				
				try {
					Thread.sleep(60*1000);					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

}
