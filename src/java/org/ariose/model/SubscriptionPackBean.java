/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

import java.util.Date;

/**
 *
 * @author Sukhdeep
 */
public class SubscriptionPackBean extends BaseObject{
    private int id;
    private int subscriptionPackId;
    private String planName;
    private String lastUpdateDate;    
    private boolean planStatus;
    private boolean packType;
    private String basePackName;
    private int basePackId;
    private int userInfoUserId;
    private int regionId;
    private int tryandbuyPrice;
    private int tryandbuyValidity;
    private int lowBalanceStatus;
    private String packDesc;
    private String packInfo;
    private int waitPeriod;
    private int maxRetries;
    private String smsActivaion;
    private String smsDeactivaion;
    private boolean isADMassage;
    private String smsExpiry;
    private boolean isExpiryMessage;
    private int numberBeforeExpiryMessage;
    private String smsGrace;
    private boolean isAutoRenewal;
    private String adminSenderId;
    private String contentSenderId; //shortcode
    private boolean isGolive;
    private int lowBalanceDays;
    private int operatorId;
    private int preRenewalDays;
    private String gatewayName;
    private int gatewayId;
    private String smsFreshLowBalance;
    private boolean freshLowBalance;
    private String smsRenewalLowBalance;
    private boolean renewalLowBalance;
    private int pricing;
   private String footerMessage;
    private boolean sentFooter;
    private String aliasNames;
   
    /* Shweta: added startDate and endDate feilds */

    private Date startDate;
    private Date endDate;
	/*
	 * manu parmar: jan 2011: idea 2 ergo integration
	 * we take alias value in this format
	 * keyword,activation-ussd-string,deactivation-ussd-string
	 * we get it and then set it accordingly 
	 */
    private String actUssdString = null;
    private String dctUssdString = null;
    

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
     * @return the waitPeriod
     */
    public int getWaitPeriod() {
        return waitPeriod;
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
     * @return the operatorId
     */
    public int getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId the operatorId to set
     */
    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the preRenewalDays
     */
    public int getPreRenewalDays() {
        return preRenewalDays;
    }

    /**
     * @param preRenewalDays the preRenewalDays to set
     */
    public void setPreRenewalDays(int preRenewalDays) {
        this.preRenewalDays = preRenewalDays;
    }

    /**
     * @return the adminSenderId
     */
    public String getAdminSenderId() {
        return adminSenderId;
    }

    /**
     * @param adminSenderId the adminSenderId to set
     */
    public void setAdminSenderId(String adminSenderId) {
        this.adminSenderId = adminSenderId;
    }

    /**
     * @return the contentSenderId
     */
    public String getContentSenderId() {
        return contentSenderId;
    }

    /**
     * @param contentSenderId the contentSenderId to set
     */
    public void setContentSenderId(String contentSenderId) {
        this.contentSenderId = contentSenderId;
    }

    /**
     * @return the isGolive
     */
    public boolean isIsGolive() {
        return isGolive;
    }

    /**
     * @param isGolive the isGolive to set
     */
    public void setIsGolive(boolean isGolive) {
        this.isGolive = isGolive;
    }

    /**
     * @return the planStatus
     */
    public boolean isPlanStatus() {
        return planStatus;
    }

    /**
     * @param planStatus the planStatus to set
     */
    public void setPlanStatus(boolean planStatus) {
        this.planStatus = planStatus;
    }

    /**
     * @return the gatewayName
     */
    public String getGatewayName() {
        return gatewayName;
    }

    /**
     * @param gatewayName the gatewayName to set
     */
    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    /**
     * @return the gatewayId
     */
    public int getGatewayId() {
        return gatewayId;
    }

    /**
     * @param gatewayId the gatewayId to set
     */
    public void setGatewayId(int gatewayId) {
        this.gatewayId = gatewayId;
    }

    /**
     * @return the smsFreshLowBalance
     */
    public String getSmsFreshLowBalance() {
        return smsFreshLowBalance;
    }

    /**
     * @param smsFreshLowBalance the smsFreshLowBalance to set
     */
    public void setSmsFreshLowBalance(String smsFreshLowBalance) {
        this.smsFreshLowBalance = smsFreshLowBalance;
    }

    /**
     * @return the freshLowBalance
     */
    public boolean isFreshLowBalance() {
        return freshLowBalance;
    }

    /**
     * @param freshLowBalance the freshLowBalance to set
     */
    public void setFreshLowBalance(boolean freshLowBalance) {
        this.freshLowBalance = freshLowBalance;
    }

    /**
     * @return the smsRenewalLowBalance
     */
    public String getSmsRenewalLowBalance() {
        return smsRenewalLowBalance;
    }

    /**
     * @param smsRenewalLowBalance the smsRenewalLowBalance to set
     */
    public void setSmsRenewalLowBalance(String smsRenewalLowBalance) {
        this.smsRenewalLowBalance = smsRenewalLowBalance;
    }

    /**
     * @return the renewalLowBalance
     */
    public boolean isRenewalLowBalance() {
        return renewalLowBalance;
    }

    /**
     * @param renewalLowBalance the renewalLowBalance to set
     */
    public void setRenewalLowBalance(boolean renewalLowBalance) {
        this.renewalLowBalance = renewalLowBalance;
    }

    /**
     * @return the lowBalanceDays
     */
    public int getLowBalanceDays() {
        return lowBalanceDays;
    }

    /**
     * @param lowBalanceDays the lowBalanceDays to set
     */
    public void setLowBalanceDays(int lowBalanceDays) {
        this.lowBalanceDays = lowBalanceDays;
    }

    public boolean isPackType() {
        return packType;
    }

    public void setPackType(boolean packType) {
        this.packType = packType;
    }

    public String getBasePackName() {
        return basePackName;
    }

    public void setBasePackName(String basePackName) {
        this.basePackName = basePackName;
    }

    public int getBasePackId() {
        return basePackId;
    }

    public void setBasePackId(int basePackId) {
        this.basePackId = basePackId;
    }

	/**
	 * @return the pricing
	 */
	public int getPricing() {
		return pricing;
	}

	/**
	 * @param pricing the pricing to set
	 */
	public void setPricing(int pricing) {
		this.pricing = pricing;
	}

    /**
     * @return the footerMessage
     */
    public String getFooterMessage() {
        return footerMessage;
    }

    /**
     * @param footerMessage the footerMessage to set
     */
    public void setFooterMessage(String footerMessage) {
        this.footerMessage = footerMessage;
    }

    /**
     * @return the sentFooter
     */
    public boolean isSentFooter() {
        return sentFooter;
    }

    /**
     * @param sentFooter the sentFooter to set
     */
    public void setSentFooter(boolean sentFooter) {
        this.sentFooter = sentFooter;
    }

    /**
     * @return the aliasNames
     */
    public String getAliasNames() {
        return aliasNames;
    }

    /**
     * @param aliasNames the aliasNames to set
     */
    public void setAliasNames(String aliasNames) {
        this.aliasNames = aliasNames;
    }

	/**
	 * @return the actUssdString
	 */
	public String getActUssdString() {
		return actUssdString;
	}

	/**
	 * @param actUssdString the actUssdString to set
	 */
	public void setActUssdString(String actUssdString) {
		this.actUssdString = actUssdString;
	}

	/**
	 * @return the dctUssdString
	 */
	public String getDctUssdString() {
		return dctUssdString;
	}

	/**
	 * @param dctUssdString the dctUssdString to set
	 */
	public void setDctUssdString(String dctUssdString) {
		this.dctUssdString = dctUssdString;
	}

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


   

}
