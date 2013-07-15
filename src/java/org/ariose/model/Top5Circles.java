/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.model;

/**
 *
 * @author Sushil
 */
public class Top5Circles extends BaseObject {

    private String id;
    private int operatorId;
    private String circleId;
    private String counts;
    private String circleName;

    public String getCircleId() {
        return circleId;
    }

    public void setCircleId(String circleId) {
        this.circleId = circleId;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getCounts() {
        return counts;
    }

    public void setCounts(String counts) {
        this.counts = counts;
    }

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
}
