/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:ReportScheduleDAO.java
 */

package org.ariose.dao;

import java.util.List;
import org.ariose.model.ReportSchedule;

/**
 *
 * @author Naveen Kumar
 */
public interface ReportScheduleDAO extends DAO{

    public List getReportSchedule();

    public List getReportReceiver();

    public List getRevenueForCurrentDay(String query);

    public String getQuery(int reportId);

    public List getValidSubscriberForReport(int reportId);

    public ReportSchedule getReportSchedule(int reportId);
    
}
