package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class SubscriptionBean extends BaseObject {
	
//	AmountCharged
//	ExpiryDate
//	ServiceName
//	ProductName
//	ExtTxId
//	SubID
//	SubscriptionValidity
//	ChannelType
//	
//    private String subscriptionCreationDate;
//    private String subscriptionValidDate;
//    private String nextchargingDate;
//    private String activationDate;
//    private String source;
//	

    private Long id;
    private Long subscriberNo;
    private int subscriptionPackId;
    private int regionId;
    private String subscriptionCreationDate;
    private String subscriptionValidDate;
    private int subscriptionStatus;
    private String subscriptionStatusMeaning;
    private String nextchargingDate;
    private String contentDeliveryDate;
    private String activationDate;
    private int operatorID;
    private int channelId;
    private String email;
    private String unsubscribeDate;
    private String source;
    private int renewalCounter;                 
    private String deactivationSource;
    private int shortcode;
    private String keyword;  
    private String logtime;
    private String operatorName;
    private String circleName;
    private String packName;
    private String lastRenewDate;
    private boolean smsSentStatus;    
    private String handsetType;
    private String amount;
    private String validity;
    private String minutes;
    private String renewalAmount;
    private String type; 
    
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
     * @return the subscriptionCreationDate
     */
    public String getSubscriptionCreationDate() {
        return subscriptionCreationDate;
    }

    /**
     * @param subscriptionCreationDate the subscriptionCreationDate to set
     */
    public void setSubscriptionCreationDate(String subscriptionCreationDate) {
        this.subscriptionCreationDate = subscriptionCreationDate;
    }

    /**
     * @return the subscriptionValidDate
     */
    public String getSubscriptionValidDate() {
        return subscriptionValidDate;
    }

    /**
     * @param subscriptionValidDate the subscriptionValidDate to set
     */
    public void setSubscriptionValidDate(String subscriptionValidDate) {
        this.subscriptionValidDate = subscriptionValidDate;
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
     * @return the nextchargingDate
     */
    public String getNextchargingDate() {
        return nextchargingDate;
    }

    /**
     * @param nextchargingDate the nextchargingDate to set
     */
    public void setNextchargingDate(String nextchargingDate) {
        this.nextchargingDate = nextchargingDate;
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
     * @param regionId the regionId to set
     */
    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
	 * @return the unsubscribeDate
	 */
	public String getUnsubscribeDate() {
		return unsubscribeDate;
	}

	/**
	 * @param unsubscribeDate the unsubscribeDate to set
	 */
	public void setUnsubscribeDate(String unsubscribeDate) {
		this.unsubscribeDate = unsubscribeDate;
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
	 * @return the renewalCounter
	 */
	public int getRenewalCounter() {
		return renewalCounter;
	}

	/**
	 * @param renewalCounter the renewalCounter to set
	 */
	public void setRenewalCounter(int renewalCounter) {
		this.renewalCounter = renewalCounter;
	}

	/**
	 * @return the deactivationSource
	 */
	public String getDeactivationSource() {
		return deactivationSource;
	}

	/**
	 * @param deactivationSource the deactivationSource to set
	 */
	public void setDeactivationSource(String deactivationSource) {
		this.deactivationSource = deactivationSource;
	}

	/**
	 * @return the shortcode
	 */
	public int getShortcode() {
		return shortcode;
	}

	/**
	 * @param shortcode the shortcode to set
	 */
	public void setShortcode(int shortcode) {
		this.shortcode = shortcode;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the logtime
	 */
	public String getLogtime() {
		return logtime;
	}

	/**
	 * @param logtime the logtime to set
	 */
	public void setLogtime(String logtime) {
		this.logtime = logtime;
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
	 * @return the lastRenewDate
	 */
	public String getLastRenewDate() {
		return lastRenewDate;
	}

	/**
	 * @param lastRenewDate the lastRenewDate to set
	 */
	public void setLastRenewDate(String lastRenewDate) {
		this.lastRenewDate = lastRenewDate;
	}

	/**
	 * @return the smsSentStatus
	 */
	public boolean isSmsSentStatus() {
		return smsSentStatus;
	}

	/**
	 * @param smsSentStatus the smsSentStatus to set
	 */
	public void setSmsSentStatus(boolean smsSentStatus) {
		this.smsSentStatus = smsSentStatus;
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}


	/**
	 * @return the validity
	 */
	public String getValidity() {
		return validity;
	}

	/**
	 * @param validity the validity to set
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}

	/**
	 * @return the minutes
	 */
	public String getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	/**
	 * @return the renewalAmount
	 */
	public String getRenewalAmount() {
		return renewalAmount;
	}

	/**
	 * @param renewalAmount the renewalAmount to set
	 */
	public void setRenewalAmount(String renewalAmount) {
		this.renewalAmount = renewalAmount;
	}

	public String getSubscriptionStatusMeaning() {
		return subscriptionStatusMeaning;
	}

	public void setSubscriptionStatusMeaning(String subscriptionStatusMeaning) {
		this.subscriptionStatusMeaning = subscriptionStatusMeaning;
	}


}
