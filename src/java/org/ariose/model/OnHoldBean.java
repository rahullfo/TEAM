/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class OnHoldBean extends BaseObject{
    private Long id;
    private Long mobileNo;
    private int packId;
    private int channelId;
    private int action;
    private int operatorId;
    private int circleId;
    private String handsetType;
    String operatorName;
    String circleName;
    String packName;
    

    public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

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
     * @return the mobileNo
     */
    public Long getMobileNo() {
        return mobileNo;
    }

    /**
     * @param mobileNo the mobileNo to set
     */
    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
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
     * @return the channelId
     */
    public int getChannelId() {
        return channelId;
    }

    /**
     * @param channelId the channelId to set
     */
    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    /**
     * @return the action
     */
    public int getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(int action) {
        this.action = action;
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
     * @return the handsetType
     */
    public String getHandsetType() {
        return handsetType;
    }

    /**
     * @param handsetType the handsetType to set
     */
    public void setHandsetType(String handsetType) {
        this.handsetType = handsetType;
    }

  
}
