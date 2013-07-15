package org.ariose.sms;

import javax.servlet.http.HttpServletRequest;

import org.ariose.model.SubscriptionBean;
import org.ariose.util.ApplicationException;

/**
 * 
 * @author Manu Parmar Aug 2011
 */
public interface SubscriptionManager {

	public SubscriptionBean SendSMS(String requestUrl, String sid, String sms,
			String shortcode, String smsckey, String needValidation)
			throws ApplicationException;

}
