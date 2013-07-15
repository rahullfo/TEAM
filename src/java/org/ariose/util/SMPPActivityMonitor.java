package org.ariose.util;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SMPPActivityMonitor implements CallerInterface{
	private static Log log = LogFactory.getLog(SMPPActivityMonitor.class);
	List receiverList;
	List senderList;
	
	
	/**
	 * @return the receiverList
	 */
	public List getReceiverList() {
		return receiverList;
	}

	/**
	 * @param receiverList the receiverList to set
	 */
	public void setReceiverList(List receiverList) {
		this.receiverList = receiverList;
	}

	/**
	 * @return the senderList
	 */
	public List getSenderList() {
		return senderList;
	}

	/**
	 * @param senderList the senderList to set
	 */
	public void setSenderList(List senderList) {
		this.senderList = senderList;
	}

	/**
	 * @param args
	 */
	public static void start(List senderList, List receiverList){
		try {
			log.warn("senderlist.."+senderList);
			log.warn("receiverList.."+senderList);			
			SMPPActivityMonitor obj = new SMPPActivityMonitor();
			obj.setSenderList(senderList);
			obj.setReceiverList(receiverList);
			
			ArioseTimerTask.runme(obj, Constants.TIME_TO_SHUT_DOWN);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
	}
	
	public void callback(){
		//iterate the list and set its boolean
		for (int i = 0; i < senderList.size(); i++) {
			SMPPSender sender = (SMPPSender) senderList.get(i);
			sender.setFlag();
		}
		
		for (int i = 0; i < receiverList.size(); i++) {
			SMPPAsyncReceiver receiver = (SMPPAsyncReceiver) receiverList.get(i);
			receiver.setFlag();			
		}
		
	}

}
