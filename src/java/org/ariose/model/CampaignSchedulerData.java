/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:CampaignSchedulerData.java
 */

package org.ariose.model;

import java.util.Date;

/**
 *
 * @author Naveen Kumar
 */
public class CampaignSchedulerData {

    private int id;
    private String campaignName;
    private String campaignMode;
    private Date startDate;
    private Date endDate;
    private String messageStr;
    private String fileName;
    private int status;
    private String userId;
    private int stopFlag;

    public int getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(int stopFlag) {
        this.stopFlag = stopFlag;
    }

    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCampaignMode() {
        return campaignMode;
    }

    public void setCampaignMode(String campaignMode) {
        this.campaignMode = campaignMode;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

   
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageStr() {
        return messageStr;
    }

    public void setMessageStr(String messageStr) {
        this.messageStr = messageStr;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    

    
}
