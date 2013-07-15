package org.ariose.sms;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.ConfigurationDAO;
import org.ariose.dao.EventLoggingDAO;
import org.ariose.dao.SubscriberDAO;
import org.ariose.model.ChargingGateway;
import org.ariose.model.CircleBean;
import org.ariose.model.GmlcConfiguration;
import org.ariose.model.NumseriesBean;
import org.ariose.model.OperatorBean;
import org.ariose.model.SubscriptionBean;
import org.ariose.util.ApplicationException;
import org.ariose.util.CommonFunctions;
import org.ariose.util.Constants;

/**
 * 
 * @author Manu Parmar Jan 2011 For 2Ergo Idea Integration
 */

public class SubscriptionManagerImpl implements SubscriptionManager {
	String smscConnectionNeeded = null;
	static SimpleDateFormat outputFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	static SimpleDateFormat inputFormat = new SimpleDateFormat(
			"dd-MM-yy HH:mm a");

	// IF a subscriber sends multiple requests for the same Pack ID. We Have to
	// drop rest of the requests.
	private static Log log = LogFactory.getLog(SubscriptionManagerImpl.class);
	static Locale locale = Locale.ENGLISH;
	static ResourceBundle myResources = ResourceBundle.getBundle(
			"subscription", locale);
	private SubscriberDAO subscriberDao;
	private EventLoggingDAO eventLoggingDao;
	private RelianceManagerImpl relianceManagerImpl;
	private ConfigurationDAO configurationDAO;
	private String deactivationUrlStr;

	public void setConfigurationDAO(ConfigurationDAO configurationDAO) {
		this.configurationDAO = configurationDAO;
	}

	public void setSmscConnectionNeeded(String smscConnectionNeeded) {
		this.smscConnectionNeeded = smscConnectionNeeded;

		if (this.smscConnectionNeeded.equals("true")) {
			createReceiversAndSenders();
		}
	}

	/**
	 * @return the subscriberDao
	 */
	public SubscriberDAO getSubscriberDao() {
		return subscriberDao;
	}

	/**
	 * @param subscriberDao
	 *            the subscriberDao to set
	 */
	public void setSubscriberDao(SubscriberDAO subscriberDao) {
		this.subscriberDao = subscriberDao;
		try {
			loadCircles();
			loadOperators();
			init();

		} catch (Exception e) {
			log.error(e + "-" + e.getMessage());
		}
	}

	/**
	 * @return the eventLoggingDao
	 */
	public EventLoggingDAO getEventLoggingDao() {
		return eventLoggingDao;
	}

	/**
	 * @param eventLoggingDao
	 *            the eventLoggingDao to set
	 */
	public void setEventLoggingDao(EventLoggingDAO eventLoggingDao) {
		this.eventLoggingDao = eventLoggingDao;
	}

	public void setRelianceManagerImpl(RelianceManagerImpl relianceManagerImpl) {
		this.relianceManagerImpl = relianceManagerImpl;
	}

	public void init() {
		log.info("called .. ");
		ChargingGateway chargingGateway = subscriberDao
				.getChargingGatewayForOperator(Constants.OPERATOR_ID_RELIANCE);
		if (chargingGateway == null) {
			log.error("No Gateway For Reliance Operator with ID["
					+ Constants.OPERATOR_ID_RELIANCE + "]");
			return;
		}

		/*
		 * It must be of the type
		 * 
		 * http://202.138.125.19:8090/cgi-BIN/externalrouting/routing.cgi?TYPE=$TYPE
		 * &appid=$APPID&channel=$CHANNEL&mdn=$MDN&ACTION=$ACTION
		 */
		deactivationUrlStr = chargingGateway.getUrl();
	}

	private static Map circleHashMap = new HashMap();
	private static Map circleNameHashMap = new HashMap();
	private static Map operatorHashMap = new HashMap();

	private void loadCircles() throws Exception {
		if (circleHashMap.size() == 0 || circleNameHashMap.size() == 0) {
			List circleDetails = subscriberDao.getCircleName();
			int circleSize = circleDetails.size();
			for (int c = 0; c < circleSize; c++) {
				CircleBean circleBean = (CircleBean) circleDetails.get(c);
				circleHashMap.put(circleBean.getId(),
						circleBean.getCircleName());
				circleNameHashMap.put(circleBean.getCircleName(),
						circleBean.getId());
			}
		}
	}

	private String getCircleName(int id) {
		log.warn("called..");
		String circleName = "";
		try {
			loadCircles();
			if (circleHashMap.get(id) != null) {
				circleName = (String) circleHashMap.get(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.warn("done..");
		return circleName;
	}

	private void loadOperators() throws Exception {
		if (operatorHashMap.size() == 0) {
			List operators = subscriberDao.getOperators();
			int operatorsSize = operators.size();
			for (int c = 0; c < operatorsSize; c++) {
				OperatorBean operatorBean = (OperatorBean) operators.get(c);
				operatorHashMap.put(operatorBean.getId(),
						operatorBean.getOperatorName());
			}
		}
	}

	private String getOperatorName(int id) {
		log.warn("called..");
		String operatorName = "";
		try {
			loadOperators();
			if (operatorHashMap.get(id) != null) {
				operatorName = (String) operatorHashMap.get(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		log.warn("done..");
		return operatorName;
	}

	private void sendSMS(String sid, String sms, String shortCode,
			String smsckey) throws Exception {
		if (shortCode == null) {
			shortCode = "111111";
		}

		GmlcConfiguration config = null;
		// String key = "reliance_smsc";

		// SMPPIntegration.sendSms(sid, sms, shortCode, config, key);
		SMPPIntegration.sendSmsViaTransceiver(sid, sms, shortCode, config,
				smsckey);
	}

	// static String SENDSMS_SHORTCODE = "UW-655551";

	public SubscriptionBean SendSMS(String requestUrl, String sid, String sms,
			String shortcode, String smsckey, String needValidation)
			throws ApplicationException {
		log.info("called.." + shortcode);
		String operatorName = "Reliance";
		int operatorId = Constants.OPERATOR_ID_RELIANCE;
		String circleName = null;
		int circleId = 0;
		String packName = "";
		int packId = 0;
		String subscriberNumber = "";
		int channelId = 0;
		String requestTime = CommonFunctions.getCurrentDate();
		String subscriptionStatus = "";

		// String shortcode = "0";
		String response = "";
		String keyword = "";
		// String shortcode = "";
		String smssenderkey = null;
		try {
			// validate msisdn
			if (!needValidation.equals("true")) {
				sendSMS(sid, sms, shortcode, smsckey);
				return null;
			}

			Map paramMap = validateMsisdn(sid);
			Object obj = paramMap.get("circleid");
			if (obj != null) {
				circleId = (Integer) circleId;
			}

			obj = paramMap.get("circlename");
			if (obj != null) {
				circleName = (String) obj;
			}

			if (sms == null || sms.trim().length() == 0) {
				throw new ApplicationException(DocomoConstants.ERROR_IN_SMS,
						"Error in SMS");
			}

			sendSMS(sid, sms, shortcode, smsckey);
			response = "success";

			// eventLoggingDao.saveSubsRequestLog(operatorName, operatorId,
			// circleName, circleId, packName, packId, subscriberNumber,
			// keyword, channelId, requestTime, subscriptionStatus,
			// shortcode, requestUrl, response);
		} catch (ApplicationException e) {
			// log.error(e.getId() + " - " + e.getMessage());
			response = "failure";
			// eventLoggingDao.saveSubsRequestLog(operatorName, operatorId,
			// circleName, circleId, packName, packId, subscriberNumber,
			// keyword, channelId, requestTime, "Error " + e.getId()
			// + " - " + e.getMessage(), shortcode, requestUrl,
			// response);
			throw e;
		} catch (Exception e) {
			response = "failure";
			// log.error(e);
			String error = "Error " + "" + e;
			if (error.length() > 100) {
				error = error.substring(0, 100);
			}
			// eventLoggingDao.saveSubsRequestLog(operatorName, operatorId,
			// circleName, circleId, packName, packId, subscriberNumber,
			// keyword, channelId, requestTime, error, shortcode,
			// requestUrl, response);
			throw new ApplicationException(DocomoConstants.ERROR_SOME_ISSUE,
					error);
		}

		return null;
	}

	private Map validateMsisdn(String data) throws ApplicationException {
		// log.info("called..");
		Map paramMap = new HashMap();
		int circleId = 0;
		try {
			CommonFunctions.checkNull("SID", data);

			int mobileLength = data.length();
			if (mobileLength < 10)
				throw new Exception();
			if (mobileLength > 10) {
				data = data.substring(mobileLength - 10, mobileLength);
			}
		} catch (Exception e) {
			// log.error(e);
			throw new ApplicationException(DocomoConstants.ERROR_IN_MSISDN,
					"Error in SID");
		}

		String msisdnStr = data;
		msisdnStr = msisdnStr.substring(0, 4);
		// log.info("Checking in NUMSERIES..." + msisdnStr);
		List<NumseriesBean> numseriesBeanList = subscriberDao.getNumseries(
				msisdnStr, null);
		if (numseriesBeanList.size() == 0) {
			// log.error("No Circle found for this number series..will associate "
			// +
			// "this number with circleid as 0 in logs and subscription table. Number series is "
			// + msisdnStr);
		} else {
			NumseriesBean numseriesBean = numseriesBeanList.get(0);
			// log.info("Got one row of NumseriesBean with ID - "
			// + numseriesBean.getId());
			circleId = numseriesBean.getCircleId();
			// log.info("Circle ID - " + numseriesBean.getCircleId());
			paramMap.put("circleid", numseriesBean.getCircleId());
			try {
				paramMap.put("circlename",
						getCircleName(numseriesBean.getCircleId()));
				// log.info("Circlename - "
				// + getCircleName(numseriesBean.getCircleId()));
			} catch (Exception e) {
				// log.error(e);
			}
		}

		return paramMap;
	}

	private void createReceiversAndSenders() {
		log.info("called..");
		try {
			List gmlcConfigs = configurationDAO.getGmlcConfiguration();
			int size = gmlcConfigs.size();
			Map receiverMap = new HashMap();
			for (int c = 0; c < size; c++) {
				GmlcConfiguration config = (GmlcConfiguration) gmlcConfigs
						.get(c);
				try {
					log.warn("Connecting to SMSC with ID [" + config.getId()
							+ "] and IP [" + config.getIpaddress()
							+ "] and Key[" + config.getShortcode() + "]");
					SMSReceiveThread t = new SMSReceiveThread();
					SMPPAsyncReceiver asyncRcv = new SMPPAsyncReceiver();
					asyncRcv.setEventLoggingDAO(eventLoggingDao);
					asyncRcv.loadProperties(config);
					t.setSmppAsyncReceiver(asyncRcv);
					t.start();
					receiverMap.put(config.getShortcode(), asyncRcv);
				} catch (Exception e) {
					log.error("Error creating receiever.." + config.getId()
							+ ", error is.." + e);
				}
			}

			log.warn("Receivers Created[" + receiverMap.size() + "]");
			SMPPIntegration.setReceiverMap(receiverMap);

		} catch (Exception e) {
			log.error(e);
		}

		log.info("ended..");
	}
}