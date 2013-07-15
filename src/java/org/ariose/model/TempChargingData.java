/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class TempChargingData  extends BaseObject {

    private int id;
  	//manup 04/08/10 added this field for nazara-reliance integration
    private int channelId;   	
    
    private int failID;
    private Long mobileNo;
    private int packID;
    private int status;
    private int circleId;
    private String circleName;
    private String nextChargingDate;
    private String validityDate;
    private int requestType;
    private int lowBalanceStatus;
    private String packName;
    private int waitPeriod;
    private int maxRetries;
    private String smsActivaion;
    private String smsDeactivaion;
    private String smsGrace;
    private String smsFreshLowbalance;
    private String smsRenewalLowbalance;
    private int isAdMassageSMSFlag;
    private int freshLowbalanceSMSFlag;
    private int renewalLowbalanceSMSFlag;
    private int preRenewalDays;
    private int lowBalanceDays;
    private String contentDeliveryDate;
    private int price;
    private int validity;
    private int minutes;
    private int graceCount;
    private int graceContentDays;
    private int pvFailRowIdx;
    private int operator;
    private int grace;
    private String graceChargingTime;
    private String validDate;
    private String operatorName;
    private int gatewayId;
    private String adminSenderId;
    private String appID;
    private String typeOfRequest;
    private String activationDate;
    private String vasCode;
    private String keyword;
    private String source;
    private String action;
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
     * @return the failID
     */
    public int getFailID() {
        return failID;
    }

    /**
     * @param failID the failID to set
     */
    public void setFailID(int failID) {
        this.failID = failID;
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
     * @return the validityDate
     */
    public String getValidityDate() {
        return validityDate;
    }

    /**
     * @param validityDate the validityDate to set
     */
    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    /**
     * @return the requestType
     */
    public int getRequestType() {
        return requestType;
    }

    /**
     * @param requestType the requestType to set
     */
    public void setRequestType(int requestType) {
        this.requestType = requestType;
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
     * @return the smsFreshLowbalance
     */
    public String getSmsFreshLowbalance() {
        return smsFreshLowbalance;
    }

    /**
     * @param smsFreshLowbalance the smsFreshLowbalance to set
     */
    public void setSmsFreshLowbalance(String smsFreshLowbalance) {
        this.smsFreshLowbalance = smsFreshLowbalance;
    }

    /**
     * @return the smsRenewalLowbalance
     */
    public String getSmsRenewalLowbalance() {
        return smsRenewalLowbalance;
    }

    /**
     * @param smsRenewalLowbalance the smsRenewalLowbalance to set
     */
    public void setSmsRenewalLowbalance(String smsRenewalLowbalance) {
        this.smsRenewalLowbalance = smsRenewalLowbalance;
    }

    /**
     * @return the isAdMassageSMSFlag
     */
    public int getIsAdMassageSMSFlag() {
        return isAdMassageSMSFlag;
    }

    /**
     * @param isAdMassageSMSFlag the isAdMassageSMSFlag to set
     */
    public void setIsAdMassageSMSFlag(int isAdMassageSMSFlag) {
        this.isAdMassageSMSFlag = isAdMassageSMSFlag;
    }

    /**
     * @return the freshLowbalanceSMSFlag
     */
    public int getFreshLowbalanceSMSFlag() {
        return freshLowbalanceSMSFlag;
    }

    /**
     * @param freshLowbalanceSMSFlag the freshLowbalanceSMSFlag to set
     */
    public void setFreshLowbalanceSMSFlag(int freshLowbalanceSMSFlag) {
        this.freshLowbalanceSMSFlag = freshLowbalanceSMSFlag;
    }

    /**
     * @return the renewalLowbalanceSMSFlag
     */
    public int getRenewalLowbalanceSMSFlag() {
        return renewalLowbalanceSMSFlag;
    }

    /**
     * @param renewalLowbalanceSMSFlag the renewalLowbalanceSMSFlag to set
     */
    public void setRenewalLowbalanceSMSFlag(int renewalLowbalanceSMSFlag) {
        this.renewalLowbalanceSMSFlag = renewalLowbalanceSMSFlag;
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
     * @return the graceCount
     */
    public int getGraceCount() {
        return graceCount;
    }

    /**
     * @param graceCount the graceCount to set
     */
    public void setGraceCount(int graceCount) {
        this.graceCount = graceCount;
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
     * @return the appID
     */
    public String getAppID() {
        return appID;
    }

    /**
     * @param appID the appID to set
     */
    public void setAppID(String appID) {
        this.appID = appID;
    }

    /**
     * @return the typeOfRequest
     */
    public String getTypeOfRequest() {
        return typeOfRequest;
    }

    /**
     * @param typeOfRequest the typeOfRequest to set
     */
    public void setTypeOfRequest(String typeOfRequest) {
        this.typeOfRequest = typeOfRequest;
    }

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	/**
	 * @return the vasCode
	 */
	public String getVasCode() {
		return vasCode;
	}

	/**
	 * @param vasCode the vasCode to set
	 */
	public void setVasCode(String vasCode) {
		this.vasCode = vasCode;
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
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * @param minutes the minutes to set
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}


	
}
