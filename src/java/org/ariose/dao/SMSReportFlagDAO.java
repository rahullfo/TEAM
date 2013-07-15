/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:SMSReportFlagDAO.java
 */

package org.ariose.dao;

import org.ariose.model.SMSReportFlag;

/**
 *
 * @author Naveen Kumar
 */
public interface SMSReportFlagDAO extends DAO{

    public void saveSMSReportFlag(SMSReportFlag reportFlag);

    public boolean isUserInfoExist(String userId);

    public SMSReportFlag getSMSReportFlag(String userId);

}
