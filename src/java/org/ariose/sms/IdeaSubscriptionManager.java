package org.ariose.sms;

import org.ariose.util.ApplicationException;

/**
 * 
 * @author Manu Parmar Aug 2011
 */
public interface IdeaSubscriptionManager {

	public void sendSMSToIdeaUser(String requestUrl, String sid, String sms)
			throws ApplicationException;

}
