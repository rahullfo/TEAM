/*
 * and open the template in the editor.
 */
package org.ariose.sms;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.util.ApplicationException;
import org.ariose.util.Constants;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

/**
 * 
 * @author Manu Parmar Dec 2011 For HARIOM MEDIA
 */
public class IdeaSubscriptionController extends MultiActionController {

	private static Log log = LogFactory
			.getLog(IdeaSubscriptionController.class);
	private IdeaSubscriptionManager subscriptionManager = null;

	public void setSubscriptionManager(
			IdeaSubscriptionManager subscriptionManager) {
		this.subscriptionManager = subscriptionManager;
	}

	public void sendSMSToIdeaUser(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long startTime = System.currentTimeMillis();
		String data = (String) request.getSession(true).getAttribute("host");
		log.info("Host - " + data);
		log.info("QueryString - " + request.getQueryString());

		String responseString = "0,success";

		try {
			String requestUrl = request.getQueryString();
			String sid = request.getParameter("SID");
			String sms = request.getParameter("SMS");
			subscriptionManager.sendSMSToIdeaUser(requestUrl, sid, sms);
		} catch (ApplicationException ex) {
			responseString = "1,failure," + ex.getId() + "," + ex.getMessage();
		} finally {
			//response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.write(responseString);
			try {
				out.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		log.error("Request[" + request.getQueryString() + "] Response["
				+ responseString + "], Time ["
				+ (System.currentTimeMillis() - startTime) + "]");
	}

}
