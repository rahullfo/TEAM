/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class Pack extends BaseObject{

    private int id;
    private int subscriptionPackId;
    private int contentContentId;
    private int customerOwnerId;
    private int deliveryMechanismDmId;
    private int deliveryFreqId;
    private String planName;
    private String lastUpdateDate;
    private String planStatus;
    private int packType;
    private int userInfoUserId;
    private int regionId;
    private int tryandbuyPrice;
    private int tryandbuyValidity;
    private int lowBalanceStatus;
    private String packDesc;
    private String packInfo;
    private int waitPeriod;
    private int maxRetries;
    private int grace;
    private String smsActivaion;
    private String smsDeactivaion;
    private boolean isADMassage;
    private String smsExpiry;
    private boolean isExpiryMessage;
    private int numberBeforeExpiryMessage;
    private String smsGrace;
    private boolean isAutoRenewal;
   private String senderId;
  //private String aliasNames;
 
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
     * @return the subscriptionPackId
     */
    public int getSubscriptionPackId() {
        return subscriptionPackId;
    }

    /**
     * @param subscriptionPackId the subscriptionPackId to set
     */
    public void setSubscriptionPackId(int subscriptionPackId) {
        this.subscriptionPackId = subscriptionPackId;
    }

    /**
     * @return the contentContentId
     */
    public int getContentContentId() {
        return contentContentId;
    }

    /**
     * @param contentContentId the contentContentId to set
     */
    public void setContentContentId(int contentContentId) {
        this.contentContentId = contentContentId;
    }

    /**
     * @return the customerOwnerId
     */
    public int getCustomerOwnerId() {
        return customerOwnerId;
    }

    /**
     * @param customerOwnerId the customerOwnerId to set
     */
    public void setCustomerOwnerId(int customerOwnerId) {
        this.customerOwnerId = customerOwnerId;
    }

    /**
     * @return the deliveryMechanismDmId
     */
    public int getDeliveryMechanismDmId() {
        return deliveryMechanismDmId;
    }

    /**
     * @param deliveryMechanismDmId the deliveryMechanismDmId to set
     */
    public void setDeliveryMechanismDmId(int deliveryMechanismDmId) {
        this.deliveryMechanismDmId = deliveryMechanismDmId;
    }

    /**
     * @return the deliveryFreqId
     */
    public int getDeliveryFreqId() {
        return deliveryFreqId;
    }

    /**
     * @param deliveryFreqId the deliveryFreqId to set
     */
    public void setDeliveryFreqId(int deliveryFreqId) {
        this.deliveryFreqId = deliveryFreqId;
    }

    /**
     * @return the planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * @return the lastUpdateDate
     */
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * @return the planStatus
     */
    public String getPlanStatus() {
        return planStatus;
    }

    /**
     * @param planStatus the planStatus to set
     */
    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    /**
     * @return the packType
     */
    public int getPackType() {
        return packType;
    }

    /**
     * @param packType the packType to set
     */
    public void setPackType(int packType) {
        this.packType = packType;
    }

    /**
     * @return the userInfoUserId
     */
    public int getUserInfoUserId() {
        return userInfoUserId;
    }

    /**
     * @param userInfoUserId the userInfoUserId to set
     */
    public void setUserInfoUserId(int userInfoUserId) {
        this.userInfoUserId = userInfoUserId;
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
     * @return the tryandbuyPrice
     */
    public int getTryandbuyPrice() {
        return tryandbuyPrice;
    }

    /**
     * @param tryandbuyPrice the tryandbuyPrice to set
     */
    public void setTryandbuyPrice(int tryandbuyPrice) {
        this.tryandbuyPrice = tryandbuyPrice;
    }

    /**
     * @return the tryandbuyValidity
     */
    public int getTryandbuyValidity() {
        return tryandbuyValidity;
    }

    /**
     * @param tryandbuyValidity the tryandbuyValidity to set
     */
    public void setTryandbuyValidity(int tryandbuyValidity) {
        this.tryandbuyValidity = tryandbuyValidity;
    }

    /**
     * @return the lowBalanceStatus
     */
    public int getLowBalanceStatus() {
        return lowBalanceStatus;
    }

    /**
     * @param lowBalanceStatus the lowBalanceStatus to set
     */
    public void setLowBalanceStatus(int lowBalanceStatus) {
        this.lowBalanceStatus = lowBalanceStatus;
    }

    /**
     * @return the packDesc
     */
    public String getPackDesc() {
        return packDesc;
    }

    /**
     * @param packDesc the packDesc to set
     */
    public void setPackDesc(String packDesc) {
        this.packDesc = packDesc;
    }

    /**
     * @return the packInfo
     */
    public String getPackInfo() {
        return packInfo;
    }

    /**
     * @param packInfo the packInfo to set
     */
    public void setPackInfo(String packInfo) {
        this.packInfo = packInfo;
    }

    /**
     * @return the waitPeriod
     */
    public int getWaitPeriod() {
        return waitPeriod;
    }

    /**
     * @param waitPeriod the waitPeriod to set
     */
    public void setWaitPeriod(int waitPeriod) {
        this.waitPeriod = waitPeriod;
    }

    /**
     * @return the maxRetries
     */
    public int getMaxRetries() {
        return maxRetries;
    }

    /**
     * @param maxRetries the maxRetries to set
     */
    public void setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    /**
     * @return the grace
     */
    public int getGrace() {
        return grace;
    }

    /**
     * @param grace the grace to set
     */
    public void setGrace(int grace) {
        this.grace = grace;
    }

    /**
     * @return the smsActivaion
     */
    public String getSmsActivaion() {
        return smsActivaion;
    }

    /**
     * @param smsActivaion the smsActivaion to set
     */
    public void setSmsActivaion(String smsActivaion) {
        this.smsActivaion = smsActivaion;
    }

    /**
     * @return the smsDeactivaion
     */
    public String getSmsDeactivaion() {
        return smsDeactivaion;
    }

    /**
     * @param smsDeactivaion the smsDeactivaion to set
     */
    public void setSmsDeactivaion(String smsDeactivaion) {
        this.smsDeactivaion = smsDeactivaion;
    }

    /**
     * @return the isADMassage
     */
    public boolean isIsADMassage() {
        return isADMassage;
    }

    /**
     * @param isADMassage the isADMassage to set
     */
    public void setIsADMassage(boolean isADMassage) {
        this.isADMassage = isADMassage;
    }

    /**
     * @return the smsExpiry
     */
    public String getSmsExpiry() {
        return smsExpiry;
    }

    /**
     * @param smsExpiry the smsExpiry to set
     */
    public void setSmsExpiry(String smsExpiry) {
        this.smsExpiry = smsExpiry;
    }

    /**
     * @return the isExpiryMessage
     */
    public boolean isIsExpiryMessage() {
        return isExpiryMessage;
    }

    /**
     * @param isExpiryMessage the isExpiryMessage to set
     */
    public void setIsExpiryMessage(boolean isExpiryMessage) {
        this.isExpiryMessage = isExpiryMessage;
    }

    /**
     * @return the numberBeforeExpiryMessage
     */
    public int getNumberBeforeExpiryMessage() {
        return numberBeforeExpiryMessage;
    }

    /**
     * @param numberBeforeExpiryMessage the numberBeforeExpiryMessage to set
     */
    public void setNumberBeforeExpiryMessage(int numberBeforeExpiryMessage) {
        this.numberBeforeExpiryMessage = numberBeforeExpiryMessage;
    }

    /**
     * @return the smsGrace
     */
    public String getSmsGrace() {
        return smsGrace;
    }

    /**
     * @param smsGrace the smsGrace to set
     */
    public void setSmsGrace(String smsGrace) {
        this.smsGrace = smsGrace;
    }

    /**
     * @return the isAutoRenewal
     */
    public boolean isIsAutoRenewal() {
        return isAutoRenewal;
    }

    /**
     * @param isAutoRenewal the isAutoRenewal to set
     */
    public void setIsAutoRenewal(boolean isAutoRenewal) {
        this.isAutoRenewal = isAutoRenewal;
    }

    /**
     * @return the senderId
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

//    /**
//     * @return the aliasNames
//     */
//    public String getAliasNames() {
//        return aliasNames;
//    }
//
//    /**
//     * @param aliasNames the aliasNames to set
//     */
//    public void setAliasNames(String aliasNames) {
//        this.aliasNames = aliasNames;
//    }
//
//
//
//
//
}
