/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 * 
 * @author manu parmar: Sep 2011
 */
public class DocomoChargingGatewayResp extends BaseObject {
	// amount,minutes,next-charging-date,renewal-amount,subscription_status [6,
	// 2, 3]

	private long id;
	private long subscriberNumber;
	private int packId;
	private String packName;
	private long subscriptionId;
	private int subscriptionStatus;
	private String subscriptionStatusMeaning;
	private String amount;
	private String minutes;
	private long subscriptionFailId;
	private String validDate;
	private String logtime;
	private String updateTime;

	/*
	 * 0 unread
	 * 
	 * 2 - read and task not done
	 * 
	 * 3 - read and task done
	 */
	private int status;
	private String statusMeaning;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the subscriptionId
	 */
	public long getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
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
	 * @return the subscriptionStatusMeaning
	 */
	public String getSubscriptionStatusMeaning() {
		return subscriptionStatusMeaning;
	}

	/**
	 * @param subscriptionStatusMeaning the subscriptionStatusMeaning to set
	 */
	public void setSubscriptionStatusMeaning(String subscriptionStatusMeaning) {
		this.subscriptionStatusMeaning = subscriptionStatusMeaning;
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
	 * @return the subscriptionFailId
	 */
	public long getSubscriptionFailId() {
		return subscriptionFailId;
	}

	/**
	 * @param subscriptionFailId the subscriptionFailId to set
	 */
	public void setSubscriptionFailId(long subscriptionFailId) {
		this.subscriptionFailId = subscriptionFailId;
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
	 * @return the statusMeaning
	 */
	public String getStatusMeaning() {
		return statusMeaning;
	}

	/**
	 * @param statusMeaning the statusMeaning to set
	 */
	public void setStatusMeaning(String statusMeaning) {
		this.statusMeaning = statusMeaning;
	}

	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}


}
