
package org.ariose.dao;

import java.util.List;

/**
 *
 * @author Sukhdeep
 */
public interface ReportsDAO {

    public List getOperatorList() throws Exception;

    public List getCircleList(int operatorId);

    public List getPackList(int circleId, int operatorId);

    public List getReportList(int operatorId, int circleId, int packId, int status, int limit);
    
    public int getLimitCount(int operatorId, int circleId, int packId, int status);

    public List getAuditLogs(String sDate, String eDate, int sIndex, String sort, String dir) throws Exception;

    public int getAuditLogCount(String sDate, String eDate) throws Exception;

    public List getSubscriptionLogs(String sDate, String eDate, int sIndex, String sort, String dir, int month, long mobile) throws Exception;

    public int getSubscriptionLogCount(String sDate, String eDate, int month, long mobile) throws Exception;

    public List getContentLogs(String sDate, String eDate, int sIndex, String sort, String dir, int month, long mobile) throws Exception;

    public int getContentLogCount(String sDate, String eDate, int month, long mobile) throws Exception;

    public List getChargingLogs(String sDate, String eDate, int sIndex, String sort, String dir, int month, long mobile) throws Exception;

    public int getChargingLogCount(String sDate, String eDate, int month, long mobile) throws Exception;

}
