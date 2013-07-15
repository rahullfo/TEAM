package org.ariose.util;

import java.net.InetAddress;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ariose.model.User;

/**
 * 
 * @author Abdul Rahman
 */

public class SendReportEmailExec {
	private static Log log = LogFactory.getLog(SendReportEmailExec.class);

	public void execute(User user, String cfgEmailUserName,
			String cfgEmailPassword, String cfgEmailPopServer,
			String cfgEmailSmtpServer, String cfgEmailPopPort,
			String cfgEmailSmtpPort, String generatedPwd) throws Exception {

		// log.info("called..   generatedPwd   "+generatedPwd);
		String to = user.getUser_email();
		String server = cfgEmailSmtpServer;
		String from = cfgEmailUserName;
		String subject = "New password confirmation for Cortex Adminstrator.";
		String userName = cfgEmailUserName;
		// String password=user.getUser_password();
		String password = cfgEmailPassword;

		// System.out.println("to.........."+to);
		// System.out.println("subject.........."+subject);
		// System.out.println("server.........."+server);
		// System.out.println("from............"+from);
		// System.out.println("username.........."+userName);
		// System.out.println("password.........."+password);
		// System.out.println("user.getUser_password().........."+user.getUser_password());
		// System.out.println("cfgEmailSmtpPort.........."+cfgEmailSmtpPort);

		String msg = "Welcome, " + user.getUser_name() + "\n\n"
				+ "Your password is " + generatedPwd + "\n\n"
				+ "In order to login, your password has been reset."
				+ "\nRegards,\nCortex Team." + "\n\n\n\n"
				+ "Powered by - Ariose Software Pvt. Ltd.";

		SendEmail client = new SendEmail();
		client.SendMail(server, from, to, subject, msg, userName, password,
				cfgEmailSmtpPort);
		log.info("A mail has been sent");

	}

	public void sendMail(String to, String cfgEmailUserName,
			String cfgEmailPassword, String cfgEmailPopServer,
			String cfgEmailSmtpServer, String cfgEmailPopPort,
			String cfgEmailSmtpPort, String generatedPwd, String subject, String msg) throws Exception {

		log.info("called..");
		String server = cfgEmailSmtpServer;
		String from = cfgEmailUserName;
		
		InetAddress thisIp =InetAddress.getLocalHost();
		log.info("IP:"+thisIp.getHostAddress());
		
		String userName = cfgEmailUserName;
		String password = cfgEmailPassword;

		SendEmail client = new SendEmail();
		client.SendMail(server, from, to, subject, msg, userName, password,
				cfgEmailSmtpPort);
		log.info("A mail has been sent");
	}
}
