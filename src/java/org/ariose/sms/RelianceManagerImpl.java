/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.sms;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.ChargingDAO;
import org.ariose.dao.EventLoggingDAO;
import org.ariose.dao.SubscriberDAO;
import org.ariose.model.ChargingGateway;
import org.ariose.model.DocomoChargingGatewayResp;
import org.ariose.model.PriceValueBean;
import org.ariose.model.RelianceSamResponse;
import org.ariose.model.RenewalPriceValueBean;
import org.ariose.model.SubscriberBean;
import org.ariose.model.SubscriptionBean;
import org.ariose.model.TempChargingData;
import org.ariose.util.ApplicationException;
import org.ariose.util.CommonFunctions;
import org.ariose.util.Constants;

/**
 * 
 * @author Manu Parmar: Client - HARIOM: Date - 29Sep2011
 * 
 *         It first sends getBalance..request to DOCOMO charging gateway as a
 *         web service request and if user has sufficient balance then sends
 *         charging request to the user
 * 
 *         In case of insufficient balance [balance<2 or balance-1 < min amount
 *         configured for pack] any exception that comes either is gateway
 *         response or otherwise..
 * 
 *         It undergoes low balance action - which is try a new user for 10 days
 *         and renew user for 30 days.
 * 
 *         It also stores the response in docomo_charging_gateway response table
 *         so that another module [sam_charging_handler] sends SMPP messages to
 *         the user based on response received from the gateway or the charging
 *         status.
 * 
 *         Tables effected are -
 *         ch_transaction<x>,subscription,subscription_fail
 *         ,docomo_charging_gateway_resp
 */
public class RelianceManagerImpl {

	private static Log log = LogFactory.getLog(RelianceManagerImpl.class);
	private ChargingDAO chargingDAO;
	private SubscriberDAO subscriberDao;
	private EventLoggingDAO eventLoggingDAO;

	public void setSubscriberDao(SubscriberDAO subscriberDao) {
		this.subscriberDao = subscriberDao;
	}

	public void setEventLoggingDAO(EventLoggingDAO eventLoggingDAO) {
		this.eventLoggingDAO = eventLoggingDAO;
	}

	public void setChargingDAO(ChargingDAO dao) {
		this.chargingDAO = dao;
		init(Constants.OPERATOR_ID_RELIANCE, 0);
	}

	static private int LOW_BALANCE_DAYS_NEW_USER = 2;
	static private int LOW_BALANCE_DAYS_RENEW_USER = 2;

	HashMap gatewayHashMap = null;
	StringBuffer queryStringToSendSMS = new StringBuffer();
	String urlStr = null;

	public void init(int operatorId, int circleId) {
		log.info("called .. ");
		gatewayHashMap = new HashMap();
		List gatewaydetails = chargingDAO.getChargingGateway(operatorId);
		if (gatewaydetails.size() == 0) {
			log.error("No Gateway For Reliance Operator with ID[" + operatorId
					+ "]");
			return;
		}

		/*
		 * It must be of the type
		 * 
		 * http://202.138.125.19:8090/cgi-BIN/externalrouting/routing.cgi?TYPE=$TYPE
		 * &appid=$APPID&channel=$CHANNEL&mdn=$MDN&ACTION=$ACTION
		 */
		ChargingGateway cg = (ChargingGateway) gatewaydetails.get(0);
		urlStr = cg.getUrl();
	}

	// DDMMYYYYHH24MI e.g.: 0,10,171120081330,271120081330
	static SimpleDateFormat sdfOfResponse = new SimpleDateFormat("ddMMyyyyHHmm");

	// 2011-12-07 11:27:59
	static SimpleDateFormat sdfNeededByApp = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss"); // TODO change it

	public SubscriptionBean chargeUser(TempChargingData data,
			SubscriptionBean subscriptionBean) throws ApplicationException {
		log.info("called..with input as.." + data);
		SubscriptionBean sb = null;
		String actualurlStr = "";
		int responseCode = -1;
		try {
			log.info("urlStr original[" + urlStr + "]");

			actualurlStr = urlStr.replace("$TYPE", data.getTypeOfRequest())
					.replace("$APPID", data.getAppID())
					.replace("$CHANNEL", "" + data.getChannelId())
					.replace("$MDN", "" + data.getMobileNo())
					.replace("$ACTION", data.getAction());

			log.info("urlStr modified[" + actualurlStr + "]");
			// send HTTP POST Request to this URLSTR
			String response = "";
			try {
				response = CommonFunctions.activatingUrl(actualurlStr);
			} catch (Exception e) {
				throw new ApplicationException(
						Constants.APP_ERROR_IN_CONNECTION,
						StatusInfo
								.getStatusMessage(Constants.APP_ERROR_IN_CONNECTION));
			}

			/*
			 * TODO remove it..only used for testing..
			 */

			// response = "0,10,131220111330,231220111330";

			/*
			 * Response format for success: Format for response for Successful
			 * subscription and User Already Subscribed i.e. code ‘0’ and ‘10’
			 * and ‘18’: x,a,b,c Where x will be code as specified below a will
			 * be the validity period in days b will be the start date of
			 * subscription (DDMMYYYYHH24MI) c will be the end date of
			 * subscription (DDMMYYYYHH24MI) e.g.:
			 * 0,10,171120081330,271120081330
			 */

			// process response back
			int amountToCharge = 0;
			int validity = 0;
			int minutes = 0;
			String[] responseArray = new String[4];
			responseArray = response.split(",");
			String startDate = "";
			String endDate = "";

			try {
				responseCode = Integer.parseInt(responseArray[0]);
			} catch (Exception e) {
				throw new ApplicationException(Constants.SAM_RSP_AUTH_ISSUE,
						responseArray[0]);
			}

			if (responseCode == 0 || responseCode == 10 || responseCode == 18) {
				validity = Integer.parseInt(responseArray[1]);
				amountToCharge = validity;
				Date date = sdfOfResponse.parse(responseArray[2]);
				startDate = sdfNeededByApp.format(date);

				date = sdfOfResponse.parse(responseArray[3]);
				endDate = sdfNeededByApp.format(date);

				sb = handleSuccessfulCharging(data, amountToCharge,
						subscriptionBean, validity, minutes, startDate, endDate);

				saveRelianceRevenue(data, sb, responseCode);
				saveTransactionLogWithSuccess(data, urlStr, response, "",
						validity, amountToCharge, endDate);
			} else if (responseCode == 4 || responseCode == 5
					|| responseCode == 12) {
				// low balance case
				throw new ApplicationException(
						Constants.SAM_RSP_LOW_BALANCE,
						StatusInfo
								.getStatusMessage(Constants.SAM_RSP_LOW_BALANCE));
			} else {
				throw new ApplicationException(
						Constants.SAM_RSP_NOT_LOW_BAL,
						StatusInfo
								.getStatusMessage(Constants.SAM_RSP_NOT_LOW_BAL)
								+ "[" + responseCode + "]");
			}

		} catch (ApplicationException e) {
			log.error(e);
			if (e.getId() == Constants.SAM_RSP_AUTH_ISSUE
					|| e.getId() == Constants.SAM_RSP_NOT_LOW_BAL) {
				sb = simplyUpdateStatus(data, subscriptionBean, e.getId(), e);
				saveTransactionLogWithException(data, e, actualurlStr, "", "",
						0, 0);

			} else {
				handleLowBalance(e, data, subscriptionBean);
				saveTransactionLogWithException(data, e, actualurlStr, "", "",
						0, 0);
				// saveLogWithException(e, data);
			}

			throw e;
		} catch (Exception e) {
			log.error(e);
			ApplicationException ae = new ApplicationException(
					DocomoConstants.DCMO_RESP_SOME_ISSUE, e.getMessage());
			handleLowBalance(ae, data, subscriptionBean);
			saveTransactionLogWithException(data, e, urlStr, "", "", 0, 0);
			// saveLogWithException(ae, data);
			throw ae;
		}

		return sb;
	}

	private SubscriptionBean simplyUpdateStatus(TempChargingData data,
			SubscriptionBean subscriptionBean2, int responseCode,
			ApplicationException e) {
		// remove record from subscription fail
		// update subscription table with NCD/STATUS/VALIDITY/MINUTES etc
		SubscriptionBean subscriptionBean = null;
		if (subscriptionBean2 == null) {
			subscriptionBean = new SubscriptionBean();
			subscriptionBean.setOperatorID(data.getOperator());
			subscriptionBean.setRegionId(data.getCircleId());
			subscriptionBean.setSubscriptionPackId(data.getPackID());
			subscriptionBean.setSubscriberNo(data.getMobileNo());
			subscriptionBean.setChannelId(data.getChannelId());

			subscriptionBean.setSource(data.getSource());
			subscriptionBean.setShortcode(0);
			subscriptionBean.setKeyword(data.getKeyword());
			subscriptionBean.setOperatorName(data.getOperatorName());
			subscriptionBean.setCircleName(data.getCircleName());
			subscriptionBean.setPackName(data.getPackName());
			subscriptionBean.setSubscriptionCreationDate(CommonFunctions
					.getCurrentDate());

			subscriptionBean.setLogtime(CommonFunctions.getCurrentDate());
		} else {
			subscriptionBean = subscriptionBean2;
		}
		// find bean in db if found get it else create new

		// save subscription bean

		subscriptionBean.setSubscriptionStatus(responseCode);
		subscriptionBean.setSubscriptionStatusMeaning(e.getMessage());

		if (subscriptionBean2 == null)
			chargingDAO.save(subscriptionBean);
		else
			chargingDAO.update(subscriptionBean);

		return subscriptionBean;

	}

	private SubscriptionBean handleSuccessfulCharging(TempChargingData data,
			int amountToCharge, SubscriptionBean subscriptionBean2,
			int validity, int minutes, String startDate, String endDate) {
		log.info("called.." + subscriptionBean2);
		// remove record from subscription fail
		// update subscription table with NCD/STATUS/VALIDITY/MINUTES etc
		SubscriptionBean subscriptionBean = null;
		if (subscriptionBean2 == null) {
			subscriptionBean = new SubscriptionBean();
			subscriptionBean.setOperatorID(data.getOperator());
			subscriptionBean.setRegionId(data.getCircleId());
			subscriptionBean.setSubscriptionPackId(data.getPackID());
			subscriptionBean.setSubscriberNo(data.getMobileNo());
			subscriptionBean.setChannelId(data.getChannelId());

			subscriptionBean.setSource(data.getSource());
			subscriptionBean.setShortcode(0);
			// subscriptionBean.setSubscriptionStatus(Constants.STATUS_RENEWAL);
			subscriptionBean.setKeyword(data.getKeyword());
			subscriptionBean.setOperatorName(data.getOperatorName());
			subscriptionBean.setCircleName(data.getCircleName());
			subscriptionBean.setPackName(data.getPackName());
			subscriptionBean.setSubscriptionCreationDate(CommonFunctions
					.getCurrentDate());

			subscriptionBean.setLogtime(CommonFunctions.getCurrentDate());
		} else {
			subscriptionBean = subscriptionBean2;
		}
		// find bean in db if found get it else create new

		// save subscription bean

		subscriptionBean.setSubscriptionStatus(Constants.STATUS_RENEWAL);
		subscriptionBean.setSubscriptionStatusMeaning(StatusInfo
				.getStatusMessage(subscriptionBean.getSubscriptionStatus()));

		subscriptionBean.setActivationDate(startDate);
		subscriptionBean.setAmount("" + amountToCharge);
		subscriptionBean.setValidity("" + validity);
		subscriptionBean.setMinutes("" + minutes);

		subscriptionBean.setContentDeliveryDate(endDate);
		subscriptionBean.setNextchargingDate(endDate);
		subscriptionBean.setSubscriptionValidDate(endDate);

		if (subscriptionBean2 == null)
			chargingDAO.save(subscriptionBean);
		else
			chargingDAO.update(subscriptionBean);

		log.info("ended.." + subscriptionBean);
		return subscriptionBean;
	}

	private SubscriptionBean handleSuccessfulRECharging(TempChargingData data,
			int amountToCharge, SubscriptionBean subscriptionBean,
			int validity, int minutes) {

		int amount = amountToCharge;
		int min = minutes;
		try {
			amount += Integer.parseInt(subscriptionBean.getAmount());
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			min += Integer.parseInt(subscriptionBean.getMinutes());
		} catch (Exception e) {
			// TODO: handle exception
		}

		subscriptionBean.setAmount("" + amount);
		subscriptionBean.setMinutes("" + min);
		chargingDAO.update(subscriptionBean);

		return subscriptionBean;
	}

	private SubscriptionBean saveSubscription(TempChargingData data,
			String source, int shortcode, String keyword, String amount,
			String validity, String minutes) throws ApplicationException {
		SubscriptionBean subscriptionBean = new SubscriptionBean();
		log.info("called..");

		try {
			subscriptionBean.setOperatorID(data.getOperator());
			subscriptionBean.setRegionId(data.getCircleId());
			subscriptionBean.setSubscriptionPackId(data.getPackID());
			subscriptionBean.setSubscriberNo(data.getMobileNo());
			subscriptionBean.setChannelId(data.getChannelId());
			subscriptionBean.setSource(source);
			subscriptionBean.setShortcode(shortcode);
			subscriptionBean.setSubscriptionStatus(Constants.STATUS_ACTIVE);
			subscriptionBean.setKeyword(keyword);
			subscriptionBean.setOperatorName(data.getOperatorName());
			subscriptionBean.setCircleName(data.getCircleName());
			subscriptionBean.setPackName(data.getPackName());
			subscriptionBean.setSubscriptionCreationDate(CommonFunctions
					.getCurrentDate());

			subscriptionBean.setAmount(amount);
			subscriptionBean.setValidity(validity);
			subscriptionBean.setMinutes(minutes);
			subscriptionBean
					.setActivationDate(CommonFunctions.getCurrentDate());
			subscriptionBean.setContentDeliveryDate(CommonFunctions
					.addDaysInDate(Integer.parseInt(validity)));
			subscriptionBean.setNextchargingDate(subscriptionBean
					.getContentDeliveryDate());
			subscriptionBean.setSubscriptionValidDate(subscriptionBean
					.getContentDeliveryDate());
			subscriptionBean.setLogtime(CommonFunctions.getCurrentDate());
			subscriberDao.saveSubscription(subscriptionBean);

		} catch (Exception e) {
			log.error(e);
			throw new ApplicationException(
					Constants.APP_RSP_ERROR_WHILE_SAVING_SUBSCRIPTION,
					"Could not save subscription in database");
		}

		try {
			List<SubscriberBean> subscriberBeanList = subscriberDao
					.getSubscriberDetails(data.getMobileNo());
			// it should have just one row
			if (subscriberBeanList.size() == 0) {
				SubscriberBean subscriberBean = new SubscriberBean();
				subscriberBean.setOperatorTableOperatorId(data.getOperator());
				subscriberBean.setRegionId(data.getCircleId());
				subscriberBean.setSubscriberNo(data.getMobileNo());
				subscriberBean.setHandsetType("nokia");
				subscriberDao.saveNewSubscriberDetails(subscriberBean);
			}

		} catch (Exception e) {
			throw new ApplicationException(
					Constants.APP_RSP_ERROR_WHILE_SAVING_SUBSCRIBER,
					"Could not save subscriber in database");
		}

		return subscriptionBean;
	}

	private void handleLowBalance(ApplicationException e,
			TempChargingData data, SubscriptionBean subscriptionBean2) {
		int subscriptionFailId = 0;
		int lowBalanceDays = 0;
		int status = 0;
		String nextChargingDate = CommonFunctions.addDaysInDate(1);
		SubscriptionBean subscriptionBean = null;
		if (subscriptionBean2 == null) {
			subscriptionBean = new SubscriptionBean();
		} else {
			subscriptionBean = subscriptionBean2;
		}

		if (data.getStatus() == Constants.STATUS_SUBSCRIBE) {
			lowBalanceDays = LOW_BALANCE_DAYS_NEW_USER;
			status = Constants.STATUS_NEW_TO_LOW_BALANCE_FAIL;
		} else {
			status = Constants.STATUS_RENEW_TO_LOW_BALANCE_FAIL;
			lowBalanceDays = LOW_BALANCE_DAYS_RENEW_USER;
		}

		// find bean in db if found get it else create new

		// save subscription
		// save subscription fail
		subscriptionBean.setSubscriberNo(data.getMobileNo());
		subscriptionBean.setSubscriptionPackId(data.getPackID());
		subscriptionBean.setPackName(data.getPackName());
		subscriptionBean.setSubscriptionStatus(status);
		subscriptionBean.setSubscriptionStatusMeaning(StatusInfo
				.getStatusMessage(subscriptionBean.getSubscriptionStatus()));
		subscriptionBean.setActivationDate(CommonFunctions.getCurrentDate());
		subscriptionBean.setLogtime(CommonFunctions.getCurrentDate());
		subscriptionBean.setNextchargingDate(nextChargingDate);
		subscriptionBean.setOperatorID(data.getOperator());
		subscriptionBean.setOperatorName(data.getOperatorName());
		subscriptionBean.setCircleName(data.getCircleName());
		subscriptionBean.setKeyword(data.getKeyword());
		subscriptionBean.setRegionId(data.getCircleId());
		subscriptionBean.setSource(data.getSource());
		subscriptionBean.setSubscriptionCreationDate(CommonFunctions
				.getCurrentDate());

		if (subscriptionBean2 == null)
			chargingDAO.save(subscriptionBean);
		else
			chargingDAO.update(subscriptionBean);


		chargingDAO.saveSubscriptionFailData(subscriptionFailId,
				data.getMobileNo(), data.getPackID(), data.getCircleId(),
				nextChargingDate, status, data.getPrice(), data.getValidity(),
				data.getLowBalanceStatus(), data.getPackName(),
				data.getWaitPeriod(), data.getMaxRetries(), data.getGrace(),
				lowBalanceDays, data.getValidityDate(),
				data.getContentDeliveryDate(), data.getGraceChargingTime(),
				data.getOperator(), data.getGraceContentDays(),
				data.getPvFailRowIdx(), data.getPreRenewalDays(),
				data.getChannelId());
	}

	private void saveLogWithRechargeException(ApplicationException e,
			TempChargingData data) {

		// if (e.getId() ==
		// DocomoConstants.DCMO_RESP_GB_ENDUSERAUTHENTICATIONEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_GB_POLICYEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_GB_INVALIDARGUMENTEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_CU_UNKNOWNENDUSEREXCEPTION
		// || e.getId() ==
		// DocomoConstants.DCMO_RESP_CU_INVALIDARGUMENTEXCEPTION) {
		// log.info("not a low balance case..the error id is.." + e.getId());
		// return;
		// }

		DocomoChargingGatewayResp docomoChargingGatewayResp = new DocomoChargingGatewayResp();
		docomoChargingGatewayResp.setPackId(data.getPackID());
		docomoChargingGatewayResp.setPackName(data.getPackName());
		docomoChargingGatewayResp
				.setSubscriptionStatus(Constants.STATUS_RECHARGE_FAILED);

		// if (data.getStatus() == Constants.STATUS_SUBSCRIBE) {
		// docomoChargingGatewayResp
		// .setSubscriptionStatus(Constants.STATUS_NEW_TO_LOW_BALANCE_FAIL);
		// } else {
		// docomoChargingGatewayResp
		// .setSubscriptionStatus(Constants.STATUS_RENEW_TO_LOW_BALANCE_FAIL);
		// }
		//
		String message = "Recharge Failed - " + e.getId() + " - "
				+ e.getMessage();

		if (message.length() > 128) {
			docomoChargingGatewayResp.setSubscriptionStatusMeaning(message
					.substring(0, 128));
		} else {
			docomoChargingGatewayResp.setSubscriptionStatusMeaning(message);
		}

		docomoChargingGatewayResp.setStatus(0);
		docomoChargingGatewayResp.setStatusMeaning("Unread Message");
		docomoChargingGatewayResp.setSubscriptionFailId(data.getFailID());
		docomoChargingGatewayResp.setSubscriptionId(data.getId());
		docomoChargingGatewayResp.setSubscriberNumber(data.getMobileNo());
		docomoChargingGatewayResp.setPackName(data.getPackName());
		eventLoggingDAO.save(docomoChargingGatewayResp);

	}

	private void saveLogWithException(ApplicationException e,
			TempChargingData data) {

		// if (e.getId() !=
		// DocomoConstants.DCMO_RESP_GB_ENDUSERAUTHENTICATIONEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_GB_POLICYEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_GB_INVALIDARGUMENTEXCEPTION
		// || e.getId() == DocomoConstants.DCMO_RESP_CU_UNKNOWNENDUSEREXCEPTION
		// || e.getId() ==
		// DocomoConstants.DCMO_RESP_CU_INVALIDARGUMENTEXCEPTION) {
		// log.info("not a low balance case..the error id is.." + e.getId());
		// return;
		// }
		//
		// DocomoChargingGatewayResp docomoChargingGatewayResp = new
		// DocomoChargingGatewayResp();
		// docomoChargingGatewayResp.setPackId(data.getPackID());
		// docomoChargingGatewayResp.setPackName(data.getPackName());
		// if (data.getStatus() == Constants.STATUS_SUBSCRIBE) {
		// docomoChargingGatewayResp
		// .setSubscriptionStatus(Constants.STATUS_NEW_TO_LOW_BALANCE_FAIL);
		// } else {
		// docomoChargingGatewayResp
		// .setSubscriptionStatus(Constants.STATUS_RENEW_TO_LOW_BALANCE_FAIL);
		// }
		//
		// String message = e.getId() + " - " + e.getMessage();
		//
		// if (message.length() > 128) {
		// docomoChargingGatewayResp.setSubscriptionStatusMeaning(message
		// .substring(0, 128));
		// } else {
		// docomoChargingGatewayResp.setSubscriptionStatusMeaning(message);
		// }
		//
		// docomoChargingGatewayResp.setStatus(0);
		// docomoChargingGatewayResp.setStatusMeaning("Unread Message");
		// docomoChargingGatewayResp.setSubscriptionFailId(data.getFailID());
		// docomoChargingGatewayResp.setSubscriptionId(data.getId());
		// docomoChargingGatewayResp.setSubscriberNumber(data.getMobileNo());
		// docomoChargingGatewayResp.setPackName(data.getPackName());
		// eventLoggingDAO.save(docomoChargingGatewayResp);

	}

	private void saveRelianceRevenue(TempChargingData data, SubscriptionBean sb,
			int response_code) {
		// if(response_code!=0){
		// return;
		// }

		RelianceSamResponse relianceSamResponse = new RelianceSamResponse();
		relianceSamResponse.setCircle_id(sb.getRegionId());
		relianceSamResponse.setCircle_name(sb.getCircleName());
		relianceSamResponse.setEnddate(sb.getNextchargingDate());
		relianceSamResponse.setLogtime(CommonFunctions.getCurrentDate());
		relianceSamResponse.setPack_id(sb.getSubscriptionPackId());
		relianceSamResponse.setPack_name(sb.getPackName());
		relianceSamResponse.setResponse_code(response_code);
		relianceSamResponse.setStartdate(sb.getActivationDate());
		relianceSamResponse.setSubscriber_number(sb.getSubscriberNo());
		relianceSamResponse.setValidity(Integer.parseInt(sb.getValidity()));
		relianceSamResponse.setSubscriber_type("new");
		relianceSamResponse.setRequest_from("cortex");

		eventLoggingDAO.save(relianceSamResponse);
	}

	private void saveLogWithRechargeSuccess(TempChargingData data,
			SubscriptionBean sb) {
		DocomoChargingGatewayResp docomoChargingGatewayResp = new DocomoChargingGatewayResp();
		docomoChargingGatewayResp.setAmount(sb.getAmount());
		docomoChargingGatewayResp.setMinutes(sb.getMinutes());//
		docomoChargingGatewayResp.setPackId(sb.getSubscriptionPackId());
		docomoChargingGatewayResp.setPackName(sb.getPackName());
		docomoChargingGatewayResp
				.setSubscriptionStatus(Constants.STATUS_RECHARGED);
		docomoChargingGatewayResp
				.setSubscriptionStatusMeaning("User Successfully RECharged");
		docomoChargingGatewayResp.setStatus(0);
		docomoChargingGatewayResp.setStatusMeaning("Unread Message");
		// docomoChargingGatewayResp.setSubscriptionFailId(data.getFailID());
		docomoChargingGatewayResp.setSubscriptionId(data.getId());
		docomoChargingGatewayResp.setSubscriberNumber(data.getMobileNo());
		docomoChargingGatewayResp.setValidDate(sb.getNextchargingDate());

		eventLoggingDAO.save(docomoChargingGatewayResp);
	}

	private int getValidity(Map packPriceValidityMap, int amountToCharge) {
		LinkedHashMap lhm = (LinkedHashMap) packPriceValidityMap;
		Object object = lhm.get(amountToCharge);
		if (object == null) {
			return 0;
		}

		if (object instanceof PriceValueBean) {
			return ((PriceValueBean) object).getValidity();
		} else {
			return ((RenewalPriceValueBean) object).getValidity();
		}
	}

	private int getMinutes(Map packPriceValidityMap, int amountToCharge) {
		LinkedHashMap lhm = (LinkedHashMap) packPriceValidityMap;
		Object object = lhm.get(amountToCharge);
		if (object == null) {
			return 0;
		}

		if (object instanceof PriceValueBean) {
			return ((PriceValueBean) object).getMinutes();
		} else {
			return ((RenewalPriceValueBean) object).getMinutes();
		}

	}

	private int getAmountToCharge(Map packPriceValidityMap, int balance) {
		log.info("balance - " + balance);
		balance = balance - 100;
		log.info("checing balance - " + balance + " in map "
				+ packPriceValidityMap.keySet());

		Object object = packPriceValidityMap.get(balance);

		if (object != null) {
			return balance;
		} else {
			// Object is null
			LinkedHashMap lhm = (LinkedHashMap) packPriceValidityMap;
			Iterator iter = lhm.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				int packAmount = (Integer) entry.getKey();
				if (balance >= packAmount) {
					return packAmount;
				}
			}
		}

		return 0;
	}

	private void saveTransactionLogWithException(TempChargingData data,
			Exception e, String request, String response, String requestType,
			int validityDays, int priceCharged) {

		String chargingDate = "" + CommonFunctions.getCurrentDate();
		String subscriptionStatus = "" + data.getStatus();
		String chargingStatus = "FAILED" + requestType;
		String reason = e.getMessage(); // size 20
		if (reason.length() > 20) {
			reason = reason.substring(0, 20);
		}
		String circleName = data.getCircleName();

		String operatorName = data.getOperatorName();
		int operatorId = data.getOperator();
		String sms = "";
		int status = 1;

		eventLoggingDAO.saveTransaction(circleName, data.getCircleId(),
				data.getPackName(), data.getPackID(), data.getMobileNo(),
				data.getActivationDate(), priceCharged, chargingDate,
				subscriptionStatus, chargingStatus, reason, operatorName,
				operatorId, sms, request, response, status, data.getSource(),
				null);
	}

	private void saveTransactionLogWithSuccess(TempChargingData data,
			String request, String response, String requestType,
			int validityDays, int priceCharged, String renewDate) {
		String chargingDate = "" + CommonFunctions.getCurrentDate();
		String subscriptionStatus = "" + data.getStatus();
		String chargingStatus = "SUCCESS" + requestType;
		String reason = ""; // size 20
		String operatorName = data.getOperatorName();
		int operatorId = data.getOperator();
		String sms = "";
		int status = 0;
		String circleName = data.getCircleName();
		eventLoggingDAO.saveTransaction(circleName, data.getCircleId(),
				data.getPackName(), data.getPackID(), data.getMobileNo(),
				data.getActivationDate(), priceCharged, chargingDate,
				subscriptionStatus, chargingStatus, reason, operatorName,
				operatorId, sms, request, response, status, data.getSource(),
				renewDate);

	}

	SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmssyyyyyy");

	private String getReferenceCode() {
		/*
		 * referenceCode = 11291404280000801856
		 * 
		 * The length is 20, and can uniquely identify a request, the generation
		 * rule is: MMDDHHMMSSYYYYYYXXXX, LAST XXXX will be any four digit.
		 * Length will be always 20 not < 20 and not > 20
		 */
		// tter = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
		String random = "" + Math.random();
		random = random.substring(2, 6);
		return sdf.format(Calendar.getInstance().getTime()) + random;
	}

	public void initSMS(int operatorId, int circleId) {
		// ContentDeliveryGateway contentDeliveryGateway = null;
		// try {
		// if (queryStringToSendSMS.length() != 0)
		// queryStringToSendSMS.delete(0, queryStringToSendSMS.length());
		// // queryString = new StringBuffer();
		// contentDeliveryGateway = chargingDAO.getSMSDeliveryGWdetails(
		// operatorId, circleId);
		// this.urlStr = contentDeliveryGateway.getUrl();
		// List params = chargingDAO
		// .getSmsGWKeyValuePairs(contentDeliveryGateway
		// .getGatewayId());
		// for (Object param : params) {
		// GatewayParameter gp = (GatewayParameter) param;
		// queryStringToSendSMS.append(gp.getKey() + "=" + gp.getValue()
		// + "&");
		// }
		// } catch (Exception e) {
		//
		// }
		//
	}

	/*
	 * **************************************************************************
	 * ********************* **************** The following method send the SMS
	 * to a particular mobile *********************
	 * *****************************
	 * ******************************************************************
	 */

	public void sendSMS(Long mobileNo, String smsString, String adminSenderId,
			TempChargingData tempChargingData, String circleName,
			String chargingStatus) {
		log.info("called");
		log.info("urlStr - " + this.urlStr);
		log.info("queryString - " + queryStringToSendSMS);

		StringBuffer sbData = null;
		String message = "";
		String localUrlStr = this.urlStr + "?" + this.queryStringToSendSMS
				+ "MobNo=" + mobileNo + "&MSG=" + smsString;
		log.info("localUrlStr ----> " + localUrlStr);
		localUrlStr = localUrlStr.replace(" ", "%20");
		// http://203.115.112.8/smpp/SendMT.aspx?
		// MobNo=<Mobileno>&MSG=<Message>&Type=text&user=NZ&pass=NZ@123&Uni=f&Source=56363&op_id=OP_REL
		try {

			URL url = new URL(localUrlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.connect();
			log.info("done");
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			sbData = new StringBuffer();
			String data = null;

			while ((data = br.readLine()) != null) {
				sbData.append(data);
			}

			message = "SMS successfully delivered. Details are url"
					+ localUrlStr + ", mobileNo:" + mobileNo;

			log.info("Response - " + sbData.toString());

			String responseCode = null;
			if (sbData.toString().length() > 0) {
				responseCode = sbData.toString().substring(0, 1);
				if (responseCode != null && !responseCode.equals("0")
						&& !responseCode.equals("3")) {
					throw new ApplicationException(
							"Response code is not the either 0 or 3 which means a failure");
				}
			}

			// manup: note that we are not storing the response
			// eventLoggingDAO.saveTransaction(circleName, tempChargingData
			// .getCircleId(), tempChargingData.getPackName(),
			// tempChargingData.getPackID(), mobileNo, tempChargingData
			// .getActivationDate(), tempChargingData.getPrice(),
			// CommonFunctions.getCurrentDate(), tempChargingData
			// .getTypeOfRequest(), DocomoConstants.STR_ACTION_SMS_SENT,
			// "SMS is sent", tempChargingData.getOperatorName(),
			// tempChargingData.getOperator(),
			// smsString,urlStr,sbData.toString(),
			// DocomoConstants.STATUS_SUCCESS );

		} catch (Exception e) {
			// eventLoggingDAO.saveTransaction(circleName, tempChargingData
			// .getCircleId(), tempChargingData.getPackName(),
			// tempChargingData.getPackID(), mobileNo, tempChargingData
			// .getActivationDate(), tempChargingData.getPrice(),
			// CommonFunctions.getCurrentDate(), tempChargingData
			// .getTypeOfRequest(),
			// DocomoConstants.STR_ACTION_SMS_NOT_SENT, "SMS sending failed",
			// tempChargingData.getOperatorName(), tempChargingData
			// .getOperator(), smsString,urlStr,sbData.toString(),
			// DocomoConstants.STATUS_FAILURE);

			message = "Error while sending sms. Details are url:" + localUrlStr
					+ ", mobileNo:" + mobileNo;
			log.error(message + " - " + e.getMessage(), e.fillInStackTrace());

		}

	}

	public static String send(String urlStr, String requestXML, Hashtable header)
			throws ApplicationException {
		StringBuffer sbData = new StringBuffer();
		HttpURLConnection conn = null;
		InputStream is = null;
		OutputStream dos = null;
		try {
			log.info("Connecting to URL - " + urlStr);
			log.info("Request XML - " + requestXML);

			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			Enumeration kyes = header.keys();
			while (kyes.hasMoreElements()) {
				String key = (String) kyes.nextElement();
				String value = (String) header.get(key);
				log.info("Header - " + key + ":" + value);
				conn.setRequestProperty(key, value);
			}
			conn.setRequestProperty("Connection", "close");
			conn.setRequestProperty("Content-Length", "" + requestXML.length());

			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			dos = conn.getOutputStream();
			dos.write(requestXML.getBytes());

			int resCode = conn.getResponseCode();
			log.info("resCode: " + resCode);
			if (resCode != 200) {
				throw new ApplicationException(
						DocomoConstants.DCMO_RESP_CONN_NO_200,
						"Haven't Received 200 as response code from Charging Gateway but it is - "
								+ resCode);
			}

			is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data = null;
			while ((data = br.readLine()) != null) {
				sbData.append(data);
			}
		} catch (ApplicationException e) {
			log.error("Exception - " + e);
			throw e;
		} catch (Exception e) {
			log.error("Exception - " + e);
			throw new ApplicationException(
					DocomoConstants.DCMO_RESP_CONN_ERROR, "Connection Error");
		} finally {
			try {
				if (dos != null)
					dos.close();

				if (is != null)
					is.close();

				conn.disconnect();
			} catch (Exception e) {
				log.error("Exception - " + e);
			}
		}

		log.info("response: " + sbData.toString());
		return sbData.toString();
	}

	public static String sendHttpPostRequest(String strURL, Map data)
			throws Exception {
		log.info("Sending Request to -- " + strURL);
		PostMethod post = null;
		String response = null;
		try {
			strURL = strURL.replace(" ", "%20");
			HttpClient httpclient = new HttpClient();
			post = new PostMethod(strURL);

			Iterator iter = data.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				if (entry.getValue() != null
						&& ((String) entry.getValue()).length() != 0) {
					log.info("setting.." + (String) entry.getKey() + " - "
							+ (String) entry.getValue());
					post.setParameter((String) entry.getKey(),
							(String) entry.getValue());
				}
			}

			log.info("Set all the data...now sending.."
					+ post.getParameters().length);
			int result = httpclient.executeMethod(post);
			log.info("http response code - " + result);

			response = post.getResponseBodyAsString();
			log.info("response - " + response);
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			// Release current connection to the connection pool
			// once you are done
			if (post != null) {
				post.releaseConnection();
			}
		}

		return response;
	}

	public static String sendHttpPostRequest(String strURL, String requestXML,
			Hashtable header) throws Exception {
		log.info("Sending Request to -- " + strURL);
		PostMethod post = null;
		String response = null;
		try {
			strURL = strURL.replace(" ", "%20");
			HttpClient httpclient = new HttpClient();
			post = new PostMethod(strURL);

			post.setRequestBody(requestXML);

			Iterator iter = header.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				if (entry.getValue() != null
						&& ((String) entry.getValue()).length() != 0) {
					log.info("setting.." + (String) entry.getKey() + " - "
							+ (String) entry.getValue());
					String headerName = (String) entry.getKey();
					String headerValue = (String) entry.getValue();

					post.setRequestHeader(headerName, headerValue);

				}
			}

			log.info("Set all the data...now sending.."
					+ post.getParameters().length);
			int resCode = httpclient.executeMethod(post);
			log.info("http response code - " + resCode);

			if (resCode != 200) {
				throw new ApplicationException(
						DocomoConstants.DCMO_RESP_CONN_NO_200,
						"Haven't Received 200 as response code from Charging Gateway but it is - "
								+ resCode);
			}

			response = post.getResponseBodyAsString();
			log.info("response - " + response);
		} catch (Exception e) {
			log.error(e);
			throw e;
		} finally {
			// Release current connection to the connection pool
			// once you are done
			if (post != null) {
				post.releaseConnection();
			}
		}

		return response;
	}

	// @Override
	// public void close() {
	// // TODO Auto-generated method stub
	//
	// }
}
