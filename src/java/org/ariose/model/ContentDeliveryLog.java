package org.ariose.model;

import java.util.Date;

/*
 * @author: manup:28apr09:added as required by the client
 */

public class ContentDeliveryLog extends BaseObject{
    Long id;
	String operatorName;
	int operatorId;
	String circleName;
	int circleId;
	String packName;
	int packId;
	Long subscriberNumber;
	String content;
	Date sentDate;
	String deliveryStatus;
	int contentSchedulerId;
    private Date logTime;	
	private String request;
    private String response;
    private int status;
	String shortcode;
	String keyword;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public int getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public Long getSubscriberNumber() {
		return subscriberNumber;
	}

	public void setSubscriberNumber(Long subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	/**
	 * @return the sentDate
	 */
	public Date getSentDate() {
		return sentDate;
	}

	/**
	 * @param sentDate the sentDate to set
	 */
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	/**
	 * @return the contentSchedulerId
	 */
	public int getContentSchedulerId() {
		return contentSchedulerId;
	}

	/**
	 * @param contentSchedulerId the contentSchedulerId to set
	 */
	public void setContentSchedulerId(int contentSchedulerId) {
		this.contentSchedulerId = contentSchedulerId;
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
	 * @return the shortcode
	 */
	public String getShortcode() {
		return shortcode;
	}

	/**
	 * @param shortcode the shortcode to set
	 */
	public void setShortcode(String shortcode) {
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

	
	
}
