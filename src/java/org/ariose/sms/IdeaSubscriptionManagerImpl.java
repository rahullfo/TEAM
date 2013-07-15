package org.ariose.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.util.ApplicationException;
import org.ariose.util.Constants;
import org.ariose.util.MTTestSSL;

/**
 * 
 * @author Manu Parmar
 * 
 *         March 2012
 * 
 *         It is responsible for sending SMS to users of various operators
 */

public class IdeaSubscriptionManagerImpl implements IdeaSubscriptionManager {
	private static Log log = LogFactory.getLog(IdeaSubscriptionManagerImpl.class);
	MTTestSSL MTTestSSL = null;
	public void setMTTestSSL(MTTestSSL MTTestSSL) {
		this.MTTestSSL = MTTestSSL;
	}



	@Override
	public void sendSMSToIdeaUser(String requestUrl, String sid, String sms)
			throws ApplicationException {
		// Create XML
		// Send XML Over HTTPS
		// Return Error if Any

		String requestXml = Constants.IDEA_REQUEST_XML.replace("$MDN", sid)
				.replace("$SMS", sms);

		MTTestSSL.sendSMS(requestXml);
	}
}