/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao.hibernate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.SubscriberDAO;
import org.ariose.model.ChargingGateway;
import org.ariose.model.ChargingGatewayParameter;
import org.ariose.model.CircleBean;
import org.ariose.model.ConfigurationBean;
import org.ariose.model.DeactivationGateway;
import org.ariose.model.DeactivationSummary;
import org.ariose.model.EmailUserBean;
import org.ariose.model.IdeaSubscriptionExtraParam;
import org.ariose.model.NumseriesBean;
import org.ariose.model.OnHoldBean;
import org.ariose.model.OperatorBean;
import org.ariose.model.OperatorCircleRelationshipBean;
import org.ariose.model.PriceValueBean;
import org.ariose.model.RelianceChannel;
import org.ariose.model.ReliancePackChannel;
import org.ariose.model.RenewalPriceValueBean;
import org.ariose.model.SourceChannelBean;
import org.ariose.model.SubscriberBean;
import org.ariose.model.SubscriptionBean;
import org.ariose.model.SubscriptionFailBean;
import org.ariose.model.SubscriptionPackBean;
import org.ariose.util.CommonFunctions;
import org.ariose.util.Constants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/**
 * 
 * @author Sukhdeep
 */
public class SubsciberDAOHibernate extends HibernateDaoSupport implements
		SubscriberDAO {

	private static Log log = LogFactory.getLog(SubsciberDAOHibernate.class);

	/*
	 * This method returns a complete details from Subscriber Table based on
	 * perticular Subscriber Mobile No
	 */
	public List getSubscriberDetails(long subscriberNo) {
		List subDetails = null;
		// log.info("from SubscriberBean subscriber_number=" + subscriberNo +
		// "");
		subDetails = getHibernateTemplate().find(
				"from SubscriberBean where subscriber_number=" + subscriberNo
						+ "");
		return subDetails;
	}

	/*
	 * This method returns a complete details of a perticular Pack based on its
	 * pack ID
	 */
	public List getPackDetails(int pack_id) {
		List dataList = null;
		// log.info("from SubscriptionPackBean where pack_id=" + pack_id
		// + " AND golive=" + Constants.STATUS_PACK_LIVE);
		dataList = getHibernateTemplate().find(
				"from SubscriptionPackBean where pack_id=" + pack_id
						+ " AND golive=" + Constants.STATUS_PACK_LIVE);
		return dataList;
	}

	/*
	 * This method Saves a new Subscriber.
	 */
	public void saveNewSubscriberDetails(SubscriberBean subs) {
		// log.info("data to be stored:" + subs.toString());
		getHibernateTemplate().save(subs);
	}

	public void update(SubscriberBean subs) {
		// log.info("data to be stored:" + subs.toString());
		getHibernateTemplate().update(subs);
	}

	/*
	 * This method returns a complete details of a perticular Subscription based
	 * on its pack ID and Sunscriber Mobile Number
	 */
	public List getSubscription(int pack_id, long subscriberNo) {
		// log.info("from SubscriptionBean where subscriber_number="
		// + subscriberNo + " and pack_id=" + pack_id + "");

		List list = getHibernateTemplate().find(
				"from SubscriptionBean where subscriber_number=" + subscriberNo
						+ " and pack_id=" + pack_id + "");
		log.info("Number [" + subscriberNo + "], Size [" + list.size() + "]");
		if (list.size() <= 1) {
			log.info("returning as is..");
			return list;
		}

		getHibernateTemplate().deleteAll(list.subList(1, list.size()));
		log.info("deleted 2nd and more rows..");
		return list.subList(0, 1);

	}

	/*
	 * This method Saves a new Subscription.
	 */
	public void saveNewSubscription(int tempCircle, Long tempMobileNo,
			String currentDate, int tempPackId, int tempAction,
			String advanceDate, int operatorID, int channelId,
			String activationDate) {
		SubscriptionBean subscriptionBean = new SubscriptionBean();
		subscriptionBean.setRegionId(tempCircle);
		subscriptionBean.setSubscriberNo(tempMobileNo);
		subscriptionBean.setSubscriptionCreationDate(currentDate);
		subscriptionBean.setSubscriptionPackId(tempPackId);
		subscriptionBean.setSubscriptionStatus(tempAction);
		subscriptionBean.setSubscriptionValidDate(advanceDate);
		subscriptionBean.setContentDeliveryDate(advanceDate);
		subscriptionBean.setNextchargingDate(advanceDate);
		subscriptionBean.setOperatorID(operatorID);
		subscriptionBean.setChannelId(channelId);

		if (activationDate != null) {
			subscriptionBean.setActivationDate(activationDate);
		}

		// log.info("data to be stored:" + subscriptionBean.toString());
		getHibernateTemplate().save(subscriptionBean);
	}

	/*
	 * This method Saves a new Subscription as well as updates an old
	 * Subscription.
	 */
	public void updateSubscription(SubscriptionBean sub) {
		// log.info("data to be stored:" + sub.toString());
		sub.setLogtime(CommonFunctions.getCurrentDate());
		getHibernateTemplate().update(sub);
	}

	/*
	 * This Methos is saves the subscription data when Subscription Status is on
	 * Hold So that leter on it can be used to subscribe
	 */
	public void saveOnHoldDetails(long mobileNo, int packId, int channelId,
			int action, int operatorId, int circleId, String handsetType) {
		OnHoldBean onHoldBean = new OnHoldBean();

		onHoldBean.setMobileNo(mobileNo);
		onHoldBean.setPackId(packId);
		onHoldBean.setChannelId(channelId);
		onHoldBean.setAction(action);
		onHoldBean.setOperatorId(operatorId);
		onHoldBean.setCircleId(circleId);
		onHoldBean.setHandsetType(handsetType);
		// log.info("data to be stored:" + onHoldBean.toString());
		getHibernateTemplate().save(onHoldBean);
	}

	public void saveOnHoldDetails(OnHoldBean onHoldBean) {
		// log.info("data to be stored:" + onHoldBean.toString());
		getHibernateTemplate().save(onHoldBean);
	}

	/*
	 * This Methos is retrives all the data from onHoldSubscription Table so
	 * that we can use it for subscription
	 */
	public List getOnHoldDetails() {
		return getHibernateTemplate().find("from OnHoldBean ");
	}

	public void removeOnHoldDetails(Long id) {
		// log.info("id:" + id);
		// Object OnHoldBeanObj = getHibernateTemplate().load(OnHoldBean.class,
		// id);
		Object OnHoldBeanObj = getSession().load(OnHoldBean.class, id);
		// log.info("OnHoldBeanObj:" + OnHoldBeanObj);
		// getHibernateTemplate().delete(OnHoldBeanObj);
		getSession().delete(OnHoldBeanObj);
	}

	public void removeOnHoldDetails(OnHoldBean OnHoldBeanObj) {
		// log.info("OnHoldBeanObj:" + OnHoldBeanObj);
		getHibernateTemplate().delete(OnHoldBeanObj);
	}

	public List getCircleName() {
		List circleDetails = null;
		circleDetails = getHibernateTemplate().find("from CircleBean");
		return circleDetails;
	}

	public List getOperatorName() {
		List opDetails = null;
		opDetails = getHibernateTemplate().find("from OperatorBean");
		return opDetails;
	}

	public boolean getOnHoldStatus() {
		List configDetails = null;
		boolean onholdStatus = false;
		configDetails = getHibernateTemplate().find("from ConfigurationBean");
		if (configDetails.size() > 0) {
			ConfigurationBean configBean = (ConfigurationBean) configDetails
					.get(0);
			try {
				onholdStatus = Boolean.parseBoolean(configBean.getOnHold());
			} catch (Exception e) {
				log.error("Invalid onHold status in database..taking it as false");
			}
		}

		return onholdStatus;
	}

	public void saveDeactivationSummary(int voluntaryChurn) {
		int id = 0, totalDeactivations = 0;
		String query = "from DeactivationSummary  ds where ds.currentDate='"
				+ CommonFunctions.getCurrentDateOnly() + "'";
		List misList = getHibernateTemplate().find(query);
		if (misList.size() > 0) {
			DeactivationSummary deactivationSummary = (DeactivationSummary) misList
					.get(0);
			id = deactivationSummary.getId();
			totalDeactivations = voluntaryChurn
					+ deactivationSummary.getTotalDeactivations();
			voluntaryChurn = voluntaryChurn
					+ deactivationSummary.getVoluntaryChurn();

			deactivationSummary.setId(id);
			deactivationSummary.setVoluntaryChurn(voluntaryChurn);
			deactivationSummary.setTotalDeactivations(totalDeactivations);

			getHibernateTemplate().update(deactivationSummary);

		} else {
			DeactivationSummary deactivationSummary = new DeactivationSummary();
			deactivationSummary.setId(id);
			totalDeactivations = totalDeactivations + voluntaryChurn;
			deactivationSummary.setVoluntaryChurn(voluntaryChurn);
			deactivationSummary.setLowBalanceChurn(0);
			deactivationSummary.setTotalDeactivations(totalDeactivations);
			deactivationSummary.setCurrentDate(CommonFunctions
					.getCurrentDateOnly());
			getHibernateTemplate().save(deactivationSummary);
		}
	}

	public void getUnSubscriber(long subscriberNo, int pack_id)
			throws Exception {
		// TODO:check this a lot is happening here

		// log.info("from SubscriptionFailBean where subscriber_number="
		// + subscriberNo + " and pack_id=" + pack_id + "");
		List reqList = getHibernateTemplate().find(
				"from SubscriptionFailBean where subscriber_number="
						+ subscriberNo + " and pack_id=" + pack_id + "");
		// log.info("reqList  --> " + reqList);
		if (reqList.size() > 0) {
			getHibernateTemplate().deleteAll(reqList);
			//
			// SubscriptionFailBean subscriptionFailBean =
			// (SubscriptionFailBean) reqList.get(0);
			// int id = subscriptionFailBean.getId();
			// Object userObj = getHibernateTemplate().load(
			// SubscriptionFailBean.class, id);
			// getHibernateTemplate().delete(userObj);
		}
	}

	public int getPackName(int opId, int circleId, String packName) {
		// log.info("from SubscriptionPackBean p where p.operatorId=" + opId
		// + " and p.regionId=" + circleId + " and p.planName='"
		// + packName + "'" + "and p.isGolive="
		// + Constants.STATUS_PACK_LIVE);

		// modified -- and p.isGolive=t replaced with and
		// p.isGolive="+Constants.STATUS_PACK_LIVE ---sushil
		List dataList = getHibernateTemplate().find(
				"from SubscriptionPackBean p where p.operatorId=" + opId
						+ " and p.regionId=" + circleId + " and p.planName='"
						+ packName + "'" + "and p.isGolive="
						+ Constants.STATUS_PACK_LIVE);

		if (dataList.size() > 0) {
			SubscriptionPackBean obj = (SubscriptionPackBean) dataList.get(0);
			return obj.getSubscriptionPackId();
		}
		return 0;
	}

	public void saveSubscriptionMisData(int successfulSubscriptions,
			int failureSubscriptions, int newSubscriptions) {
	}

	/*
	 * manup:27apr09:added for junit testing
	 */
	public int getSubsCount(String packTableWhereClause) {
		Query q = null;
		Session s = null;
		List data = null;
		s = getSession();

		String query = "select spb.subscriptionPackId from SubscriptionPackBean spb  "
				+ packTableWhereClause;
		Integer packId = 1;
		Integer subsCount = 0;
		try {
			// log.info("Query ......." + query);
			q = s.createQuery(query);
			data = q.list();
			if (data.size() > 0) {
				packId = (java.lang.Integer) data.get(0);
				// log.info("packId:" + packId);
			}

			query = "select count(*) from SubscriptionBean sb where pack_id="
					+ packId;
			q = s.createQuery(query);
			data = q.list();
			if (data.size() > 0) {
				subsCount = (java.lang.Integer) data.get(0);
				// log.info("subsCount:" + subsCount);
			}
		} catch (Exception e) {
			log.error("[Exception]", e.fillInStackTrace());
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return subsCount;
	}

	public List checkEmailUser(String email) {
		return getHibernateTemplate().find(
				"from EmailUserBean p where p.email='" + email + "'");
	}

	public List getOperators() throws Exception {
		return getHibernateTemplate().find("from OperatorBean");
	}

	public void saveEmailUser(EmailUserBean emailUserBean) {
		// log.error("ID to be saved is.." + emailUserBean.getId());
		if (emailUserBean.getId() == 0) {
			getHibernateTemplate().save(emailUserBean);
		} else {
			getHibernateTemplate().update(emailUserBean);
		}

		// getHibernateTemplate().merge(emailUserBean);

		if (log.isDebugEnabled()) {
			// log.debug("Id set to: " + emailUserBean.getId());
		}
	}

	public void deleteEmailUser(EmailUserBean emailUserBean) {
		Object content = getHibernateTemplate().load(EmailUserBean.class,
				emailUserBean.getId());
		getHibernateTemplate().delete(content);
		getHibernateTemplate().delete(
				"from SubscriptionBean c where c.email = '"
						+ emailUserBean.getEmail() + "'");
	}

	public void saveSubscription(SubscriptionBean subscriptionBean)
			throws Exception {
		subscriptionBean.setLogtime(CommonFunctions.getCurrentDate());
		// log.info("saving - " + subscriptionBean);
		getHibernateTemplate().saveOrUpdate(subscriptionBean);
	}

	public ChargingGateway getChargingGateway(int gatewayId) {

		String query = "from ChargingGateway cdg where cdg.gatewayId="
				+ gatewayId;

		List listdata = getHibernateTemplate().find(query);

		if (listdata.size() > 0) {
			return (ChargingGateway) listdata.get(0);
		}

		return null;
	}

	// manup:20aug:nazara reliance integration

	public ReliancePackChannel getChannel(int appid, String source) {

		List list = getHibernateTemplate().find(
				"from ReliancePackChannel where app_id='" + appid
						+ "' and source='" + source + "'");
		if (list.size() > 0) {
			return (ReliancePackChannel) list.get(0);
		}
		return null;
	}

	// manup:20aug:nazara reliance integration

	public ReliancePackChannel getDefaultChannel(int appid) {
		List list = getHibernateTemplate().find(
				"from ReliancePackChannel where app_id='" + appid
						+ "' and channel_type='0'");
		if (list.size() > 0) {
			return (ReliancePackChannel) list.get(0);
		}
		return null;
	}

	// manup:20aug:nazara reliance integration

	public SubscriptionPackBean getPackForAppId(int appid, int operatorid) {
		// log.info(appid);
		List list = getHibernateTemplate().find(
				"from SubscriptionPackBean where packInfo='" + appid
						+ "' and operatorId='" + operatorid + "'");
		if (list.size() > 0) {
			return (SubscriptionPackBean) list.get(0);
		}
		return null;
	}

	public ReliancePackChannel getChannel(int appid, int channelid) {
		List list = getHibernateTemplate().find(
				"from ReliancePackChannel where app_id='" + appid
						+ "' and channel_id='" + channelid + "'");
		if (list.size() > 0) {
			return (ReliancePackChannel) list.get(0);
		}
		return null;
	}

	public List getChargingGatewayParameters(int gatewayId) {
		List listdata = getHibernateTemplate().find(
				"from ChargingGatewayParameter gp where gp.gatewayId="
						+ gatewayId);

		if (listdata.size() == 0) {
			// log.info("no data");
		}

		for (Object objData : listdata) {
			ChargingGatewayParameter data = (ChargingGatewayParameter) objData;
			// log.info("data: " + data.toString());
		}

		return listdata;
	}

	public List<SubscriptionBean> getSubscribersPerPack(int opId, int circleId,
			int packId) {
		return getHibernateTemplate().find(
				"from SubscriptionBean p where p.operatorID=" + opId
						+ " and p.regionId=" + circleId
						+ " and p.subscriptionPackId=" + packId);
	}

	public List<SubscriptionPackBean> getAllPacks() {
		return getHibernateTemplate().find("from SubscriptionPackBean");
	}

	public List<SubscriptionBean> getSubscriptionPerSubscriber(long subsciberNo) {
		return getHibernateTemplate()
				.find("from SubscriptionBean p where p.subscriberNo = "
						+ subsciberNo);
	}

	public List<SubscriptionBean> getSubscriptionPerSubscriber(
			long subsciberNo, int operatorId) {
		return getHibernateTemplate().find(
				"from SubscriptionBean p where p.subscriberNo = " + subsciberNo
						+ " and p.operatorID='" + operatorId
						+ "' order by p.activationDate desc");
	}

	public List<SubscriptionBean> getAllSubscriptions() {
		return getHibernateTemplate().find(
				"from SubscriptionBean sb order by sb.source desc");
	}

	public void saveSubscriptionFailData(int id, Long mobileNo, int packID,
			int circleId, String nextChargingDate, int status, int price,
			int validity, int lowBalanceStatus, String packName,
			int waitPeriod, int maxRetries, int grace, int lowBalanceDays,
			String validityDate, String contentDeliveryDate,
			String graceChargingTime, int operatorID, int graceContentDays,
			int pvFailRowIdx, int preRenewalDays, int channelId)
			throws Exception {

		Session session = null;
		boolean isRecordOld = true;
		try {
			SubscriptionFailBean subscriptionFailBean = null;

			if (subscriptionFailBean == null) {
				log.warn("trying to find with no and packid");
				List list = (List) getHibernateTemplate().find(
						"from SubscriptionFailBean where subscriberNumber="
								+ mobileNo + " AND subscriptionPackId ="
								+ packID + "");
				if (list.size() > 0) {
					log.warn("record found..");
					if (list.size() > 1) {
						log.warn("more than one rows..");
						getHibernateTemplate().deleteAll(
								list.subList(1, list.size()));
					}

					subscriptionFailBean = (SubscriptionFailBean) list.get(0);
					log.warn("Loaded Otherwise -" + mobileNo + "[" + packID
							+ "]");
				}
			}

			log.warn("subscriptionFailBean - " + subscriptionFailBean);

			if (subscriptionFailBean == null) {
				isRecordOld = false;
				subscriptionFailBean = new SubscriptionFailBean();
			}

			subscriptionFailBean.setSubscriberNumber(mobileNo);
			subscriptionFailBean.setSubscriptionPackId(packID);
			subscriptionFailBean.setCircleId(circleId);
			subscriptionFailBean.setNextChargingDate(nextChargingDate);
			subscriptionFailBean.setSubscriptionStatus(status);
			subscriptionFailBean.setPrice(price);
			subscriptionFailBean.setValidity(validity);
			subscriptionFailBean.setLowBalanceStatus(lowBalanceStatus);
			subscriptionFailBean.setPackName(packName);
			subscriptionFailBean.setWaitPeriod(waitPeriod);
			subscriptionFailBean.setMaxRetries(maxRetries);
			subscriptionFailBean.setGrace(grace);
			subscriptionFailBean.setLowBalanceDays(lowBalanceDays);
			subscriptionFailBean.setValidDate(validityDate);
			subscriptionFailBean.setContentDeliveryDate(contentDeliveryDate);
			subscriptionFailBean.setGraceChargingTime(graceChargingTime);
			subscriptionFailBean.setOperator(operatorID);
			subscriptionFailBean.setGraceContentDays(graceContentDays);
			subscriptionFailBean.setPvFailRowIdx(pvFailRowIdx);

			if (preRenewalDays != 0)
				subscriptionFailBean.setPreRenewalDays(preRenewalDays);
			if (channelId != 0)
				subscriptionFailBean.setChannelId(channelId);

			log.warn("subscriptionFailBean - " + subscriptionFailBean);
			log.warn("isRecordOld - " + isRecordOld);
			if (isRecordOld) {
				getHibernateTemplate().update(subscriptionFailBean);
				log.warn("updating..id - " + subscriptionFailBean.getId()
						+ ",mobile - "
						+ subscriptionFailBean.getSubscriberNumber()
						+ ",packid - " + subscriptionFailBean.getPackName()
						+ ",status - " + status + ",nextchargingdata - "
						+ nextChargingDate);
			} else {
				getHibernateTemplate().save(subscriptionFailBean);
				log.warn("saving.."
						+ subscriptionFailBean.getSubscriberNumber()
						+ ",packid - " + subscriptionFailBean.getPackName()
						+ ",status - " + status + ",nextchargingdata - "
						+ nextChargingDate);
			}

		} catch (Exception e) {
			// log.error(e.getMessage(), e.fillInStackTrace());
			throw e;
		} finally {
			if (session != null)
				session.close();
		}

		// log.error("ended..");
	}

	public List<SubscriptionPackBean> getAllActivePacks() {
		return getHibernateTemplate().find(
				"from SubscriptionPackBean spb where spb.planStatus!=0");
	}

	/**
	 * Manu Parmar Jan 2011 For 2Ergo Idea Integration
	 */
	public List<NumseriesBean> getNumseries(String msisdnPart,
			Integer operatorId) {
		String queryString = "from NumseriesBean nb where nb.num='"
				+ msisdnPart + "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * Manu Parmar Jan 2011 For 2Ergo Idea Integration
	 */
	public List<SubscriptionPackBean> getPack(String keyword,
			Integer operatorId, int circleId) {
		String queryString = "from SubscriptionPackBean spb where spb.aliasNames like '%"
				+ keyword
				+ "%' and spb.operatorId='"
				+ operatorId
				+ "' and spb.regionId='"
				+ circleId
				+ "' and spb.isGolive='"
				+ Constants.STATUS_PACK_LIVE + "'";

		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * Manu Parmar Jan 2011 For 2Ergo Idea Integration
	 */
	public List<SourceChannelBean> getChannel(String source) {
		String queryString = "from SourceChannelBean scb where scb.source='"
				+ source + "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	/**
	 * Manu Parmar Jan 2011 For 2Ergo Idea Integration
	 */
	public Integer save(SourceChannelBean sourceChannelBean) {
		return (Integer) getHibernateTemplate().save(sourceChannelBean);
	}

	/**
	 * Manu Parmar Jan 2011 For 2Ergo Idea Integration
	 */
	public List<OperatorBean> getOperator(int operatorId) {
		String queryString = "from OperatorBean ob where ob.id='" + operatorId
				+ "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	public void save(IdeaSubscriptionExtraParam ideaSubscriptionExtraParam) {
		// log.info("called..." + ideaSubscriptionExtraParam);
		getHibernateTemplate().save(ideaSubscriptionExtraParam);
	}

	public List<SubscriptionBean> getSubscribersCount(int opId, int circleId,
			int packId, int subscriptionStatusCode) {
		String query = "Select count(*) as subsCounts from SubscriptionBean sb where sb.subscriptionPackId="
				+ packId
				+ " and DATE(sb.contentDeliveryDate) >= DATE(now()) and sb.subscriptionStatus<>"
				+ Constants.STATUS_UNSUBSCRIBE
				+ " and sb.operatorID="
				+ opId
				+ " and sb.regionId="
				+ circleId
				+ " and sb.subscriptionPackId=" + packId;
		// String query =
		// "Select count(*) as subsCounts from SubscriptionBean p where p.operatorID="
		// + opId
		// + " and p.regionId="
		// + circleId
		// + " and p.subscriptionPackId="
		// + packId
		// + " and p.subscriptionStatus=" + subscriptionStatusCode;
		// //log.info("getSubscribersCount:::" + query);
		return getHibernateTemplate().find(query);

	}

	public List<SubscriptionPackBean> getPackFromSrvkey(String svckey,
			int operatorId, int circleId) {
		String queryString = "from SubscriptionPackBean bean where bean.packDesc='"
				+ svckey
				+ "' and bean.operatorId='"
				+ operatorId
				+ "' and bean.regionId='" + circleId + "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	public List<SubscriptionPackBean> getPackFromSrvkey(String svckey,
			int operatorId) {
		String queryString = "from SubscriptionPackBean bean where bean.packDesc='"
				+ svckey + "' and bean.operatorId='" + operatorId + "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	public IdeaSubscriptionExtraParam getIdeaSubscriptionExtraParam(Long id) {
		// log.info("called..");
		return (IdeaSubscriptionExtraParam) getHibernateTemplate().get(
				IdeaSubscriptionExtraParam.class, id);
	}

	public SubscriptionBean getSubscription(Long id) {
		return (SubscriptionBean) getHibernateTemplate().get(
				SubscriptionBean.class, id);
	}

	public List<DeactivationGateway> getDeactivationGateway(int operatorIdIdea) {
		String queryString = "from DeactivationGateway bean where bean.operatorId='"
				+ operatorIdIdea + "'";
		// log.info(queryString);
		return getHibernateTemplate().find(queryString);
	}

	public void delete(List<NumseriesBean> subList) {
		getHibernateTemplate().deleteAll(subList);
	}

	public int save(CircleBean cb) {
		return (Integer) getHibernateTemplate().save(cb);
	}

	public void save(NumseriesBean nb) {
		getHibernateTemplate().save(nb);
	}

	public void save(OperatorCircleRelationshipBean ocrb) {
		getHibernateTemplate().save(ocrb);
	}

	@Override
	public Map getActivationCountPriceWise(String circle) {
		String sql = "select amount_charged,count(*) from uninor_revenue where notify_type='Subscribe' and date(logtime)=date(DATE_SUB(now(),INTERVAL 1 DAY)) and circle_name='"
				+ circle + "' group by amount_charged order by amount_charged";
		// log.info("called with query as.." + sql);

		Map keyValueMap = null;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("resultList.." + resultList);
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				keyValueMap = new LinkedHashMap();
				for (Object[] object : resultList) {
					// log.info("columns are.." + object.length);
					keyValueMap.put(String.valueOf(object[0]),
							String.valueOf(object[1]));
				}
			}

		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return keyValueMap;
	}

	@Override
	public Map getRenewalCountPriceWise(String circle) {
		String sql = "select amount_charged,count(*) from uninor_revenue where notify_type='Renew' and date(logtime)=date(DATE_SUB(now(),INTERVAL 1 DAY)) and circle_name='"
				+ circle + "' group by amount_charged order by amount_charged";
		// log.info("called with query as.." + sql);

		Map keyValueMap = null;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("resultList.." + resultList);
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				keyValueMap = new LinkedHashMap();
				for (Object[] object : resultList) {
					// log.info("columns are.." + object.length);
					keyValueMap.put(String.valueOf(object[0]),
							String.valueOf(object[1]));
				}
			}

		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return keyValueMap;
	}

	@Override
	public List<String> getCirclesForUninor() {
		// log.info("called..");
		String sql = "select distinct(bean.circleName) from UninorRevenueBean bean";
		List circleList = new ArrayList<String>();
		// //log.info("getHibernateTemplate().find(sql).."+getHibernateTemplate().find(sql));

		List resultList = getHibernateTemplate().find(sql);
		// log.info("rows found.." + resultList.size());

		for (Object object : resultList) {
			// log.info("object array.." + object);
			String circle = String.valueOf(object);
			if (circle == null || circle.trim().length() == 0) {
				continue;
			}
			circleList.add(circle);
		}
		return circleList;
	}

	// SELECT SUM(amount_charged) FROM `uninor_revenue` WHERE DATE(logtime)
	// BETWEEN '2011-10-20' AND '2011-10-30' AND notify_type='Subscribe' AND
	// circle_id='30';
	@Override
	public long getTotalUninorRevenue(String startDate, String endDate,
			String notifyType, int circleId) {
		// String sql = "SELECT SUM(amount_charged) FROM `uninor_revenue` " +
		// "WHERE DATE(logtime) BETWEEN '2011-10-20' AND '2011-10-30' " +
		// "AND notify_type='Subscribe' " +
		// "AND circle_id='30';";
		long revenue = 0;
		 String sql = "SELECT SUM(amount_charged) FROM uninor_revenue " +
		 "WHERE DATE(logtime) BETWEEN '"+startDate+"' AND '"+endDate+"' " +
		 "AND notify_type='"+notifyType+"' " +
		 "AND circle_id='"+circleId+"'";
		// String sql =
		// "SELECT SUM(amount_charged) FROM uninor_revenue WHERE DATE(logtime) BETWEEN '2011-10-20' AND '2011-10-30' AND notify_type='Subscribe' AND circle_id='30'";
		 log.info("query " + sql);
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				Object object = resultList.get(0);
				String sum = String.valueOf(object);
				log.info("sum "+sum);
				if(sum.contains(".")){
					sum = sum.substring(0,sum.length()-2);
				}
				log.info("sum "+sum);
				revenue = Long.parseLong(sum);
				log.info("revenue "+revenue);
			}
		} catch (Exception e) {
			log.error(e);
//		} finally {
//			try {
//				s.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}

		return revenue;
	}


	@Override
	public List<Object[]> getUninorRevenue(String startDate, String endDate,
			String notifyType, int circleId) {
		// String sql = "SELECT SUM(amount_charged) FROM `uninor_revenue` " +
		// "WHERE DATE(logtime) BETWEEN '2011-10-20' AND '2011-10-30' " +
		// "AND notify_type='Subscribe' " +
		// "AND circle_id='30';";
		long revenue = 0;
		 String sql = "SELECT DATE(logtime),SUM(amount_charged) FROM uninor_revenue " +
		 "WHERE DATE(logtime) BETWEEN '"+startDate+"' AND '"+endDate+"' " +
		 "AND notify_type='"+notifyType+"' " +
		 "AND circle_id='"+circleId+"' group by DATE(logtime)";
		// String sql =
		// "SELECT SUM(amount_charged) FROM uninor_revenue WHERE DATE(logtime) BETWEEN '2011-10-20' AND '2011-10-30' AND notify_type='Subscribe' AND circle_id='30'";
		 log.info("query " + sql);
		 List<Object[]> resultList = null;
		Session s = getSession();
		try {
			resultList = s.createSQLQuery(sql).list();
			log.info("rows found.." + resultList.size());
		} catch (Exception e) {
			log.error(e);
		}

		return resultList;
	}	
	
	
	@Override
	public List<Object[]> getUninorRevenue(String startDate, String endDate) {
		 String sql = "SELECT notify_type, circle_name,SUM(amount_charged) FROM uninor_revenue " +
		 "WHERE DATE(logtime) BETWEEN '"+startDate+"' AND '"+endDate+"' " +
		 "GROUP BY notify_type, circle_name";
		 log.info("query " + sql);
		Session s = getSession();
		List<Object[]> resultList = null;
		try {
			resultList = s.createSQLQuery(sql).list();
			log.info("rows found.." + resultList.size());			
		} catch (Exception e) {
			log.error(e);
//		} finally {
//			try {
//				s.close();
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
		}

		return resultList;
	}
	
	@Override
	public int getTotalActiveSubscribers(int operatorId) {
		// log.info("called..");
		int count = 0;
		String sql = "select count(*) from subscription where subscription_status in ("
				+ Constants.STATUS_ACTIVE
				+ ","
				+ Constants.STATUS_RENEWAL
				+ ") and operator_id=" + operatorId;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				Object object = resultList.get(0);
				count = Integer.parseInt(String.valueOf(object));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return count;
	}

	@Override
	public int getTotalActiveSubscribers(int operatorId, String circle) {
		// log.info("called..");
		int count = 0;
		String sql = "select count(*) from subscription where subscription_status in ("
				+ Constants.STATUS_ACTIVE
				+ ","
				+ Constants.STATUS_RENEWAL
				+ ") and operator_id="
				+ operatorId
				+ " and circle_name='"
				+ circle + "'";
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				Object object = resultList.get(0);
				count = Integer.parseInt(String.valueOf(object));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return count;
	}

	@Override
	public Map getActivationCountChannelTypeWise(String circle) {
		String sql = "select channel_type,count(*) from uninor_revenue where notify_type='Subscribe' and date(logtime)=date(DATE_SUB(now(),INTERVAL 1 DAY)) and circle_name='"
				+ circle + "' group by channel_type order by channel_type";
		// log.info("called with query as.." + sql);

		Map keyValueMap = null;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("resultList.." + resultList);
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				keyValueMap = new LinkedHashMap();
				for (Object[] object : resultList) {
					// log.info("columns are.." + object.length);
					keyValueMap.put(String.valueOf(object[0]),
							String.valueOf(object[1]));
				}
			}

		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return keyValueMap;
	}

	@Override
	public Map getDeactivationsCountChannelTypeWise(String circle) {
		String sql = "select channel_type,count(*) from uninor_deactivation where date(logtime)=date(DATE_SUB(now(),INTERVAL 1 DAY)) and circle_name='"
				+ circle + "' group by channel_type order by channel_type";
		// log.info("called with query as.." + sql);

		Map keyValueMap = null;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("resultList.." + resultList);
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				keyValueMap = new LinkedHashMap();
				for (Object[] object : resultList) {
					// log.info("columns are.." + object.length);
					keyValueMap.put(String.valueOf(object[0]),
							String.valueOf(object[1]));
				}
			}

		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return keyValueMap;
	}

	@Override
	public Map getDeactivationsCountChrunWise(String circle) {
		String sql = "select reason,count(*) from uninor_deactivation where date(logtime)=date(DATE_SUB(now(),INTERVAL 1 DAY)) and circle_name='"
				+ circle + "' group by reason order by reason";
		// log.info("called with query as.." + sql);

		Map keyValueMap = null;
		Session s = getSession();
		try {
			List<Object[]> resultList = s.createSQLQuery(sql).list();
			// log.info("resultList.." + resultList);
			// log.info("rows found.." + resultList.size());
			if (resultList.size() > 0) {
				keyValueMap = new LinkedHashMap();
				for (Object[] object : resultList) {
					// log.info("columns are.." + object.length);
					keyValueMap.put(String.valueOf(object[0]),
							String.valueOf(object[1]));
				}
			}

		} catch (Exception e) {
			log.error(e);
		} finally {
			try {
				s.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return keyValueMap;
	}

	@Override
	public List<PriceValueBean> getPriceValueBean(int subscriptionPackId,
			String minutes) {
		String query = "from PriceValueBean a where a.packID='"
				+ subscriptionPackId + "' and a.minutes='" + minutes + "'";
		return getHibernateTemplate().find(query);
	}

	@Override
	public List<RenewalPriceValueBean> getRenewalPriceValueBean(
			int subscriptionPackId, String minutes) {
		String query = "from RenewalPriceValueBean a where a.packID='"
				+ subscriptionPackId + "' and a.minutes='" + minutes + "'";
		return getHibernateTemplate().find(query);
	}

	@Override
	public List<RelianceChannel>  getChannel(int channelid) {
		log.info("channelid - "+channelid);
		String queryString = "from RelianceChannel a where a.channel_id='"
				+ channelid + "'";
		log.info("queryString - "+queryString);
		List<RelianceChannel> out = getHibernateTemplate().find(queryString);
		log.info("rows found.."+out.size());
		
		return out;
				
	}

	@Override
	public ChargingGateway getChargingGatewayForOperator(int operatorId) {
		String query = "from ChargingGateway cdg where cdg.operatorId="
				+ operatorId;
	
		List listdata = getHibernateTemplate().find(query);
	
		if (listdata.size() > 0) {
			return (ChargingGateway) listdata.get(0);
		}
	
		return null;
	}

}
