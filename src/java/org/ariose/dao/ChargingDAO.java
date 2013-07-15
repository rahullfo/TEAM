/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;

import org.ariose.model.SubscriptionBean;



/**
 *
 * @author Manu
 */
public interface ChargingDAO extends DAO {
    public List getPriceValueDetailsForActive(int packID);
    public List getPriceValueDetailsForRenewal(int packID);
	public void save(SubscriptionBean subscriptionBean);
	public void update(SubscriptionBean subscriptionBean);
    public void saveSubscriptionFailData(int id, Long mobileNo, int packID,
            int circleId, String nextChargingDate, int status, int price,
            int validity, int lowBalanceStatus, String packName, int waitPeriod, int maxRetries,
            int grace, int lowBalanceDays, String validityDate,String contentDeliveryDate,
            String graceChargingTime, int operatorID, int graceContentDays, int pvFailRowIdx, int preRenewalDays, int channelId);
	public List getChargingGatewayParameters(int gatewayId);
	public List getChargingGateway(int operatorId);


}
