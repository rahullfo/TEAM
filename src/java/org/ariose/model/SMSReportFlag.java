/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:SMSReportFlag.java
 */

package org.ariose.model;

/**
 *
 * @author Naveen Kumar
 */
public class SMSReportFlag {

    private int id;
    private String userId;
    private String smsFlag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSmsFlag() {
        return smsFlag;
    }

    public void setSmsFlag(String smsFlag) {
        this.smsFlag = smsFlag;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    

}
