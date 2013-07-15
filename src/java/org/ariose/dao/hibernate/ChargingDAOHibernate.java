/*
 * This class interats with the database through hibernate ORM layer.
 * The purpose of this class is to get, save & update the data into the
 * data base through different methods.
 */
package org.ariose.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.dao.ChargingDAO;
import org.ariose.model.ChargingGateway;
import org.ariose.model.SubscriptionBean;
import org.ariose.model.SubscriptionFailBean;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 
 * @author Manu
 */
public class ChargingDAOHibernate extends HibernateDaoSupport implements
		ChargingDAO {

	private static Log log = LogFactory.getLog(ChargingDAOHibernate.class);

	public List getChargingGateway(int operatorId) {

		String query = "from ChargingGateway cdg where cdg.operatorId="
				+ operatorId;

		List listdata = getHibernateTemplate().find(query);

		if (listdata.size() == 0) {
			log.info("no data");
		}
		for (Object objData : listdata) {
			ChargingGateway data = (ChargingGateway) objData;
			log.info("data: " + data.toString());
		}

		return listdata;
	}

	public List getPriceValueDetailsForActive(int packID) {
		List priceValue = null;
		log
				.info("getPriceValueDetailsForActive from PriceValueBean where pack_id="
						+ packID + " limit 1, 2");
		priceValue = getHibernateTemplate().find(
				"from PriceValueBean where pack_id=" + packID + "");
		log.info("priceValue ----> " + priceValue);

		return priceValue;
	}

	/*
	 * **************************************************************************
	 * **************************************** **************** The following
	 * method returns the list of available price/value pairs for a given Pack
	 * ID ********
	 * **************************************************************
	 * ****************************************************
	 */
	public List getPriceValueDetailsForRenewal(int packID) {
		List priceValue = null;

		priceValue = getHibernateTemplate().find(
				"from RenewalPriceValueBean where pack_id=" + packID
						+ " and price>0");

		return priceValue;
	}

	@Override
	public void save(SubscriptionBean subscriptionBean) {
		log.info("saving.." + subscriptionBean);
		long id = (Long) getHibernateTemplate().save(subscriptionBean);
		log.info("saved with ID - " + id);
	}

	@Override
	public void update(SubscriptionBean subscriptionBean) {
		log.info("updating.." + subscriptionBean);
		getHibernateTemplate().update(subscriptionBean);
	}

	/*
	 * **************************************************************************
	 * ************************ **************** The following method saves the
	 * failed subscription details while charging *******
	 * ***********************
	 * ***************************************************
	 * ************************
	 */
	public void saveSubscriptionFailData(int id, Long mobileNo, int packID,
			int circleId, String nextChargingDate, int status, int price,
			int validity, int lowBalanceStatus, String packName,
			int waitPeriod, int maxRetries, int grace, int lowBalanceDays,
			String validityDate, String contentDeliveryDate,
			String graceChargingTime, int operatorID, int graceContentDays,
			int pvFailRowIdx, int preRenewalDays, int channelId) {

		log.info("from SubscriptionFailBean where id=" + id + "");
		SubscriptionFailBean subscriptionFailBean = null;
		boolean isRowPresent = true;
		
		if (id > 0) {
			subscriptionFailBean = (SubscriptionFailBean) getHibernateTemplate()
					.load(SubscriptionFailBean.class, id);
		} else {
			List data = getHibernateTemplate().find(
					"from SubscriptionFailBean bean where "
							+ "bean.subscriberNumber='" + mobileNo
							+ "' and bean.subscriptionPackId='" + packID + "'");
			log.info("found list with size.."+data.size());
			if (data.size() > 0) {
				subscriptionFailBean = (SubscriptionFailBean) data.get(0);
				log.info("updating a row with id.."+subscriptionFailBean.getId());
			}
		}

		if (subscriptionFailBean == null) {
			isRowPresent = false;
			subscriptionFailBean = new SubscriptionFailBean();
		}
		
		//subscriptionFailBean.setId(id);
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

		// manup:added:12aug10:bug:next charging date was not getting set
		// properly after low balance failure
		// when tried once..twice
		// log.info(preRenewalDays);
		if (preRenewalDays != 0)
			subscriptionFailBean.setPreRenewalDays(preRenewalDays);

		// manup:19aug:SAM was sending reason code 6 to 96 users since channelId
		// was being sent as 0
		// | 6 | 96
		if (channelId != 0)
			subscriptionFailBean.setChannelId(channelId);

		if(isRowPresent){
			log.info("updating id.."+subscriptionFailBean.getId());
			getHibernateTemplate().update(subscriptionFailBean);
		} else {
			log.info("saving bean..");
			getHibernateTemplate().save(subscriptionFailBean);
		}
		
	}

	@Override
	public List getChargingGatewayParameters(int gatewayId) {
		// TODO Auto-generated method stub
		return null;
	}

}
