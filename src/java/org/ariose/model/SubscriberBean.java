/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class SubscriberBean extends BaseObject  {
    private Long id;
    private int regionId;
    private int operatorTableOperatorId;
    private Long subscriberNo;
    private String handsetType;
    private String mess;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the regionId
     */
    public int getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the operatorTableOperatorId
     */
    public int getOperatorTableOperatorId() {
        return operatorTableOperatorId;
    }

    /**
     * @param operatorTableOperatorId the operatorTableOperatorId to set
     */
    public void setOperatorTableOperatorId(int operatorTableOperatorId) {
        this.operatorTableOperatorId = operatorTableOperatorId;
    }

    /**
     * @return the subscriberNo
     */
    public Long getSubscriberNo() {
        return subscriberNo;
    }

    /**
     * @param subscriberNo the subscriberNo to set
     */
    public void setSubscriberNo(Long subscriberNo) {
        this.subscriberNo = subscriberNo;
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
