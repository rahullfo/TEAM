/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ariose.dao;

import java.util.List;
import org.ariose.model.BulkPackSms;

/**
 *
 * @author Sushil
 */
public interface BulkPackSmsDAO extends DAO {

    public void saveBulkPackSms(BulkPackSms bulkPackSmsBean);
    public List<BulkPackSms> getAllBulkPackSms();
    public BulkPackSms getBulkPackSmsById(int id);
    public void deleteBulkPackSms (BulkPackSms bulkPackSms);
    public List<BulkPackSms> getBulkPackSmsByUserId(String userId);
    public List<BulkPackSms> getBulkPackSmsBySendingStatus(int status);

    public List getSubscriberNumber(int circleID,int operatorID,int packID);
}
