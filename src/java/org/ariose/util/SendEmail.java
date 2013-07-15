package org.ariose.util;

import java.security.Security;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 * 
 * @author Abdul Rahman
 */
public class SendEmail {

	private static Log log = LogFactory.getLog(SendEmail.class);

	public SendEmail() {

	}

	public void SendMail(String mailServer, String from, String to,
			String subject, String messageBody, String userName,
			String password, String cfgEmailSmtpPort)
			throws MessagingException, AddressException {
		try {

			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			Properties props = System.getProperties();

			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", mailServer);
			props.put("username", userName);
			props.put("password", password);
			props.put("mail.debug", "false");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", cfgEmailSmtpPort);
			props.put("mail.smtp.socketFactory.port", cfgEmailSmtpPort);
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.socketFactory.fallback", "false");
			Authenticator auth = new MailAuthenticator(userName, password);
			Session session = Session.getDefaultInstance(props, auth);

			//session.setDebug(false);

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			String[] emailId = to.split(";");
			InternetAddress[] toAddr = new InternetAddress[emailId.length];
			for (int i = 0; i < emailId.length; i++) {
				toAddr[i] = new InternetAddress(emailId[i]);
			}

			message.setRecipients(Message.RecipientType.TO, toAddr);
			message.setSubject(subject);
                        
//                    String filename = "c:\\abc.txt";    
//                    BodyPart messageBodyPart = new MimeBodyPart();
//                    messageBodyPart.setText(messageBody);
//                    Multipart multipart = new MimeMultipart();
//                    multipart.addBodyPart(messageBodyPart);
//                    messageBodyPart = new MimeBodyPart();
//                    DataSource source = new FileDataSource(filename);
//                    messageBodyPart.setDataHandler(new DataHandler(source));
//                    messageBodyPart.setFileName(filename);
//                    multipart.addBodyPart(messageBodyPart);
//                    message.setContent(multipart);


		      message.setContent(messageBody, "text/plain");
			Transport.send(message);
		} catch (Exception e) {
			log.error("Mail could not be sent to user:"+ to, e.fillInStackTrace());
			//e.printStackTrace();
		}

	}
}

class MailAuthenticator extends javax.mail.Authenticator {
	private String user;
	private String pwd;

	public MailAuthenticator(String usr, String pwd) {
		this.user = usr;
		this.pwd = pwd;
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, pwd);
	}
}