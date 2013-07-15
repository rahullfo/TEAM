/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class GatewayBean extends BaseObject {

    private int id;
    private int regionId;
    private int operatorId;
    private String via;
    private String chargeUrl;
    private String chargeUserName;
    private String chargePassword;
    private String chargeToTime;
    private String chargeFromTime;
    private String chargingName;

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
     * @return the via
     */
    public String getVia() {
        return via;
    }

    /**
     * @param via the via to set
     */
    public void setVia(String via) {
        this.via = via;
    }

    /**
     * @return the chargeUrl
     */
    public String getChargeUrl() {
        return chargeUrl;
    }

    /**
     * @param chargeUrl the chargeUrl to set
     */
    public void setChargeUrl(String chargeUrl) {
        this.chargeUrl = chargeUrl;
    }

    /**
     * @return the chargeUserName
     */
    public String getChargeUserName() {
        return chargeUserName;
    }

    /**
     * @param chargeUserName the chargeUserName to set
     */
    public void setChargeUserName(String chargeUserName) {
        this.chargeUserName = chargeUserName;
    }

    /**
     * @return the chargePassword
     */
    public String getChargePassword() {
        return chargePassword;
    }

    /**
     * @param chargePassword the chargePassword to set
     */
    public void setChargePassword(String chargePassword) {
        this.chargePassword = chargePassword;
    }

    /**
     * @return the chargeToTime
     */
    public String getChargeToTime() {
        return chargeToTime;
    }

    /**
     * @param chargeToTime the chargeToTime to set
     */
    public void setChargeToTime(String chargeToTime) {
        this.chargeToTime = chargeToTime;
    }

    /**
     * @return the chargeFromTime
     */
    public String getChargeFromTime() {
        return chargeFromTime;
    }

    /**
     * @param chargeFromTime the chargeFromTime to set
     */
    public void setChargeFromTime(String chargeFromTime) {
        this.chargeFromTime = chargeFromTime;
    }

    /**
     * @return the chargingName
     */
    public String getChargingName() {
        return chargingName;
    }

    /**
     * @param chargingName the chargingName to set
     */
    public void setChargingName(String chargingName) {
        this.chargingName = chargingName;
    }

}
