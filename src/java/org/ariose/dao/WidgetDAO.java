/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.dao;

import java.util.List;
import org.ariose.model.OperatorCircleRelationshipBean;
import org.ariose.model.CirclePackRevenue;

/**
 *
 * @author shweta
 */
public interface WidgetDAO {

    public List<Object[]> getTopFiveCircle() throws Exception;
    public OperatorCircleRelationshipBean getOperatorName(int optId) throws Exception;
    public List<Object[]> getTopFivePack() throws Exception;

    public List getNewSubscRevenue() throws Exception;

    public List getRenewSubscRevenue() throws Exception;

    public List getTotalNewSubscribers() throws Exception;

     public List getNewSubscRevenueMonthly() throws Exception;

    public List getRenewSubscRevenueMonthly() throws Exception;


 public List getTotalNewSubscribersMonthly() throws Exception;

  public List getNewSubscRevenueWeekly() throws Exception;

  public List getRenewSubscRevenueWeekly() throws Exception;

    public List getTotalNewSubscribersWeekly() throws Exception;





}
