/*
 * Copyright (c) 2007 Ariose Software Pvt. All rights reserved.
 * File name:CampaignSchedulerDAO.java
 */

package org.ariose.dao;

import java.util.List;
import org.ariose.model.CampaignSchedulerData;

/**
 *
 * @author Naveen Kumar
 */
public interface CampaignSchedulerDAO extends DAO{

    public CampaignSchedulerData getCampaignSchedulerData(String campName) ;

    public List getAllCampaignSchedulerDataList();

    public List getAllCampaignSchedulerListByUser(String userId);

    public List getAllCampaignSchedulerByStatus(int status);

    public void deleteCampaignData(int id);

    public void saveCampaignScheduler(CampaignSchedulerData csd);

    public CampaignSchedulerData getCampaignSchedulerByID(int campID) ;

}
