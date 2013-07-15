/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Manu Parmar Jan 2011 2Ergo Idea Integration
 */
public class IdeaChargingGatewayResponseBean  extends BaseObject{
	private Long id;
	private Long subscriberNumber;     
	private int packId;               
	private String packName;             
	private String svcKey;               
	private Long subscriptionId;       
	private int chTranactionLogxId; 
	private int httpResponseCode;    
	private String responseString;       
	private int status;
	private String logtime;
	private int hasissue;
	private String sms;
	private int circleId;
	private int price;
	private int validity;
	private int shortcode;
	private String keyword;
	private String circleName;
	private int operatorId;
	private String operatorName;

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
	 * @return the svcKey
	 */
	public String getSvcKey() {
		return svcKey;
	}
	/**
	 * @param svcKey the svcKey to set
	 */
	public void setSvcKey(String svcKey) {
		this.svcKey = svcKey;
	}
	/**
	 * @return the subscriptionId
	 */
	public Long getSubscriptionId() {
		return subscriptionId;
	}
	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	/**
	 * @return the chTranactionLogxId
	 */
	public int getChTranactionLogxId() {
		return chTranactionLogxId;
	}
	/**
	 * @param chTranactionLogxId the chTranactionLogxId to set
	 */
	public void setChTranactionLogxId(int chTranactionLogxId) {
		this.chTranactionLogxId = chTranactionLogxId;
	}
	/**
	 * @return the httpResponseCode
	 */
	public int getHttpResponseCode() {
		return httpResponseCode;
	}
	/**
	 * @param httpResponseCode the httpResponseCode to set
	 */
	public void setHttpResponseCode(int httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}
	/**
	 * @return the responseString
	 */
	public String getResponseString() {
		return responseString;
	}
	/**
	 * @param responseString the responseString to set
	 */
	public void setResponseString(String responseString) {
		this.responseString = responseString;
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
	 * @return the hasissue
	 */
	public int getHasissue() {
		return hasissue;
	}
	/**
	 * @param hasissue the hasissue to set
	 */
	public void setHasissue(int hasissue) {
		this.hasissue = hasissue;
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
	 * @return the sms
	 */
	public String getSms() {
		return sms;
	}
	/**
	 * @param sms the sms to set
	 */
	public void setSms(String sms) {
		this.sms = sms;
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
	
}
