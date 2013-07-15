/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;
import org.ariose.model.CirclesRevenueSummary;
import org.ariose.model.DailySummary;
import org.ariose.model.MonthlySummary;
import org.ariose.model.PacksRevenueSummary;
import org.ariose.model.WeeklySummary;

/**
 *
 * @author Sushil
 */
public interface DashboardDAO {

    public List<DailySummary> getDailySummary(int operatorId,String curDate) throws Exception;

    //public List<WeeklySummary> getWeeklySummary(int operatorId) throws Exception;
    List getWeeklySummary(int operatorId, String startDate, String endDate) throws Exception;

    //public List<MonthlySummary> getMonthlySummary(int operatorId) throws Exception;
    public List getMonthlySummary(int operatorId, String startDate, String endDate) throws Exception;
    //public List getWeeklyContentDelivered(String domainObjectName,String startDate,String endDate) throws Exception;

    public List getTopFivePacks(int optrId) throws Exception;

    public List getTopFiveCircles(int optrId) throws Exception;

    public List<PacksRevenueSummary> getPacksRevenueSummary(int optrId) throws Exception;

    public List<CirclesRevenueSummary> getCirclesRevenueSummary(int optrId) throws Exception;
    //public List getDailyTotalCharging() throws Exception;
}
