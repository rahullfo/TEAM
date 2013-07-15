/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

/**
 *
 * @author Sukhdeep
 */
public class CircleBean  extends BaseObject {

    private int id;
    private String circleName;
    private String circleDescription;
    private int ideaSiteId;
    private String region; //values north/ south
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
     * @return the circleName
     */
    public String getCircleName() {
        return circleName;
    }

    /**
     * @param circleName the circleName to set
     */
    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    /**
     * @return the circleDescription
     */
    public String getCircleDescription() {
        return circleDescription;
    }

    /**
     * @param circleDescription the circleDescription to set
     */
    public void setCircleDescription(String circleDescription) {
        this.circleDescription = circleDescription;
    }

	/**
	 * @return the ideaSiteId
	 */
	public int getIdeaSiteId() {
		return ideaSiteId;
	}

	/**
	 * @param ideaSiteId the ideaSiteId to set
	 */
	public void setIdeaSiteId(int ideaSiteId) {
		this.ideaSiteId = ideaSiteId;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

    
}
