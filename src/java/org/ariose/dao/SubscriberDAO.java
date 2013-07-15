/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;
import java.util.Map;

import org.ariose.model.ChargingGateway;
import org.ariose.model.CircleBean;
import org.ariose.model.DeactivationGateway;
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
import org.ariose.model.SubscriptionPackBean;

/**
 * 
 * @author Sukhdeep
 */
public interface SubscriberDAO extends DAO {

	public List getSubscriberDetails(long subscriberId);

	public List getPackDetails(int pack_id);

	public void saveNewSubscriberDetails(SubscriberBean sub) throws Exception;

	// public int getSubsciptionStatus(int pack_id, int Subscriber_id);

	public List getSubscription(int pack_id, long Subscriber_id);

	public void saveNewSubscription(int tempCircle, Long tempMobileNo,
			String currentDate, int tempPackId, int tempAction,
			String advanceDate, int operatorID, int channelId,
			String activationDate) throws Exception;

	public void updateSubscription(SubscriptionBean sub);

	public void saveOnHoldDetails(OnHoldBean onHoldBean);

	public void saveOnHoldDetails(long mobileNo, int packId, int channelId,
			int action, int operatorId, int circleId, String handsetType);

	public List getOnHoldDetails();

	public void removeOnHoldDetails(Long id);

	public void removeOnHoldDetails(OnHoldBean OnHoldBeanObj);

	// public String getOperatorName(String operator_id);
	// public String getCircleName(String circle_id);

	public List getCircleName();

	public List getOperatorName();

	public boolean getOnHoldStatus();

	public void saveSubscriptionMisData(int successfulSubscriptions,
			int failureSubscriptions, int newSubscriptions);

	public void saveDeactivationSummary(int voluntaryChurn);

	public void getUnSubscriber(long subscriberNo, int pack_id)
			throws Exception;

	public int getPackName(int opId, int circleId, String packName);

	/*
	 * manup:27apr09:added for junit testing
	 */

	public int getSubsCount(String packTableWhereClause);

	public List checkEmailUser(String email) throws Exception;

	public List getOperators() throws Exception;

	public void saveEmailUser(EmailUserBean emailUserBean) throws Exception;

	public void deleteEmailUser(EmailUserBean emailUserBean) throws Exception;

	public void saveSubscription(SubscriptionBean subscriptionBean)
			throws Exception;

	public ChargingGateway getChargingGateway(int gatewayId);

	public ChargingGateway getChargingGatewayForOperator(int operatorId);

	public SubscriptionPackBean getPackForAppId(int appid, int operatorid);

	public ReliancePackChannel getChannel(int appid, String source);

	public ReliancePackChannel getDefaultChannel(int appidInt);

	public ReliancePackChannel getChannel(int appid, int channelid);

	public List getChargingGatewayParameters(int gatewayId);

	public void update(SubscriberBean subs);

	public List<SubscriptionBean> getSubscribersPerPack(int opId, int circleId,
			int packId);

	// get all packs
	public List<SubscriptionPackBean> getAllPacks();

	public List<SubscriptionBean> getSubscriptionPerSubscriber(long subsciberNo);

	public List<SubscriptionBean> getSubscriptionPerSubscriber(
			long subsciberNo, int operatorId);

	public List<SubscriptionBean> getAllSubscriptions();

	public List<SubscriptionPackBean> getAllActivePacks();

	public void saveSubscriptionFailData(int id, Long mobileNo, int packID,
			int circleId, String nextChargingDate, int status, int price,
			int validity, int lowBalanceStatus, String packName,
			int waitPeriod, int maxRetries, int grace, int lowBalanceDays,
			String validityDate, String contentDeliveryDate,
			String graceChargingTime, int operatorID, int graceContentDays,
			int pvFailRowIdx, int preRenewalDays, int channelId)
			throws Exception;

	public List<NumseriesBean> getNumseries(String msisdnPart,
			Integer operatorId);

	public List<SubscriptionPackBean> getPack(String keyword,
			Integer operatorId, int circleId);

	public List<SourceChannelBean> getChannel(String source);

	public Integer save(SourceChannelBean sourceChannelBean);

	public List<OperatorBean> getOperator(int operatorId);

	public void save(IdeaSubscriptionExtraParam ideaSubscriptionExtraParam);

	public List<SubscriptionBean> getSubscribersCount(int opId, int circleId,
			int packId, int subscriptionStatusCode);

	public List<SubscriptionPackBean> getPackFromSrvkey(String svckey,
			int operatorId, int regionId);

	public List<SubscriptionPackBean> getPackFromSrvkey(String svckey,
			int operatorId);

	public IdeaSubscriptionExtraParam getIdeaSubscriptionExtraParam(Long id);

	public SubscriptionBean getSubscription(Long id);

	public List<DeactivationGateway> getDeactivationGateway(int operatorIdIdea);

	public int save(CircleBean cb);

	public void delete(List<NumseriesBean> subList);

	public void save(NumseriesBean nb);

	public void save(OperatorCircleRelationshipBean ocrb);

	// UNINOR MIS APIS
	public List<String> getCirclesForUninor();

	public Map getActivationCountPriceWise(String circle);

	public Map getRenewalCountPriceWise(String circle);

	public Map getActivationCountChannelTypeWise(String circle);

	public Map getDeactivationsCountChannelTypeWise(String circle);

	public Map getDeactivationsCountChrunWise(String circle);

	public int getTotalActiveSubscribers(int operatorId);

	public int getTotalActiveSubscribers(int operatorId, String circle);

	public List<PriceValueBean> getPriceValueBean(int subscriptionPackId,
			String minutes);

	public List<RenewalPriceValueBean> getRenewalPriceValueBean(
			int subscriptionPackId, String minutes);

	public long getTotalUninorRevenue(String startDate, String endDate,
			String notifyType, int circleId);

	public List<Object[]> getUninorRevenue(String startDate, String endDate);

	public List<Object[]> getUninorRevenue(String startDate, String endDate,
			String notifyType, int circleId);

	public List<RelianceChannel> getChannel(int channelid);
}
