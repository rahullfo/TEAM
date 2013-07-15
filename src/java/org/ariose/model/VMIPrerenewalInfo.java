/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 * 
 * @author manu parmar: Sep 2011
 */
public class VMIPrerenewalInfo extends BaseObject {

	private long id;
	private long subscriberNumber;
	private int packId;
	private String packName;
	private long subscriptionId;
	private String validDate;
	private String smsSendingTime;
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
	 * @return the smsSendingTime
	 */
	public String getSmsSendingTime() {
		return smsSendingTime;
	}
	/**
	 * @param smsSendingTime the smsSendingTime to set
	 */
	public void setSmsSendingTime(String smsSendingTime) {
		this.smsSendingTime = smsSendingTime;
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

	
}
