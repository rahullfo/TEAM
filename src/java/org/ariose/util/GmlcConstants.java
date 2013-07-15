package org.ariose.util;

public class GmlcConstants {
	static final String LOCATION_SVC_URL = "http://10.81.100.2:9210/LocationService";
	static final String ID = "Pegasys9P";
	static final String PWD = "9_PEGASUS_9";
	static final String GMLC_LOCATION_RECEIVER_SVC_URL = "http://192.168.249.221:8080/GetLocationXMLFromGMLC";
//	static final String CALLBACK_URL = "http://203.99.50.54:8080/cmsportal/singleSubscription.html?action=userLocationGmlcResponse";
	static final String CALLBACK_URL = "http://192.168.249.221:8080/cmsportal/singleSubscription.html?action=userLocationGmlcResponse";
//	static final String SEND_SMS_URL = "http://localhost:8080/SetSMS?USER_ID=abc&TEXT=abc&OPERATOR_ID=abc&SHORT_CODE=abc";

	
	static final String SEND_SMS_URL = "http://192.168.249.221:8080/SMSReceiver";
	static final String USER_ID = "923456789999";
	static final String SHORT_CODE = "2002";
	static final String TEXT = "FIND 923145385509";
	static final String OPERATOR_ID = "ZONG";
	static final int SMSSize = 240;//120;

	
	//values to be stored in subs_request_log1 - subs_request_log12 tables
	public static final String LOG_OPERATOR_NAME ="ZONG";
	public static final int LOG_OPERATOR_ID=101;
	public static final String LOG_CIRCLE_NAME="ZONG";
	public static final int LOG_CIRCLE_ID =101;
	public static final String LOG_PACK_NAME ="FINDME";
	public static final int LOG_PACK_ID=101;
	public static final int LOG_CHANNELID_GMLCREQUEST=101;
	public static final int LOG_CHANNELID_GMLCRESPONSE=102;
	public static final int LOG_CHANNELID_SENDSMS=103;
	public static final int LOG_CHANNELID_RECEIVEDSMS=104;
	public static final String LOG_ACTION = "NA";
	
	
	//public static final int CONNECTION_RCV_TIMEOUT = 200 * 1000;
	public static final int CONNECTION_RCV_TIMEOUT = -1;
	//bind testing
	public static final int ENQUIRELINK_TIMER_TIME = 60;//in seconds
}
