/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.model;

/**
 *
 * @author Sushil
 */
public class MonthlySummary extends BaseObject {

    private int operatorId;
    private long newSubscriptions;
    private long totalSubscriptions;
    private long totalCharging;
    private long totalContentsDelivered;

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public long getNewSubscriptions() {
        return newSubscriptions;
    }

    public void setNewSubscriptions(long newSubscriptions) {
        this.newSubscriptions = newSubscriptions;
    }

    public long getTotalCharging() {
        return totalCharging;
    }

    public void setTotalCharging(long totalCharging) {
        this.totalCharging = totalCharging;
    }

    public long getTotalContentsDelivered() {
        return totalContentsDelivered;
    }

    public void setTotalContentsDelivered(long totalContentsDelivered) {
        this.totalContentsDelivered = totalContentsDelivered;
    }

    public long getTotalSubscriptions() {
        return totalSubscriptions;
    }

    public void setTotalSubscriptions(long totalSubscriptions) {
        this.totalSubscriptions = totalSubscriptions;
    }

    
}
