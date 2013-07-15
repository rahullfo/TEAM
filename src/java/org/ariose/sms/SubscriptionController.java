/*
 * and open the template in the editor.
 */
package org.ariose.sms;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.SubscriptionBean;
import org.ariose.util.ApplicationException;
import org.ariose.util.Constants;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 
 * @author Manu Parmar Dec 2011 For HARIOM MEDIA
 */
public class SubscriptionController extends MultiActionController {

	private static Log log = LogFactory.getLog(SubscriptionController.class);
	private SubscriptionManager subscriptionManager = null;

	
	public void setSubscriptionManager(
			SubscriptionManager subscriptionManager) {
		this.subscriptionManager = subscriptionManager;
	}

	// NotifyType=Subscribe
	public void SendSMS(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		//http://localhost:8080/cmsportal/RelianceSubscription.html?NotifyType=SendSMS&SID=9845909256&SMS=Hi&SENDERID=UW-655551&SMSCKEY=reliance_notif_smsc&NEEDVALIDATION=false	
		String data = (String) request.getSession(true).getAttribute("host");
		// //log.info("host - " + data);
	
		String responseString = "200";
	
		try {
			String requestUrl = request.getQueryString();
			String sid = request.getParameter("SID");
			String sms = request.getParameter("SMS");
			String shortcode = request.getParameter("SENDERID");
			String smsckey = request.getParameter("SMSCKEY");
			String needValidation = request.getParameter("NEEDVALIDATION");
			if(needValidation==null){
				needValidation = "false" ;
			}
			subscriptionManager.SendSMS(requestUrl, sid, sms,shortcode,smsckey,needValidation);
	
			responseString = "200, SUCCESS";
	
		} catch (ApplicationException ex) {
			responseString = ex.getId() + "," + ex.getMessage();
			// log.error(responseString);
		} catch (Exception e) {
			responseString = Constants.STATUS_EXCEPTION + "," + e;
			// log.error(responseString);
		}
	
		log.error("Request[" + request.getQueryString() + "] Response["
				+ responseString + "]");
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// //log.info("ended..." + responseString);
		out.write(responseString);
	}

}
