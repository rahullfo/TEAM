/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class ConfigurationBean  extends BaseObject {

    private int id;
    private String cfgLogLevel;
    private String cfgLogSize;
    private String cfgLogFileName;
    private String cfgEmailUserName;
    private String cfgEmailPassword;
    private String cfgEmailPopServer;
    private String cfgEmailSmtpServer;
    private String cfgEmailPopPort;
    private String cfgEmailSmtpPort;
    private String cfgSmscUrl;
    private String cfgSmscUserName;
    private String cfgSmscPassword;
    private String onHold;
    private int operatorId;
    private String currency;

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
     * @return the cfgLogLevel
     */
    public String getCfgLogLevel() {
        return cfgLogLevel;
    }

    /**
     * @param cfgLogLevel the cfgLogLevel to set
     */
    public void setCfgLogLevel(String cfgLogLevel) {
        this.cfgLogLevel = cfgLogLevel;
    }

    /**
     * @return the cfgLogSize
     */
    public String getCfgLogSize() {
        return cfgLogSize;
    }

    /**
     * @param cfgLogSize the cfgLogSize to set
     */
    public void setCfgLogSize(String cfgLogSize) {
        this.cfgLogSize = cfgLogSize;
    }

    /**
     * @return the cfgLogFileName
     */
    public String getCfgLogFileName() {
        return cfgLogFileName;
    }

    /**
     * @param cfgLogFileName the cfgLogFileName to set
     */
    public void setCfgLogFileName(String cfgLogFileName) {
        this.cfgLogFileName = cfgLogFileName;
    }

    /**
     * @return the cfgEmailUserName
     */
    public String getCfgEmailUserName() {
        return cfgEmailUserName;
    }

    /**
     * @param cfgEmailUserName the cfgEmailUserName to set
     */
    public void setCfgEmailUserName(String cfgEmailUserName) {
        this.cfgEmailUserName = cfgEmailUserName;
    }

    /**
     * @return the cfgEmailPassword
     */
    public String getCfgEmailPassword() {
        return cfgEmailPassword;
    }

    /**
     * @param cfgEmailPassword the cfgEmailPassword to set
     */
    public void setCfgEmailPassword(String cfgEmailPassword) {
        this.cfgEmailPassword = cfgEmailPassword;
    }

    /**
     * @return the cfgEmailPopServer
     */
    public String getCfgEmailPopServer() {
        return cfgEmailPopServer;
    }

    /**
     * @param cfgEmailPopServer the cfgEmailPopServer to set
     */
    public void setCfgEmailPopServer(String cfgEmailPopServer) {
        this.cfgEmailPopServer = cfgEmailPopServer;
    }

    /**
     * @return the cfgEmailSmtpServer
     */
    public String getCfgEmailSmtpServer() {
        return cfgEmailSmtpServer;
    }

    /**
     * @param cfgEmailSmtpServer the cfgEmailSmtpServer to set
     */
    public void setCfgEmailSmtpServer(String cfgEmailSmtpServer) {
        this.cfgEmailSmtpServer = cfgEmailSmtpServer;
    }

    /**
     * @return the cfgEmailPopPort
     */
    public String getCfgEmailPopPort() {
        return cfgEmailPopPort;
    }

    /**
     * @param cfgEmailPopPort the cfgEmailPopPort to set
     */
    public void setCfgEmailPopPort(String cfgEmailPopPort) {
        this.cfgEmailPopPort = cfgEmailPopPort;
    }

    /**
     * @return the cfgEmailSmtpPort
     */
    public String getCfgEmailSmtpPort() {
        return cfgEmailSmtpPort;
    }

    /**
     * @param cfgEmailSmtpPort the cfgEmailSmtpPort to set
     */
    public void setCfgEmailSmtpPort(String cfgEmailSmtpPort) {
        this.cfgEmailSmtpPort = cfgEmailSmtpPort;
    }

    /**
     * @return the cfgSmscUrl
     */
    public String getCfgSmscUrl() {
        return cfgSmscUrl;
    }

    /**
     * @param cfgSmscUrl the cfgSmscUrl to set
     */
    public void setCfgSmscUrl(String cfgSmscUrl) {
        this.cfgSmscUrl = cfgSmscUrl;
    }

    /**
     * @return the cfgSmscUserName
     */
    public String getCfgSmscUserName() {
        return cfgSmscUserName;
    }

    /**
     * @param cfgSmscUserName the cfgSmscUserName to set
     */
    public void setCfgSmscUserName(String cfgSmscUserName) {
        this.cfgSmscUserName = cfgSmscUserName;
    }

    /**
     * @return the cfgSmscPassword
     */
    public String getCfgSmscPassword() {
        return cfgSmscPassword;
    }

    /**
     * @param cfgSmscPassword the cfgSmscPassword to set
     */
    public void setCfgSmscPassword(String cfgSmscPassword) {
        this.cfgSmscPassword = cfgSmscPassword;
    }

    /**
     * @return the onHold
     */
    public String getOnHold() {
        return onHold;
    }

    /**
     * @param onHold the onHold to set
     */
    public void setOnHold(String onHold) {
        this.onHold = onHold;
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
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

   
  
}
