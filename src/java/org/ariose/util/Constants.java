/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * @author Sukhdeep
 */
public interface Constants {

	Locale locale = Locale.ENGLISH;
	ResourceBundle myResources = ResourceBundle.getBundle("subscription",
			locale);
	int STATUS_SUBSCRIBE = 1;
	int STATUS_RENEWAL = 2;
	int STATUS_UNSUBSCRIBE = 3;
	int STATUS_CONSENT_AWAITED = 4;
	int STATUS_TRY_AND_BUY = 5;
	int STATUS_ACTIVE = 6;
	int STATUS_SYSTEM_ERROR = 7;
	int STATUS_GRACE = 8;
	int STATUS_LOW_BALANCE_FAIL = 9;
	int STATUS_ALREADY_SUBSCRIBED = 10;
	int STATUS_NEW_TO_LOW_BALANCE_FAIL = 9;
	int STATUS_RENEW_TO_LOW_BALANCE_FAIL = 10;
	int STATUS_NEW_TO_LOW_BALANCE_FAIL_FAILED = 49;
	int STATUS_RENEW_TO_LOW_BALANCE_FAIL_FAILED = 50;

	int STATUS_PARKING = 11; // for uninor hariom
	int STATUS_UNSUBSCRIBE_LOCALLY = 13;
	int STATUS_NEW_TO_GRACE = 14;
	int STATUS_RENEW_TO_GRACE = 15;
	int STATUS_SUBSCRIBE_TEMP = 31;
	int STATUS_RENEWAL_TEMP = 32;
	int STATUS_SUBSCRIBE_REQ_ACCEPTED = 33;
	int STATUS_NEW_TO_LOW_BALANCE_FAIL_TEMP = 39;
	int STATUS_RENEW_TO_LOW_BALANCE_FAIL_TEMP = 40;
	int STATUS_RENEW_TO_CONSENT_AWAITED = 18;
	int STATUS_CONT_DELV = 25;
	int STATUS_CONT_NOT_DELV = 26;
	int STATUS_RECHARGED = 27;
	int STATUS_RECHARGE_FAILED = 28;

	int STATUS_EXCEPTION = 111;

	int MODULEID_LOGIN = 1;
	int MODULEID_SUBSCRIPTION = 2;
	int MODULEID_CHARGING = 3;
	int MODULEID_PACK_CREATION = 4;
	int MODULEID_DELIVERY_MECHANISM = 5;
	int MODULEID_CONTENT = 6;
	int MODULEID_CONTENT_DELIVERY = 7;
	int MODULEID_CONFIGURATION = 8;
	int MODULEID_USER = 9;
	// manup:added:gmlc integration..
	int MODULEID_GMLC = 10;
	int MODULEID_REALTIMEDASHBOARD = 11;
	String STR_MODULEID_GMLC = "GMLC";
	String STR_MODULEID_LOGIN = "LOGIN";
	String STR_MODULEID_SUBSCRIPTION = "SUBSCRIPTION";
	String STR_MODULEID_CHARGING = "CHARGING";
	String STR_MODULEID_PACK_CREATION = "PACK";
	String STR_MODULEID_DELIVERY_MECHANISM = "DELIVERY_MECH";
	String STR_MODULEID_CONTENT = "CONTENT";
	String STR_MODULEID_CONTENT_DELIVERY = "CONTENT_DELIVERY";
	String STR_MODULEID_CONFIGURATION = "CONFIGURATION";
	String STR_MODULEID_USER = "USER";
	// shweta: added
	String STR_MODULEID_REALTIMEDASHBOARD = "Real_TimeDash";
	int CHANNEL_BULK = 1;
	int CHANNEL_SMS = 2;
	int CHANNEL_WAP = 3;
	int CHANNEL_USSD = 4;
	int CHANNEL_INTERNET = 5;
	int LOW_BALANCE_TRY_NOW = 1;
	int LOW_BALANCE_TRY_LATER = 2;
	int LOW_BALANCE_TRY_AT_END = 3;
	int CHARGING_FLAG_NEW_DATA_FIRST = 1;
	int CHARGING_FLAG_FAILED_DATA_FIRST = 2;

	int OPERATOR_ID_RELIANCE = 1;
	int OPERATOR_ID_AIRTEL = 2;
	int OPERATOR_ID_IDEA = 3;
	int OPERATOR_ID_UNINOR = 9;
	int OPERATOR_ID_DOCOMO = 10;
	int OPERATOR_ID_VIRGINMOBILE = 11;

	String STR_ACTION_NEW = "NEW SUBSCRIBER";
	String STR_ACTION_ACTIVE = "ACTIVE";
	String STR_ACTION_RENEW = "RENEW";
	String STR_ACTION_UNSUBSCRIBE = "UNSUBSCRIBE";
	String STR_ACTION_RESPONSE_FROM_SAM = "RESPONSE-FM-SAM";

	// String STR_ACTION_UNSUBSCRIBE_LOCALLY = "UNSUBS_LOCALLY";
	String STR_ACTION_GRACE = "GRACE";
	String STR_ACTION_TECH_ERROR = "TECHNICAL ERROR";
	String STR_ACTION_INCORRECT_SUBS = "INCORRECT PARAM IN SUBS";
	String STR_ACTION_CONTENT_DLVD = "CONTENT_DELIVERED";
	String STR_ACTION_CONTENT_NOT_DLVD = "CONTENT_NOT_DELIVERED";
	String CONTENTID_SEPERATOR = "#";
	int CHUNK_SIZE_FOR_REPORT = 30000;
	String SERVER_ERROR_MESSAGE = "The server encountered an internal error or misconfiguration and was unable to complete your request.  \n "
			+ "More information about this error may be available in the server error log.";
	String SESSION_EXPIRE_MESSAGE = "The session has expired. Please login again";
	int SUBSCRIPTION_MIN_CHANNELID = Integer.parseInt(myResources
			.getString("subscription.min.channelID"));
	int SUBSCRIPTION_MAX_CHANNELID = Integer.parseInt(myResources
			.getString("subscription.max.channelID"));
	String TIME_TO_SHUT_DOWN = "15/7/2010";
	String DATE_FORMAT = "yyyy-MM-dd";
	int STATUS_PACK_LIVE = 1;
	int STATUS_PACK_NOT_LIVE = 0;
	// manp:22aug:nazara reliance integration
	int SAM_RSP_SUCCESS = 0;
	int SAM_RSP_USER_NOT_SUSBCRIBED = 1;
	int SAM_RSP_MDN_MISSING = 2;
	int SAM_RSP_TECH_PROB = 3;
	int SAM_RSP_LOW_BALANCE = 4;
	int SAM_RSP_INVALID_REQ = 6;
	int SAM_RSP_PACK_NOT_AVL = 7;
	int SAM_RSP_PACK_NOT_AVL_ON_CHANNEL = 8;
	int SAM_RSP_UNSUBS_FAILED = 9;
	int SAM_RSP_USER_ALREADY_SUSBCRIBED = 10;
	int SAM_RSP_USER_ALREADY_UNSUSBCRIBED = 16;
	int SAM_RSP_AUTH_ISSUE = 117;
	int SAM_RSP_NOT_LOW_BAL = 118;
	String APP_RSP_FAILURE = "NOK";
	String APP_RSP_SUCCESS = "OK";
	String STR_ACTION_SAM_ACTIVATION = "SAM_ACT";
	String STR_ACTION_SAM_DEACTIVATION = "SAM_DEACT";
	String STR_ACTION_SAM_RENEW = "SAM_RENEW";

	int APP_RSP_USER_NOT_SUSBCRIBED = 31;
	int APP_RSP_MDN_MISSING = 32;
	int APP_RSP_TECH_PROB = 33;
	int APP_RSP_INVALID_REQ = 36;
	int APP_RSP_PACK_NOT_AVL = 37;
	int APP_RSP_PACK_NOT_AVL_ON_CHANNEL = 38;
	int APP_RSP_UNSUBS_FAILED = 39;
	int APP_RSP_USER_ALREADY_SUSBCRIBED = 40;
	int APP_RSP_USER_ALREADY_RENEWED = 41;
	int APP_RSP_USER_ALREADY_UNSUSBCRIBED = 46;
	int APP_RSP_PACK_WITH_NO_DEFAULT_CHANNEL = 47;
	int APP_RSP_GATEWAY_NOT_CONF_CORRECTLY = 48;
	int APP_RSP_USER_NOT_UNSUSBCRIBED = 49;
	int APP_RSP_USER_ALREADY_GETTING_ACTIVATED = 50;
	// Manu Parmar Jan 2011 For 2Ergo Idea Integration
	int APP_RSP_MANY_PACKS_PRESENT = 51;
	int APP_RSP_MULTIPLE_CHANNELS_FOR_SRC = 52;
	int APP_RSP_INCORRECT_OPERATOR = 53;
	int APP_RSP_INCORRECT_KEYWORD = 54;
	int APP_RSP_INCORRECT_SOURCE = 55;
	int APP_RSP_INCORRECT_MSISDN = 56;
	int APP_RSP_ERROR_IN_IDEA_ACTIVATION = 57;
	int APP_RSP_ERROR_WHILE_SAVING_SUBSCRIPTION = 58;
	int APP_RSP_ERROR_WHILE_SAVING_SUBSCRIBER = 59;
	int APP_RSP_INCORRECT_DATA_IN_NUMSERIES = 60;
	int APP_ERROR_SMS_PACKET_RCVD = 62;
	int APP_RSP_ERR_INCORRECT_MINUTES = 63;
	int APP_RSP_ERR_MINUTES_NOT_IN_PACK = 64;
	int APP_RSP_INVALID_CHANNEL = 65;

	// for uninor
	int APP_RSP_INCORRECT_NotifyType = 61;
	int APP_ERROR_IN_CONNECTION = 66;

	// int APP_RSP_USER_ALREADY_RENEWED = 41;
	int STATUS_HAS_USER_SUB = 41;
	int STATUS_HAS_USER_UNSUB = 43;
	String APPID_REBA = "111";

	/*
	 * Added for drop down list of source in activation screen. Order of
	 * elements should be same as in drop down list. Please make sure before
	 * adding more elemets
	 */
	String sourceNameArray[] = { "BIHAR IBD", "IBDMUM", "IBDUPEAST",
			"UPEAST IBD", "UPSS7" };
	String STR_TOTAL = "Total: ";
	String STR_SUM = "Sum: ";
	String STR_DATE = "Date: ";
	String scheduleMESSAGE[] = { STR_TOTAL, STR_SUM, STR_DATE, "DEFAULT: " };
	String WINDOWS_PATH = "D:/Project/campaign/";
	String LINUX_PATH = "/temp";
	String LINUX_PATH_CAMPAIGN = "/opt/bulkupload/campaigns";
	String WINDOWS_PATH_CAMPAIGN = "bulkupload/campaigns";
	String OPERATOR_NAZARA = "Reliance";
	int UNSUBSCRIBE_STATUS = 3;
	int REALTIME_DASHBOARD_DONE_STATUS = 0;
	int REALTIME_DASHBOARD_UNDELIVERED_STATUS = 1;
	int REALTIME_DASHBOARD_STOP_STATUS = 1;
	int REALTIME_DASHBOARD_NOT_YET_STARTED_STATUS = 2;
	int REALTIME_DASHBOARD_NO_CONTENT_FOUND = 3;
	int REALTIME_DASHBOARD_SENDING_STATUS = 4;
	String STR_REALTIME_DASHBOARD_NOT_YET_STARTED_STATUS = "Not yet started";

	String CHECK_CONTENT_SERVLETNAME = "CheckContentServlet";

	// status stored in ch_txn/ content_delivery_log tables
	int STATUS_SUCCESS = 0;
	int STATUS_FAILURE = 1;
	int APP_RSP_SAM_REJECTED_DEACT_REQ = 67;

	// IDEA CONFIG
	int SMS_SUCCESS_RESPONSE_CODE = 202;
	static final int ERR_SMS_SENDING = 400;
	static final int ERR_SMS_RESPCODE_FAILURE = 401;

	public final static String DEFAULT_USERNAME = "hariom";
	public final static String DEFAULT_PASSWORD = "hariommt";
	public final String SMS_URL = "https://112.110.33.171:55000";
	public final String IDEA_REQUEST_XML = "<message>"
			+ "<sms type=\"mt\">"
			+ "<destination>"
			+ "<address>"
			+ "<number type=\"national\">91$MDN</number>"
			+ "</address>"
			+ "</destination>"
			+ "<source>"
			+ "<address>"
			+ "<number type=\"abbreviated\">53301</number>"
			+ "</address>"
			+ "</source>"
			+ "<pid>0</pid>"
			+ "<rsr type=\"all\"></rsr>"
			+ "<ud type=\"text\" encoding=\"default\">$SMS"
			+ "</ud>"
			+ "<param name=\"unique_id\" value=\"123456\"></param>"
			+ "<param name=\"developer_content_id\" value=\"Hari Om Media Pvt Ltd\"></param>"
			+ "<param name=\"mo_keyword\" value=\"text\"></param>"
			+ "<param name=\"content_description\" value=\"Testing\"></param>"
			+ "<param name=\"content_type\" value=\"text\"></param>"
			+ "	</sms>" + "</message>";

}
