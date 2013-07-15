/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.sms;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.util.Constants;

/**
 * 
 * @author Manu Parmar Jan 2011 For 2Ergo Idea Integration
 */
public class StatusInfo {

	private static Log log = LogFactory.getLog(StatusInfo.class);

	static Map statusMap = new HashMap<Integer, String>();

	static void loadStatusMap() {
		if (statusMap.size() == 0) {
			statusMap.put(Constants.STATUS_SUBSCRIBE,
					"Activation Request is Accepted");
			statusMap.put(Constants.STATUS_SUBSCRIBE_TEMP,
					"Activation Request is Picked for Charging");
			statusMap.put(Constants.STATUS_ACTIVE, "User is Activated");
			statusMap.put(Constants.STATUS_RENEWAL, "User is Renewed");
			statusMap.put(Constants.STATUS_UNSUBSCRIBE, "User is Deactivated");

			statusMap.put(Constants.STATUS_NEW_TO_LOW_BALANCE_FAIL,
					"New User in Low Balance");
			statusMap.put(Constants.STATUS_RENEW_TO_LOW_BALANCE_FAIL,
					"Renew User in Low Balance");
			statusMap.put(Constants.STATUS_NEW_TO_LOW_BALANCE_FAIL_FAILED,
					"New User still not activated after RETRIES");
			statusMap.put(Constants.STATUS_RENEW_TO_LOW_BALANCE_FAIL_FAILED,
					"New User still not activated after RETRIES");

			statusMap.put(Constants.APP_ERROR_IN_CONNECTION,
					"Could not connect to SAM");
			statusMap.put(Constants.SAM_RSP_LOW_BALANCE, "User in Low Balance");
			statusMap.put(Constants.SAM_RSP_AUTH_ISSUE,
					"Some Authorisation Issue");
			// statusMap.put(Constants.SAM_RSP_INVALID_REQ, "Invalid request");
			// statusMap.put(Constants.SAM_RSP_MDN_MISSING, "MDN Missing");
			// statusMap.put(Constants.SAM_RSP_PACK_NOT_AVL,
			// "Pack not Available");
			// statusMap.put(Constants.SAM_RSP_PACK_NOT_AVL_ON_CHANNEL,
			// "Pack not Available on this channel");
			// statusMap.put(Constants.SAM_RSP_TECH_PROB, "Technical Problem");
			statusMap.put(Constants.SAM_RSP_UNSUBS_FAILED,
					"Unsubscription Failed");
			// statusMap.put(Constants.SAM_RSP_USER_ALREADY_SUSBCRIBED,
			// "User is Already subscripbed");
			// statusMap.put(Constants.SAM_RSP_USER_ALREADY_UNSUSBCRIBED,
			// "User is Already unsubscripbed");
			// statusMap.put(Constants.SAM_RSP_USER_NOT_SUSBCRIBED,
			// "User is not subscribed");
			// statusMap.put(Constants.SAM_RSP_NOT_LOW_BAL,
			// "Charging failed due to some other reason");
		}
	}

	public static String getStatusMessage(int errorId) {

		loadStatusMap();
		String message = "No Message found for this id.";
		if (statusMap.get(errorId) != null) {
			message = (String) statusMap.get(errorId);
		}

		log.info("id[" + errorId + "], message[" + message + "]");
		return message;
	}

	// uninor sdp response codes and its meaning
	static HashMap respCodeMessageMap = new HashMap();
	static {
		respCodeMessageMap.put(200, "OK");
		respCodeMessageMap.put(201, "Subscription Already exist");
		respCodeMessageMap.put(101, "Operation failed");
		respCodeMessageMap.put(226, "Insufficient Balance");
		respCodeMessageMap.put(227, "Subscription doesn't exist");
		respCodeMessageMap.put(219, "Unknown Product name");
		respCodeMessageMap.put(250, "Invalid Parameters");
		respCodeMessageMap.put(251, "Subscription in Progress");
		respCodeMessageMap.put(252, "Subscription in Progress");
		respCodeMessageMap.put(260, "Unknown Customer");
	}

	public static String getUninorMessage(Integer responseCode) {
		if (respCodeMessageMap.get(responseCode) != null)
			return "Uninor SDP rejected the Request with reason as - "
					+ (String) respCodeMessageMap.get(responseCode);
		else
			return "Uninor SDP rejected the Request with reason as - No Description Present";
	}
}
