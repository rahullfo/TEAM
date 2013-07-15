/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.model;

/**
 *
 * @author Sushil
 */
public class DailySummary extends BaseObject {

    private int id;
    private int operatorId;
    private String newSubscriptions;
    private String totalSubscriptions;
    private String totalCharging;
    private String totalContentsDelivered;
    private String date;

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getNewSubscriptions() {
        return newSubscriptions;
    }

    public void setNewSubscriptions(String newSubscriptions) {
        this.newSubscriptions = newSubscriptions;
    }

    public String getTotalCharging() {
        return totalCharging;
    }

    public void setTotalCharging(String totalCharging) {
        this.totalCharging = totalCharging;
    }

    public String getTotalContentsDelivered() {
        return totalContentsDelivered;
    }

    public void setTotalContentsDelivered(String totalContentsDelivered) {
        this.totalContentsDelivered = totalContentsDelivered;
    }

    public String getTotalSubscriptions() {
        return totalSubscriptions;
    }

    public void setTotalSubscriptions(String totalSubscriptions) {
        this.totalSubscriptions = totalSubscriptions;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
