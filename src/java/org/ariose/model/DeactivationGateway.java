package org.ariose.model;

/*
 * @author:Manu Parmar:Jan 2011: idea 2ergo integration
 */

public class DeactivationGateway extends BaseObject {
	private int id;
	private int operatorId;
	private String gatewayName;
    private String url;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

    

}
