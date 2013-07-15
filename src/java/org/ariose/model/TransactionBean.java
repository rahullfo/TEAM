package org.ariose.model;

import java.util.Date;

/**
 * This class stores user specific action eg. when user subscribes/unsubscribes/renews etc
 * @author manup:22apr09:modified based on table structure
 */
public class TransactionBean  extends BaseObject{

    private int id;
    private String circleName;
    private int circleId;
    private String packName;
    private int packId;
    private Long subscriberNumber;
    private String activationDate;
    private int priceCharged;
    private String chargingDate;
    private String subscriptionStatus;
    private String chargingStatus;
    private String reason;
    private String operatorName;
    private int operatorId;
    private String smsString;
    
    private String request;
    private String response;
    private int status; //0-success, 1-error
    private Date logTime;
    private String source;
    private String renewDate;
    

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
     * @return the packId
     */
    public int getPackId() {
        return packId;
    }

    /**
     * @param packId the packId to set
     */
    public void setPackId(int packId) {
        this.packId = packId;
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
     * @return the activationDate
     */
    public String getActivationDate() {
        return activationDate;
    }

    /**
     * @param activationDate the activationDate to set
     */
    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    /**
     * @return the priceCharged
     */
    public int getPriceCharged() {
        return priceCharged;
    }

    /**
     * @param priceCharged the priceCharged to set
     */
    public void setPriceCharged(int priceCharged) {
        this.priceCharged = priceCharged;
    }

    /**
     * @return the chargingDate
     */
    public String getChargingDate() {
        return chargingDate;
    }

    /**
     * @param chargingDate the chargingDate to set
     */
    public void setChargingDate(String chargingDate) {
        this.chargingDate = chargingDate;
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
     * @return the chargingStatus
     */
    public String getChargingStatus() {
        return chargingStatus;
    }

    /**
     * @param chargingStatus the chargingStatus to set
     */
    public void setChargingStatus(String chargingStatus) {
        this.chargingStatus = chargingStatus;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
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
     * @return the smsString
     */
    public String getSmsString() {
        return smsString;
    }

    /**
     * @param smsString the smsString to set
     */
    public void setSmsString(String smsString) {
        this.smsString = smsString;
    }

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the logTime
	 */
	public Date getLogTime() {
		return logTime;
	}

	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}


	
    /**
	 * @return the renewDate
	 */
	public String getRenewDate() {
		return renewDate;
	}

	/**
	 * @param renewDate the renewDate to set
	 */
	public void setRenewDate(String renewDate) {
		this.renewDate = renewDate;
	}

	public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }




}
