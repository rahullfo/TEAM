/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

import java.util.Date;

/**
 *
 * @author shweta
 */
public class CirclePackRevenue {

    private int id;
    private String circleName;
    private String service;
    private int subType;
    private int priceChanged;
    private Date hitDate;
    private String source;
    private String platform;
    private long subscriberNumber;
    private int packID;
    private String subscriptionStatus;
    private String packName;

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
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the subType
     */
    public int getSubType() {
        return subType;
    }

    /**
     * @param subType the subType to set
     */
    public void setSubType(int subType) {
        this.subType = subType;
    }

    /**
     * @return the priceChanged
     */
    public int getPriceChanged() {
        return priceChanged;
    }

    /**
     * @param priceChanged the priceChanged to set
     */
    public void setPriceChanged(int priceChanged) {
        this.priceChanged = priceChanged;
    }

    /**
     * @return the hitDate
     */
    public Date getHitDate() {
        return hitDate;
    }

    /**
     * @param hitDate the hitDate to set
     */
    public void setHitDate(Date hitDate) {
        this.hitDate = hitDate;
    }

    /**
     * @return the source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * @param platform the platform to set
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * @return the subscriberNumber
     */
    public long getSubscriberNumber() {
        return subscriberNumber;
    }

    /**
     * @param subscriberNumber the subscriberNumber to set
     */
    public void setSubscriberNumber(long subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
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
     * @return the subscriptionStatus
     */
    public String getSubscriptionStatus() {
        return subscriptionStatus;
    }

    /**
     * @param subscriptionStatus the subscriptionStatus to set
     */
    public void setSubscriptionStatus(String subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
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
    


}
