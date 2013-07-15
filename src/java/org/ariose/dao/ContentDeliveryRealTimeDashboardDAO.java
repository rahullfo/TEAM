
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;
import org.ariose.model.ContentDeliveryRealTimeDashboard;

/**
 *
 * @author Sushil
 */
public interface ContentDeliveryRealTimeDashboardDAO extends DAO {

    public void saveRealTimeDashboard(ContentDeliveryRealTimeDashboard obj);

    public void updateRealTimeDashboard(ContentDeliveryRealTimeDashboard obj);

    public List getCurrentDateRealTimeDashboard();

    public List getCurrentDateRealTimeDashboardForUpdate();

    public void updateContentScheduler(String contentSchedulerId,int param);

     public void updateRealTimeDashboard(int id,int param);


}
