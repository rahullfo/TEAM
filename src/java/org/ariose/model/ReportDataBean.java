/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class ReportDataBean extends BaseObject {

    private int id;
    private int operatorID;
    private String operatorName;
    private int circleID;
    private String circleName;
    private int packID;
    private String packName;
    private Long mobileNo;
    private int subscriberStatus;

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

    /**
     * @return the operatorID
     */
    public int getOperatorID() {
        return operatorID;
    }

    /**
     * @param operatorID the operatorID to set
     */
    public void setOperatorID(int operatorID) {
        this.operatorID = operatorID;
    }

    /**
     * @return the operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName the operatorName to set
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return the circleID
     */
    public int getCircleID() {
        return circleID;
    }

    /**
     * @param circleID the circleID to set
     */
    public void setCircleID(int circleID) {
        this.circleID = circleID;
    }

    /**
     * @return the circleName
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * @param circleName the circleName to set
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * @return the packID
     */
    public int getPackID() {
        return packID;
    }

    /**
     * @param packID the packID to set
     */
    public void setPackID(int packID) {
        this.packID = packID;
    }

    /**
     * @return the packName
     */
    public String getPackName() {
        return packName;
    }

    /**
     * @param packName the packName to set
     */
    public void setPackName(String packName) {
        this.packName = packName;
    }

    /**
     * @return the mobileNo
     */
    public Long getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * @return the subscriberStatus
     */
    public int getSubscriberStatus() {
        return subscriberStatus;
    }

    /**
     * @param subscriberStatus the subscriberStatus to set
     */
    public void setSubscriberStatus(int subscriberStatus) {
        this.subscriberStatus = subscriberStatus;
    }


}
