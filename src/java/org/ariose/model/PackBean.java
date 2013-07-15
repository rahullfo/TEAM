/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ariose.model;

import java.util.Date;

/**
 *
 * @author shweta
 */
public class PackBean {

 
    private String packName;
    private int packId;
    private long revenue;

    /**
     * @return the packName
     */
    public String getPackName() {
        return packName;
    }

    /**
     * @param packName the packName to set
     */
    public void setPackName(String packName) {
        this.packName = packName;
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
     * @return the revenue
     */
    public long getRevenue() {
        return revenue;
    }

    /**
     * @param revenue the revenue to set
     */
    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

}
