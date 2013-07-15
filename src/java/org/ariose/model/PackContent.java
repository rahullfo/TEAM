/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author A.Rahman
 */
public class PackContent extends BaseObject{
    private int id;
    private int packId;
    private Long contentId;
    private String priority;
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private boolean isDFWeeklyDaily;
    private String circleName;
    private String operatorName;
    private int circleId;
    private int operatorId;
    private String packName;
    private int circlespecific;
    
    /**
     * @return the packId circleName,operatorName,circleId,operatorId,packName
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
     * @return the contentId
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * @param contentId the contentId to set
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
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

    

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

	/**
	 * @return the circlespecific
	 */
	public int getCirclespecific() {
		return circlespecific;
	}

	/**
	 * @param circlespecific the circlespecific to set
	 */
	public void setCirclespecific(int circlespecific) {
		this.circlespecific = circlespecific;
	}

    
  

}
