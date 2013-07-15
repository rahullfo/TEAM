/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:ReportSchedule.java
 */

package org.ariose.model;


/**
 *
 * @author Naveen Kumar
 */
public class ReportSchedule extends BaseObject{

    private int reportId;
    private String reportName;
    private String query;
    private int startTime;
    private int endTime;
    private int interval;
    private String smsString;

    public String getSmsString() {
        return smsString;
    }

    public void setSmsString(String smsString) {
        this.smsString = smsString;
    }

    

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

   

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

}
