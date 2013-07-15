/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

import java.util.Date;

/**
 *
 * @author Sushil Kumar
 */
public class ContentDeliveryRealTimeDashboard extends BaseObject{

    private long id;
    private int operatorId;
    private String  operatorName;
    private int circleId;
    private String circleName;
    private int serviceId; //serviceId --> packId
    private String serviceName; //serviceName --> packNam
    private String scheduleTime;
    private long cmsId;
    private Date updateTime;
    private String delivered;
    private int noofsubscribers;
    private int retry;
    private  Date firstPush;
    private  Date lastPush;
    private String remarks;
    private int startFlag;
    private int pushed;
    private String logtime;
    private int contentSchedulerId;
    private int contentId;

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public long getCmsId() {
        return cmsId;
    }

    public void setCmsId(long cmsId) {
        this.cmsId = cmsId;
    }

    public String getDelivered() {
        return delivered;
    }

    public void setDelivered(String delivered) {
        this.delivered = delivered;
    }

    public Date getFirstPush() {
        return firstPush;
    }

    public void setFirstPush(Date firstPush) {
        this.firstPush = firstPush;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getLastPush() {
        return lastPush;
    }

    public void setLastPush(Date lastPush) {
        this.lastPush = lastPush;
    }

    public int getNoofsubscribers() {
        return noofsubscribers;
    }

    public void setNoofsubscribers(int noofsubscribers) {
        this.noofsubscribers = noofsubscribers;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getPushed() {
        return pushed;
    }

    public void setPushed(int pushed) {
        this.pushed = pushed;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }
  
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(int startFlag) {
        this.startFlag = startFlag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getContentSchedulerId() {
        return contentSchedulerId;
    }

    public void setContentSchedulerId(int contentSchedulerId) {
        this.contentSchedulerId = contentSchedulerId;
    }

    public String getLogtime() {
        return logtime;
    }

    public void setLogtime(String logtime) {
        this.logtime = logtime;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

}
