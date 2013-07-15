package org.ariose.dao;

import java.util.List;

import org.ariose.model.ContentDeliveryLog;
import org.ariose.model.DocomoChargingGatewayResp;
import org.ariose.model.DocomoPrerenewalInfo;
import org.ariose.model.IdeaChargingGatewayResponseBean;
import org.ariose.model.RelianceSamResponse;
import org.ariose.model.SubsRequestLog;
import org.ariose.model.TransactionBean;
import org.ariose.model.UninorDeactivationBean;
import org.ariose.model.UninorRevenueBean;
import org.ariose.model.VMIChargingGatewayResp;
import org.ariose.model.VMIPrerenewalInfo;

/*
 * Stores the event/action occurred in the application  
 */

public interface EventLoggingDAO extends DAO {

	// stores in audit_log table
	public void saveAuditLog(String loginId, int moduleId, String moduleName,
			String eventDescription);

	public void saveSubsRequestLog(String operatorName, int operatorId,
			String circleName, int circleId, String packName, int packId,
			String subscriberNumber, String keyword, int channelId,
			String requestTime, String subscriptionStatus, String shortcode, String request);
        
	public void saveSubsRequestLog(String operatorName, int operatorId,
			String circleName, int circleId, String packName, int packId,
			String subscriberNumber, String keyword, int channelId,
			String requestTime, String subscriptionStatus, String shortcode, String request, String response, String subscriptionStatusMeaning);

	public List<SubsRequestLog> getSubsRequestLogs(long subsciberNo,int month);

        public List<TransactionBean> getTransactionLogs(long subsciberNo,int month);

        public List<TransactionBean> getTransactionLogs(long subsciberNo,int month,int operatorId);

        public List<ContentDeliveryLog> getContentDeliveryLog(long subsciberNo,int month);

        public List<ContentDeliveryLog> getCurrentDayContentDeliveryLog(int optrId,int circleId,int packId,String scheduleTime,int contentSchedulerId);
   
    	public long save(IdeaChargingGatewayResponseBean bean);

		public IdeaChargingGatewayResponseBean getIdeaChargingGatewayResponseBean(
				long ideaChargingGatewayResponseId);

		public void update(IdeaChargingGatewayResponseBean bean);


		public int saveIdeaTransaction(String circleName, int circleId,
				String packName, int packId, long mobileNo, String activationDate,
				int priceCharged, String chargingDate, String subscriptionStatus,
				String chargingStatus, String reason, String operatorName,
				int operatorId, String sms, String request, String response,
				int status); 


    	public long save(UninorRevenueBean bean);

    	public long save(UninorDeactivationBean bean);
    	
    	public void save(DocomoChargingGatewayResp docomoChargingGatewayResp);

    	public void save(DocomoPrerenewalInfo docomoPrerenewalInfo);
    	public void saveTransaction(String circleName, int circleId,
    			String packName, int packId, long mobileNo, String activationDate,
    			int priceCharged, String chargingDate, String subscriptionStatus,
    			String chargingStatus, String reason, String operatorName,
    			int operatorId, String sms, String request, String response, int status, String source, String renewDate);

		public void save(VMIChargingGatewayResp bean);

		public void save(VMIPrerenewalInfo bean);

		public void save(RelianceSamResponse relianceSamResponse);
}
