/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class SubscriptionFailBean extends BaseObject {    
    private int id;
  	
    //manup 04/08/10 added this field for nazara-reliance integration
    private int channelId;   	

    private Long subscriberNumber;
    private int subscriptionPackId;
    private int circleId;
    private String nextChargingDate;
    private int subscriptionStatus;
    private int lowBalanceStatus;
    private int pvFailRowIdx;
    private int price;
    private int validity;
    private int operator;
    private String packName;
    private int grace;
    private int waitPeriod;
    private int maxRetries;
    private String graceChargingTime;
    private String validDate;
    private int lowBalanceDays;
    private String contentDeliveryDate;
    private int graceContentDays;
	private String activationDate;
	
	//manup:added:12aug10:bug:next charging date was not getting set properly after low balance failure
	//when tried once..twice
    private int preRenewalDays;

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
     * @return the subscriberNumber
     */
    public Long getSubscriberNumber() {
        return subscriberNumber;
    }

    /**
     * @param subscriberNumber the subscriberNumber to set
     */
    public void setSubscriberNumber(Long subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
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
     * @return the circleId
     */
    public int getCircleId() {
        return circleId;
    }

    /**
     * @param circleId the circleId to set
     */
    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    /**
     * @return the nextChargingDate
     */
    public String getNextChargingDate() {
        return nextChargingDate;
    }

    /**
     * @param nextChargingDate the nextChargingDate to set
     */
    public void setNextChargingDate(String nextChargingDate) {
        this.nextChargingDate = nextChargingDate;
    }

    /**
     * @return the subscriptionStatus
     */
    public int getSubscriptionStatus() {
        return subscriptionStatus;
    }

    /**
     * @param subscriptionStatus the subscriptionStatus to set
     */
    public void setSubscriptionStatus(int subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
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
     * @return the pvFailRowIdx
     */
    public int getPvFailRowIdx() {
        return pvFailRowIdx;
    }

    /**
     * @param pvFailRowIdx the pvFailRowIdx to set
     */
    public void setPvFailRowIdx(int pvFailRowIdx) {
        this.pvFailRowIdx = pvFailRowIdx;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the validity
     */
    public int getValidity() {
        return validity;
    }

    /**
     * @param validity the validity to set
     */
    public void setValidity(int validity) {
        this.validity = validity;
    }

    /**
     * @return the operator
     */
    public int getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(int operator) {
        this.operator = operator;
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
     * @return the graceChargingTime
     */
    public String getGraceChargingTime() {
        return graceChargingTime;
    }

    /**
     * @param graceChargingTime the graceChargingTime to set
     */
    public void setGraceChargingTime(String graceChargingTime) {
        this.graceChargingTime = graceChargingTime;
    }

    /**
     * @return the validDate
     */
    public String getValidDate() {
        return validDate;
    }

    /**
     * @param validDate the validDate to set
     */
    public void setValidDate(String validDate) {
        this.validDate = validDate;
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

    /**
     * @return the contentDeliveryDate
     */
    public String getContentDeliveryDate() {
        return contentDeliveryDate;
    }

    /**
     * @param contentDeliveryDate the contentDeliveryDate to set
     */
    public void setContentDeliveryDate(String contentDeliveryDate) {
        this.contentDeliveryDate = contentDeliveryDate;
    }

    /**
     * @return the graceContentDays
     */
    public int getGraceContentDays() {
        return graceContentDays;
    }

    /**
     * @param graceContentDays the graceContentDays to set
     */
    public void setGraceContentDays(int graceContentDays) {
        this.graceContentDays = graceContentDays;
    }

    public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

   
	/**
	 * @return the channelId
	 */
	public int getChannelId() {
		return channelId;
	}

	/**
	 * @param channelId the channelId to set
	 */
	public void setChannelId(int channelId) {
		this.channelId = channelId;
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


   
}
