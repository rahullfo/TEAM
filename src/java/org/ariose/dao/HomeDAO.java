/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;

/**
 *
 * @author Sukhdeep
 */
public interface HomeDAO {

    public List getChargingMisData();

    public List getSubscriptionMisData();

    public List getContentDeliveryMisData();

    public List getContentQueueSummary();

    public List getRegistrationSummary();

    public List getRenewalSummary();

    public List getDeactivationSummary();

    public List getDailyContentDelivered(String domainObjectName) throws Exception;
    
    public List getWeeklyContentDelivered(String domainObjectName,String startDate,String endDate) throws Exception;
    public List getDailyTotalCharging() throws Exception;
}
