package org.ariose.dao.hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.EventLoggingDAO;
import org.ariose.model.ContentDeliveryLog;
import org.ariose.model.DocomoChargingGatewayResp;
import org.ariose.model.DocomoPrerenewalInfo;
import org.ariose.model.IdeaChargingGatewayResponseBean;
import org.ariose.model.RelianceSamResponse;
import org.ariose.model.SubsRequestLog;
import org.ariose.model.SubsRequestLog1;
import org.ariose.model.SubsRequestLog10;
import org.ariose.model.SubsRequestLog11;
import org.ariose.model.SubsRequestLog12;
import org.ariose.model.SubsRequestLog2;
import org.ariose.model.SubsRequestLog3;
import org.ariose.model.SubsRequestLog4;
import org.ariose.model.SubsRequestLog5;
import org.ariose.model.SubsRequestLog6;
import org.ariose.model.SubsRequestLog7;
import org.ariose.model.SubsRequestLog8;
import org.ariose.model.SubsRequestLog9;
import org.ariose.model.TransactionBean;
import org.ariose.model.TransactionBean1;
import org.ariose.model.TransactionBean10;
import org.ariose.model.TransactionBean11;
import org.ariose.model.TransactionBean12;
import org.ariose.model.TransactionBean2;
import org.ariose.model.TransactionBean3;
import org.ariose.model.TransactionBean4;
import org.ariose.model.TransactionBean5;
import org.ariose.model.TransactionBean6;
import org.ariose.model.TransactionBean7;
import org.ariose.model.TransactionBean8;
import org.ariose.model.TransactionBean9;
import org.ariose.model.UninorDeactivationBean;
import org.ariose.model.UninorRevenueBean;
import org.ariose.model.VMIChargingGatewayResp;
import org.ariose.model.VMIPrerenewalInfo;
import org.ariose.util.CommonFunctions;
import org.ariose.util.Constants;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventLoggingDAOHibernate extends HibernateDaoSupport implements
		EventLoggingDAO {

	private static Log log = LogFactory.getLog(EventLoggingDAOHibernate.class);

	public void saveAuditLog(String loginId, int moduleId, String moduleName,
			String eventDescription) {

		// try {
		// AuditLogBean al = new AuditLogBean();
		// al.setLoginId(loginId);
		// al.setModuleId(moduleId);
		// al.setModuleName(moduleName);
		// al.setEventDescription(eventDescription);
		// // al.setTimeStamp(CommonFunctions.getCurrentDate());
		// //log.info("Current Date : " + new Date());
		// al.setTimeStamp(new Date());
		// //log.info(al);
		// // getHibernateTemplate().saveOrUpdateCopy(al);
		// getHibernateTemplate().save(al);
		// } catch (Exception e) {
		// log.error("error:", e.fillInStackTrace());
		//
		// /*
		// * manup:bugfix:5may:don't do anthing
		// */
		// }
	}

	/*
	 * manup:added:28apr09
	 */
	public void saveSubsRequestLog(String operatorName, int operatorId,
			String circleName, int circleId, String packName, int packId,
			String subscriberNumber, String keyword, int channelId,
			String requestTime, String subscriptionStatus, String shortcode,
			String request) {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		SubsRequestLog subReqlog = null;
		switch (month) {
		case Calendar.JANUARY: {
			subReqlog = new SubsRequestLog1();
			break;
		}
		case Calendar.FEBRUARY: {
			subReqlog = new SubsRequestLog2();
			break;
		}
		case Calendar.MARCH: {
			subReqlog = new SubsRequestLog3();
			break;
		}
		case Calendar.APRIL: {
			subReqlog = new SubsRequestLog4();
			break;
		}
		case Calendar.MAY: {
			subReqlog = new SubsRequestLog5();
			break;
		}
		case Calendar.JUNE: {
			subReqlog = new SubsRequestLog6();
			break;
		}
		case Calendar.JULY: {
			subReqlog = new SubsRequestLog7();
			break;
		}
		case Calendar.AUGUST: {
			subReqlog = new SubsRequestLog8();
			break;
		}
		case Calendar.SEPTEMBER: {
			subReqlog = new SubsRequestLog9();
			break;
		}
		case Calendar.OCTOBER: {
			subReqlog = new SubsRequestLog10();
			break;
		}
		case Calendar.NOVEMBER: {
			subReqlog = new SubsRequestLog11();
			break;
		}
		case Calendar.DECEMBER: {
			subReqlog = new SubsRequestLog12();
			break;
		}
		}

		try {
			subReqlog.setOperatorName(operatorName);
			subReqlog.setOperatorId(operatorId);
			subReqlog.setCircleName(circleName);
			subReqlog.setCircleId(circleId);
			subReqlog.setPackName(packName);
			subReqlog.setPackId(packId);
			subReqlog.setSubscriberNumber(subscriberNumber);
			subReqlog.setKeyword(keyword);
			subReqlog.setChannelId(channelId);
			subReqlog.setRequestTime(new Date());

			if (subscriptionStatus != null && subscriptionStatus.length() > 100) {
				subReqlog.setSubscriptionStatus(subscriptionStatus.substring(0,
						100));
			} else {
				subReqlog.setSubscriptionStatus(subscriptionStatus);
			}

			subReqlog.setShortcode(shortcode);
			subReqlog.setRequest(request);
			//log.info(subReqlog);
			getHibernateTemplate().save(subReqlog);
		} catch (Exception e) {
			log.error("error while storing subscription request log..",
					e.fillInStackTrace());
		}
	}

	// fetch records
	public List<SubsRequestLog> getSubsRequestLogs(long subsciberNo, int month) {
		String subReqlog = "SubsRequestLog" + String.valueOf(month);
		String queryString = "from " + subReqlog
				+ " s where s.subscriberNumber = " + subsciberNo
				+ " order by id desc";
		//log.info("queryString:" + queryString);
		return getHibernateTemplate().find(queryString);
	}

	public List<TransactionBean> getTransactionLogs(long subsciberNo, int month) {
		String transactionlog = "TransactionBean" + String.valueOf(month);
		String queryString = "from " + transactionlog
				+ " t where t.subscriberNumber = " + subsciberNo
				+ " order by id desc";
		//log.info("queryString:" + queryString);
		return getHibernateTemplate().find(queryString);
	}

	public List<TransactionBean> getTransactionLogs(long subsciberNo,
			int month, int operatorId) {
		String transactionlog = "TransactionBean" + String.valueOf(month);
		String queryString = "from " + transactionlog
				+ " t where t.subscriberNumber = " + subsciberNo
				+ " and t.operatorId = " + operatorId
				+ " and t.request like '%chargeUser%'" + " order by id desc";
		//log.info("queryString:" + queryString);
		return getHibernateTemplate().find(queryString);
	}

	public List<ContentDeliveryLog> getContentDeliveryLog(long subsciberNo,
			int month) {
		String transactionlog = "ContentDeliveryLog" + String.valueOf(month);
		String queryString = "from " + transactionlog
				+ " t where t.subscriberNumber = " + subsciberNo
				+ " order by id desc";
		//log.info("queryString:" + queryString);
		return getHibernateTemplate().find(queryString);
	}

	public List<ContentDeliveryLog> getCurrentDayContentDeliveryLog(int optrId,
			int circleId, int packId, String scheduleTime,
			int contentSchedulerId) {
		int month = (Calendar.getInstance().get(Calendar.MONTH)) + 1;
		String transactionlog = "ContentDeliveryLog" + String.valueOf(month);
		String queryString = "from " + transactionlog
				+ " t where t.operatorId=" + optrId + " and t.circleId="
				+ circleId + " and t.packId=" + packId
				+ " and DATE(logtime)=curdate() and t.contentSchedulerId="
				+ contentSchedulerId + " order by logtime asc";
		// //log.info("queryString:" + queryString);
		return getHibernateTemplate().find(queryString);
	}

	public long save(IdeaChargingGatewayResponseBean bean) {
		//log.info("called - " + bean);
		return (Long) getHibernateTemplate().save(bean);
	}

	public IdeaChargingGatewayResponseBean getIdeaChargingGatewayResponseBean(
			long ideaChargingGatewayResponseId) {
		//log.info("called - " + ideaChargingGatewayResponseId);
		return (IdeaChargingGatewayResponseBean) getHibernateTemplate().get(
				IdeaChargingGatewayResponseBean.class,
				ideaChargingGatewayResponseId);
	}

	public void update(IdeaChargingGatewayResponseBean bean) {
		//log.info("called - " + bean);
		getHibernateTemplate().update(bean);
	}

	public int saveIdeaTransaction(String circleName, int circleId,
			String packName, int packId, long mobileNo, String activationDate,
			int priceCharged, String chargingDate, String subscriptionStatus,
			String chargingStatus, String reason, String operatorName,
			int operatorId, String sms, String request, String response,
			int status) {

		//log.info("called..");

		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		TransactionBean transactionBean = null;
		switch (month) {
		case Calendar.JANUARY: {
			transactionBean = new TransactionBean1();
			break;
		}
		case Calendar.FEBRUARY: {
			transactionBean = new TransactionBean2();
			break;
		}
		case Calendar.MARCH: {
			transactionBean = new TransactionBean3();
			break;
		}
		case Calendar.APRIL: {
			transactionBean = new TransactionBean4();
			break;
		}
		case Calendar.MAY: {
			transactionBean = new TransactionBean5();
			break;
		}
		case Calendar.JUNE: {
			transactionBean = new TransactionBean6();
			break;
		}
		case Calendar.JULY: {
			transactionBean = new TransactionBean7();
			break;
		}
		case Calendar.AUGUST: {
			transactionBean = new TransactionBean8();
			break;
		}
		case Calendar.SEPTEMBER: {
			transactionBean = new TransactionBean9();
			break;
		}
		case Calendar.OCTOBER: {
			transactionBean = new TransactionBean10();
			break;
		}
		case Calendar.NOVEMBER: {
			transactionBean = new TransactionBean11();
			break;
		}
		case Calendar.DECEMBER: {
			transactionBean = new TransactionBean12();
			break;
		}
		}

		transactionBean.setCircleName(circleName);
		transactionBean.setCircleId(circleId);
		transactionBean.setPackName(packName);
		transactionBean.setPackId(packId);
		transactionBean.setSubscriberNumber(mobileNo);
		transactionBean.setActivationDate(activationDate);
		transactionBean.setPriceCharged(priceCharged);
		transactionBean.setChargingDate(chargingDate);
		transactionBean.setSubscriptionStatus(subscriptionStatus);
		transactionBean.setStatus(status);
		transactionBean.setRequest(request);
		transactionBean.setResponse(response);

		// //log.info("EventLogging is called 2 " + transactionBean.toString());
		if (subscriptionStatus.equals(Constants.STR_ACTION_NEW)
				&& chargingStatus.equals(Constants.STR_ACTION_ACTIVE)) {
			transactionBean.setActivationDate(CommonFunctions.getCurrentDate());
		}
		// //log.info("EventLogging is called 3 " + transactionBean.toString());
		transactionBean.setChargingStatus(chargingStatus);
		transactionBean.setReason(reason);
		transactionBean.setOperatorName(operatorName);
		transactionBean.setOperatorId(operatorId);
		transactionBean.setSmsString(sms);

		//log.info("EventLogging is called 4 " + transactionBean.toString());

		return (Integer) getHibernateTemplate().save(transactionBean);
	}

	public void saveSubsRequestLog(String operatorName, int operatorId,
			String circleName, int circleId, String packName, int packId,
			String subscriberNumber, String keyword, int channelId,
			String requestTime, String subscriptionStatus, String shortcode,
			String request, String response, String subscriptionStatusMeaning) {
		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		SubsRequestLog subReqlog = null;
		switch (month) {
		case Calendar.JANUARY: {
			subReqlog = new SubsRequestLog1();
			break;
		}
		case Calendar.FEBRUARY: {
			subReqlog = new SubsRequestLog2();
			break;
		}
		case Calendar.MARCH: {
			subReqlog = new SubsRequestLog3();
			break;
		}
		case Calendar.APRIL: {
			subReqlog = new SubsRequestLog4();
			break;
		}
		case Calendar.MAY: {
			subReqlog = new SubsRequestLog5();
			break;
		}
		case Calendar.JUNE: {
			subReqlog = new SubsRequestLog6();
			break;
		}
		case Calendar.JULY: {
			subReqlog = new SubsRequestLog7();
			break;
		}
		case Calendar.AUGUST: {
			subReqlog = new SubsRequestLog8();
			break;
		}
		case Calendar.SEPTEMBER: {
			subReqlog = new SubsRequestLog9();
			break;
		}
		case Calendar.OCTOBER: {
			subReqlog = new SubsRequestLog10();
			break;
		}
		case Calendar.NOVEMBER: {
			subReqlog = new SubsRequestLog11();
			break;
		}
		case Calendar.DECEMBER: {
			subReqlog = new SubsRequestLog12();
			break;
		}
		}

		try {
			subReqlog.setOperatorName(operatorName);
			subReqlog.setOperatorId(operatorId);
			subReqlog.setCircleName(circleName);
			subReqlog.setCircleId(circleId);
			subReqlog.setPackName(packName);
			subReqlog.setPackId(packId);
			subReqlog.setSubscriberNumber(subscriberNumber);
			subReqlog.setKeyword(keyword);
			subReqlog.setChannelId(channelId);
			subReqlog.setRequestTime(new Date());

			if (subscriptionStatus != null && subscriptionStatus.length() > 100) {
				subReqlog.setSubscriptionStatus(subscriptionStatus.substring(0,
						100));
			} else {
				subReqlog.setSubscriptionStatus(subscriptionStatus);
			}

			subReqlog.setShortcode(shortcode);
			subReqlog.setRequest(request);
			subReqlog.setResponse(response);
			subReqlog.setSubscriptionStatusMeaning(subscriptionStatusMeaning);
			//log.info(subReqlog);
			getHibernateTemplate().save(subReqlog);
		} catch (Exception e) {
			log.error("error while storing subscription request log..",
					e.fillInStackTrace());
		}

	}

	@Override
	public long save(UninorRevenueBean bean) {
		//log.info("called " + bean);
		return (Long) getHibernateTemplate().save(bean);
	}

	@Override
	public void save(DocomoChargingGatewayResp docomoChargingGatewayResp) {
		long id = (Long) getHibernateTemplate().save(docomoChargingGatewayResp);
		//log.info("Saved bean with ID - " + id);
	}

	@Override
	public void save(DocomoPrerenewalInfo docomoPrerenewalInfo) {
		long id = (Long) getHibernateTemplate().save(docomoPrerenewalInfo);
		//log.info("Saved bean with ID - " + id);
	}

	public void saveTransaction(String circleName, int circleId,
			String packName, int packId, long mobileNo, String activationDate,
			int priceCharged, String chargingDate, String subscriptionStatus,
			String chargingStatus, String reason, String operatorName,
			int operatorId, String sms, String request, String response,
			int status, String source, String renewDate) {

		//log.info("called for subscriber.." + mobileNo + " and pack_id.."
//				+ packId + " and charging status as.." + chargingStatus);

		Calendar c = Calendar.getInstance();
		int month = c.get(Calendar.MONTH);
		TransactionBean transactionBean = null;
		switch (month) {
		case Calendar.JANUARY: {
			transactionBean = new TransactionBean1();
			break;
		}
		case Calendar.FEBRUARY: {
			transactionBean = new TransactionBean2();
			break;
		}
		case Calendar.MARCH: {
			transactionBean = new TransactionBean3();
			break;
		}
		case Calendar.APRIL: {
			transactionBean = new TransactionBean4();
			break;
		}
		case Calendar.MAY: {
			transactionBean = new TransactionBean5();
			break;
		}
		case Calendar.JUNE: {
			transactionBean = new TransactionBean6();
			break;
		}
		case Calendar.JULY: {
			transactionBean = new TransactionBean7();
			break;
		}
		case Calendar.AUGUST: {
			transactionBean = new TransactionBean8();
			break;
		}
		case Calendar.SEPTEMBER: {
			transactionBean = new TransactionBean9();
			break;
		}
		case Calendar.OCTOBER: {
			transactionBean = new TransactionBean10();
			break;
		}
		case Calendar.NOVEMBER: {
			transactionBean = new TransactionBean11();
			break;
		}
		case Calendar.DECEMBER: {
			transactionBean = new TransactionBean12();
			break;
		}
		}

		transactionBean.setCircleName(circleName);
		transactionBean.setCircleId(circleId);
		transactionBean.setPackName(packName);
		transactionBean.setPackId(packId);
		transactionBean.setSubscriberNumber(mobileNo);
		transactionBean.setActivationDate(activationDate);
		transactionBean.setPriceCharged(priceCharged);
		transactionBean.setChargingDate(chargingDate);
		transactionBean.setSubscriptionStatus(subscriptionStatus);
		transactionBean.setStatus(status);
		transactionBean.setRequest(request);
		transactionBean.setResponse(response);

		// //log.info("EventLogging is called 2 " + transactionBean.toString());
		if (subscriptionStatus.equals(Constants.STR_ACTION_NEW)
				&& chargingStatus.equals(Constants.STR_ACTION_ACTIVE)) {
			transactionBean.setActivationDate(CommonFunctions.getCurrentDate());
		}
		// //log.info("EventLogging is called 3 " + transactionBean.toString());
		transactionBean.setChargingStatus(chargingStatus);
		transactionBean.setReason(reason);
		transactionBean.setOperatorName(operatorName);
		transactionBean.setOperatorId(operatorId);
		transactionBean.setSmsString(sms);
		transactionBean.setSource(source);

		if (renewDate != null)
			transactionBean.setRenewDate(renewDate);
		getHibernateTemplate().saveOrUpdate(transactionBean);
	}

	@Override
	public long save(UninorDeactivationBean bean) {
		//log.info("saving UninorDeactivationBean.." + bean);
		return (Long) getHibernateTemplate().save(bean);
	}

	@Override
	public void save(VMIChargingGatewayResp bean) {
		long id = (Long) getHibernateTemplate().save(bean);
		//log.info("Saved bean with ID - " + id);
	}

	@Override
	public void save(VMIPrerenewalInfo bean) {
		long id = (Long) getHibernateTemplate().save(bean);
		//log.info("Saved bean with ID - " + id);
	}

	@Override
	public void save(RelianceSamResponse bean) {
		getHibernateTemplate().save(bean);
	}

}
