/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class SubscriptionFailedData extends BaseObject{
    private String mobileNo;
    private String packId;
    private String channel;
    private String circleId;
    private String action;
    private String operatorId;
    private String handsetType;
    private String mess;

    /**
     * @return the mobileNo
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the packId
     */
    public String getPackId() {
        return packId;
    }

    /**
     * @param packId the packId to set
     */
    public void setPackId(String packId) {
        this.packId = packId;
    }

    /**
     * @return the channel
     */
    public String getChannel() {
        return channel;
    }

    /**
     * @param channel the channel to set
     */
    public void setChannel(String channel) {
        this.channel = channel;
    }

    /**
     * @return the circleId
     */
    public String getCircleId() {
        return circleId;
    }

    /**
     * @param circleId the circleId to set
     */
    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the operatorId
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the handsetType
     */
    public String getHandsetType() {
        return handsetType;
    }

    /**
     * @param handsetType the handsetType to set
     */
    public void setHandsetType(String handsetType) {
        this.handsetType = handsetType;
    }

    /**
     * @return the mess
     */
    public String getMess() {
        return mess;
    }

    /**
     * @param mess the mess to set
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    

}
