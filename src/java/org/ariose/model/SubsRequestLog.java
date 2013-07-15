package org.ariose.model;

import java.util.Date;

/*
 * @author manup:29Apr09
 */

public class SubsRequestLog extends BaseObject{
	private Long id;
	private String operatorName;
	private int operatorId;
	private String circleName;
	private int circleId;
	private String packName;
	private int packId;
	private String subscriberNumber;
	private String keyword;
	private int channelId;
	private Date requestTime;
	private String subscriptionStatus;
	private String subscriptionStatusMeaning;
	private String shortcode;
    private Date logTime;
    private String request;
    private String response;
    
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

	public String getSubscriberNumber() {
		return subscriberNumber;
	}

	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getChannelId() {
		return channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		String message = this.subscriptionStatus;
		
		try {
			message = message.substring(message.indexOf("-"),message.length()).trim();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return message;
	}

	
	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode;
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
		
//		try {
//			message = message.substring(message.indexOf("-"),message.length()).trim();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return message;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

    


}
