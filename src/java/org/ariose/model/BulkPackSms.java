/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.model;

import java.util.Date;

/**
 *
 * @author Sushil
 */
public class BulkPackSms extends BaseObject {

    private int id;
    private int operatorId;
    private int circleId;
    private int packId;
    private String sendingMode;
    private Date startDateTime;
    private Date endDateTime;
    private String message;
    private String alertName;
    private int sendingStatus;
    private String userId;
    private int stopFlag;

    public int getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(int stopFlag) {
        this.stopFlag = stopFlag;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public String getAlertName() {
        return alertName;
    }

    public void setAlertName(String alertName) {
        this.alertName = alertName;
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public String getSendingMode() {
        return sendingMode;
    }

    public void setSendingMode(String sendingMode) {
        this.sendingMode = sendingMode;
    }

    public int getSendingStatus() {
        return sendingStatus;
    }

    public void setSendingStatus(int sendingStatus) {
        this.sendingStatus = sendingStatus;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
   
}
