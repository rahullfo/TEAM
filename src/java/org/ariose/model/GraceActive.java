/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class GraceActive extends BaseObject {

    private int id;
    private int packID;  
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;
    private boolean isFrequency;
    private int gracePeriod;
    private int graceContentdays;

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
     * @return the mon
     */
    public String getMon() {
        return mon;
    }

    /**
     * @param mon the mon to set
     */
    public void setMon(String mon) {
        this.mon = mon;
    }

    /**
     * @return the tue
     */
    public String getTue() {
        return tue;
    }

    /**
     * @param tue the tue to set
     */
    public void setTue(String tue) {
        this.tue = tue;
    }

    /**
     * @return the wed
     */
    public String getWed() {
        return wed;
    }

    /**
     * @param wed the wed to set
     */
    public void setWed(String wed) {
        this.wed = wed;
    }

    /**
     * @return the thu
     */
    public String getThu() {
        return thu;
    }

    /**
     * @param thu the thu to set
     */
    public void setThu(String thu) {
        this.thu = thu;
    }

    /**
     * @return the fri
     */
    public String getFri() {
        return fri;
    }

    /**
     * @param fri the fri to set
     */
    public void setFri(String fri) {
        this.fri = fri;
    }

    /**
     * @return the sat
     */
    public String getSat() {
        return sat;
    }

    /**
     * @param sat the sat to set
     */
    public void setSat(String sat) {
        this.sat = sat;
    }

    /**
     * @return the sun
     */
    public String getSun() {
        return sun;
    }

    /**
     * @param sun the sun to set
     */
    public void setSun(String sun) {
        this.sun = sun;
    }

    /**
     * @return the isFrequency
     */
    public boolean isIsFrequency() {
        return isFrequency;
    }

    /**
     * @param isFrequency the isFrequency to set
     */
    public void setIsFrequency(boolean isFrequency) {
        this.isFrequency = isFrequency;
    }

    /**
     * @return the gracePeriod
     */
    public int getGracePeriod() {
        return gracePeriod;
    }

    /**
     * @param gracePeriod the gracePeriod to set
     */
    public void setGracePeriod(int gracePeriod) {
        this.gracePeriod = gracePeriod;
    }

    /**
     * @return the graceContentdays
     */
    public int getGraceContentdays() {
        return graceContentdays;
    }

    /**
     * @param graceContentdays the graceContentdays to set
     */
    public void setGraceContentdays(int graceContentdays) {
        this.graceContentdays = graceContentdays;
    }
}
