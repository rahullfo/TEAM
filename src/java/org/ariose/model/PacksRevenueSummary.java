/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.model;

/**
 *
 * @author Sushil
 */
public class PacksRevenueSummary extends BaseObject {

    private String id;
    private int operatorId;
    private String packId;
    private String revenue;
    private String packName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getPackId() {
        return packId;
    }

    public void setPackId(String packId) {
        this.packId = packId;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }
}
