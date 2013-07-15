/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.sms;


/**
 * 
 * @author Manu Parmar Jan 2011 For 2Ergo Idea Integration
 */
public interface DocomoConstants {

	int SHORTCODE = 53636;
	int DEFAULT_CHANNEL_ID = 1;
	static final int ERROR_SMSC_NOT_CONFIGURED = 252;
	// int ERROR_IN_ACTION = 1;
	// int ERROR_IN_PARAM = 2;
	// int ERROR_IN_ACTIVATION = 3;
	// int ERR_USER_ALREADY_SUBSCRIBED = 4;
	// int ERR_INCORRECT_DATA_IN_NUMSERIES = 5;

	int SAM_RESPONSE_HANDLING_ERROR = 2;
	int SAM_RESPONSE_NOT_READ = 0;
	int SAM_RESPONSE_HANDLED = 3;
	int CALLBACK_REQUEST_SYNTAX_ERROR = 1;

	static final int STATUS_SUBSCRIPTION_DEFAULT = -1;
	static final int STATUS_SUBSCRIPTION_REQUEST_CAME = 1;
	static final int STATUS_SUBSCRIPTION_REQUEST_ACCEPTED = 200;
	static final int STATUS_AUTHORIZATION_FAILED = 201;
	static final int STATUS_ANY_MANDATORY_PARAMS_MISSING = 202;
	static final int STATUS_SRVKEY_NOT_CONFIGURED = 203;
	static final int STATUS_DATABASE_ERROR = 204;
	static final int STATUS_SUBSCRIPTION_ALREADY_EXISTS = 205;
	static final int STATUS_PARENT_SERVICE_UNDER_BILLING = 206;
	static final int STATUS_PARENT_SERVICE_NOT_ACTIVE = 207;
	static final int STATUS_INTERNAL_ERROR = 208;
	static final int STATUS_INCORRECT_PARAMETER_LENGTH = 209;
	// static final int STATUS_CALLBACK_REQ_SYN_ERR = 21;
	static final int STATUS_CALLBACK_REQ_ACT_SUCCESS = 210;
	static final int STATUS_CALLBACK_REQ_ACT_FAILURE = 211;
	static final int STATUS_CALLBACK_REQ_ACT_BAL_LOW = 212;
	static final int STATUS_CALLBACK_REQ_REN_SUCCESS = 213;
	static final int STATUS_CALLBACK_REQ_REN_FAILURE = 214;
	static final int STATUS_CALLBACK_REQ_REN_BAL_LOW = 215;
	static final int STATUS_CALLBACK_SUBSCRIBER_NOT_IN_DB = 216;
	// static final int STATUS_SUBSCRIPTION_DEACTIVATED = 3;
	static final int STATUS_UNSUBSCRIPTION_REQUEST_CAME = 227;
	static final int STATUS_DCT_UNSUBSCRIPTION_COMPLETE = 217; // accepted by
																// onmobile
	static final int STATUS_DCT_ANY_MANDATORY_PARAMS_MISSING = 218;
	static final int STATUS_DCT_SUBSCRIPTION_NOT_FOUND = 219;
	static final int STATUS_DCT_AUTHORIZATION_FAILED = 220;
	static final int STATUS_DCT_SRVKEY_NOT_FOUND = 221;
	static final int STATUS_DCT_DATABASE_ERROR = 222;
	static final int STATUS_DCT_INTERNAL_ERROR = 223;
	static final int STATUS_DCT_INCORRECT_PARAMETER_LENGTH = 224;
	static final int STATUS_CALLBACK_REQ_DCT_SUCCESS = 225;
	static final int STATUS_CALLBACK_REQ_DCT_FAILURE = 226;

	// static final int STATUS_DCT_UNSUBSCRIPTION_REQUEST_MADE = 13;

	// it starts from 100
	static final int ERR_IN_CBCK_SRVKEY = 100;
	static final int ERR_IN_CBCK_STATUS = 101;
	static final int ERR_IN_CBCK_ACTION = 102;
	static final int ERR_IN_CBCK_TYPE = 103;
	static final int ERR_IN_CBCK_REFID = 104;
	static final int ERR_IN_DB = 105;
	static final int ERROR_IN_MSISDN = 106;
	static final int ERR_IN_CBCK_SHORTCODE = 107;
	static final int ERROR_SUBS_DOES_NOT_EXIST = 108;
	static final int ERR_IN_DCT_CONNECTION = 109;
	static final int ERROR_SUBS_ALREADY_DEACTIVATED = 110;
	static final int ERROR_PACK_NOT_IN_DB = 111;
	static final int ERROR_MANY_PACKS_IN_DB = 112;
	static final int ERROR_PACK_EMPTY_IN_REQUEST = 113;
	static final int ERR_UNINOR_SDP_CONN = 114;
	static final String DEFAULT_SHORT_CODE = "9999";
	
	static final int ERROR_TO_UNINOR_SID_INVALID = 260;
	static final int ERROR_TO_UNINOR_OPERATION_FAILED = 101;
	static final int ERROR_TO_UNINOR_PACK_INVALID = 219;
	static final int INVALID_PARAM = 250;
	static final int ERROR_SOME_ISSUE = 260;
//	o 200 – Ok
//	o 101 – Operation Failed
//	o 219 – Invalid product Name
//	o 220 – Invalid Service Name
//	o 260 – Unknown customer
//	Interface Specifications CP Platforms
//	Confidential Page 18 of 34
//	o 250 – Invalid Parameter Input Data Data Type Mandatory Description
	
	String MSG_SUBSCRIPTION_REQUEST_IN_PROCESS = "Thanks for your request to Subscribe to the service - %s. Your request is in process.";

	//String MSG_SUCCESSFULLY_RENEWED = "You have successfully Renewed for the Service - %s. You have been deducted Rs %s.";

	//String MSG_SUBSCRIPTION_CHARGING_REQUEST_ACCEPTED = "Thanks for your request to Subscribe to the service - %s. Your request is in process.";

	String MSG_ALREADY_SUBSCRIBED = "Dear Customer you have already subscribed to the service - %s.";

	String MSG_SUBSCRIPTION_REQUEST_ERROR = "Dear Customer, There is some problem while processing "
			+ "your request for this service - %s. Please try again later.";

//	String MSG_SUCCESSFULLY_SUBSCRIBED = "You have been successfully Subscribed to the Service - %s. "
//			+ "To Unsubscribe, please sms UNSUB %s to %s or Dial %s.";

	String MSG_SUBSCRIPTION_FAILURE = "Dear Customer, you are not currently subscribed to the Service - %s. ";

	String MSG_SUBSCRIPTION_BAL_LOW = "Dear Customer, you do not have sufficient balance to use the requested service - %s.";

	String MSG_SUCCESSFULLY_UNSUBSCRIBED = "You have been successfully Unsubscribed to the Service - %s. ";
	
	String MSG_DCT_SUBSCRIPTION_NOT_FOUND = "Dear Customer, you cannot be Unsubscribed " +
			"since you are not currently Subscribed to the Service - %s. ";

	
	String MSG_DCT_IN_PROCESS = "Dear Customer, Your request to deactivate for the service - %s is in process.";
	
	String MSG_USER_ALREADY_GETTING_ACTIVATED = "You have already sent the Subscription request for the service - %s. The request is already in process.";
	
	String MSG_USER_ALREADY_DEACTIVATED = "Dear Customer, You are already Unsubscribed to the service - %s.";
	
	
	int REQUEST_TYPE_ACTIVATE = 1;
	int REQUEST_TYPE_DEACTIVATE = 2;
	String KEYSTORE_FILE_PATH = "file:/usr/java/jdk1.6.0_20/bin/truststore";
	String KEYSTORE_PWD = "12345678";
	String UNINOR_SDP_URL = "https://sdp1.uninor.in:443/xmlrpc/";
	String BASIC_USER_NAME = "admin";
	String BASIC_PWD = "P@$$w0rd";
	int ERROR_IN_SMS = 0;

	static final int DCMO_RESP_GB_INVALIDARGUMENTEXCEPTION = 111;
	static final int DCMO_RESP_GB_SERVICEEXCEPTION = 112;
	static final int DCMO_RESP_GB_POLICYEXCEPTION = 113;
	static final int DCMO_RESP_GB_ENDUSERAUTHENTICATIONEXCEPTION = 114;
	static final int DCMO_RESP_GB_UNKNOWN_EXCEPTION = 0;
	static final int DCMO_RESP_GB_PARSING_EXCEPTION = 0;

	static final int DCMO_RESP_CU_UNKNOWNENDUSEREXCEPTION = 115;
	static final int DCMO_RESP_CU_INVALIDARGUMENTEXCEPTION = 116;
	static final int DCMO_RESP_CU_CHARGEFAILUREEXCEPTION = 117;
	static final int DCMO_RESP_CONN_ERROR = 118;
	static final int DCMO_RESP_LOW_BALANCE = 119; 
	static final int DCMO_RESP_BL_LT_AMOUNT_REQD = 200; //BL balance less than amount needed
	static final int DCMO_RESP_CONN_NO_200 = 201;
	static final int DCMO_RESP_SOME_ISSUE = 202;
}
