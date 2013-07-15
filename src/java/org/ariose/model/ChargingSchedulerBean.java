/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class ChargingSchedulerBean extends BaseObject{
    private Long id;
    private int operatorId;
    private int circleId;
    private String priority;
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private boolean isDFWeeklyDaily;

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
     * @return the priority
     */
    public String getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * @return the sunday
     */
    public String getSunday() {
        return sunday;
    }

    /**
     * @param sunday the sunday to set
     */
    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    /**
     * @return the monday
     */
    public String getMonday() {
        return monday;
    }

    /**
     * @param monday the monday to set
     */
    public void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * @return the tuesday
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * @param tuesday the tuesday to set
     */
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * @return the wednesday
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * @param wednesday the wednesday to set
     */
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * @return the thursday
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * @param thursday the thursday to set
     */
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * @return the friday
     */
    public String getFriday() {
        return friday;
    }

    /**
     * @param friday the friday to set
     */
    public void setFriday(String friday) {
        this.friday = friday;
    }

    /**
     * @return the saturday
     */
    public String getSaturday() {
        return saturday;
    }

    /**
     * @param saturday the saturday to set
     */
    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    /**
     * @return the isDFWeeklyDaily
     */
    public boolean isIsDFWeeklyDaily() {
        return isDFWeeklyDaily;
    }

    /**
     * @param isDFWeeklyDaily the isDFWeeklyDaily to set
     */
    public void setIsDFWeeklyDaily(boolean isDFWeeklyDaily) {
        this.isDFWeeklyDaily = isDFWeeklyDaily;
    }

}
