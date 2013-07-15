/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:ReportReceiver.java
 */

package org.ariose.model;

/**
 *
 * @author Naveen Kumar
 */
public class ReportReceiver {

    private int id;
    private int reportId;
    private String subscriberNumber;
    private String name;

    public String getSubscriberNumber() {
        return subscriberNumber;
    }

    public void setSubscriberNumber(String subscriberNumber) {
        this.subscriberNumber = subscriberNumber;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    
}
