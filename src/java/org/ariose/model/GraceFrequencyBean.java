/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class GraceFrequencyBean  extends BaseObject  {
    private int id;
    private int packID;
    private int contentDay;
    private int chargingDay;

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
     * @return the contentDay
     */
    public int getContentDay() {
        return contentDay;
    }

    /**
     * @param contentDay the contentDay to set
     */
    public void setContentDay(int contentDay) {
        this.contentDay = contentDay;
    }

    /**
     * @return the chargingDay
     */
    public int getChargingDay() {
        return chargingDay;
    }

    /**
     * @param chargingDay the chargingDay to set
     */
    public void setChargingDay(int chargingDay) {
        this.chargingDay = chargingDay;
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

}
