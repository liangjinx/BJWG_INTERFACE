package com.mobile.blue.util;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class SendEmailUtil {

	private static Log emailLog = LogFactory.getLog("SEND_EMAIL_LOG");

	public SendEmailUtil(String emailHost, String emailAddressFrom) {
		super();
		this.emailHost = emailHost;
		this.emailAddressFrom = emailAddressFrom;
	}

	private String emailHost;

	private String emailAddressFrom;

	public String getEmailHost() {
		return emailHost;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public String getEmailAddressFrom() {
		return emailAddressFrom;
	}

	public void setEmailAddressFrom(String emailAddressFrom) {
		this.emailAddressFrom = emailAddressFrom;
	}

	public boolean sendEmail(String emailTo, String title, String content, String attachFileName, String cc, String bcc)
			throws Exception {
		String token = UUID.randomUUID().toString();
		emailLog.info("[" + token + "]:----------------->Send email start...... file name :" + attachFileName);
		try {

			int local = 2;

			Properties prop = new Properties();
			Session mailSession = null;
			switch (local) {
			case 1:
				// Authenticator auth = new AjavaAuthenticator();
				// prop.put("mail.smtp.host", "smtp.gmail.com");
				// prop.put("mail.smtp.auth", "true");
				// prop.put("mail.smtp.port", "465");
				// prop.put("mail.smtp.timeout", "20000");
				// mailSession = Session.getDefaultInstance(prop,auth);
				break;
			case 2:
				prop.put("mail.smtp.host", emailHost);
				prop.put("mail.smtp.auth", "true");
				prop.put("mail.smtp.timeout", "20000");
				prop.put("mail.smtp.localhost", "localHostAdress");
				mailSession = Session.getDefaultInstance(prop);
				break;
			}

			emailLog.info("[" + token + "]:Start send email.");

			Message message = new MimeMessage(mailSession);
			message.setFrom(new InternetAddress(emailAddressFrom));

			String tos[] = { "" };
			if (emailTo.indexOf(",") != -1) {
				tos = emailTo.split(",");
			} else {
				tos[0] = emailTo;
			}
			InternetAddress[] addressTo = new InternetAddress[tos.length];
			for (int i = 0; i < tos.length; i++) {
				addressTo[i] = new InternetAddress(tos[i]);
			}

			// cc
			if (!StringUtils.isBlank(cc)) {
				String ccTos[] = { "" };
				if (cc.indexOf(",") != -1) {
					ccTos = cc.split(",");
				} else {
					ccTos[0] = cc;
				}
				InternetAddress[] ccAddressTo = new InternetAddress[ccTos.length];
				for (int j = 0; j < ccTos.length; j++) {
					ccAddressTo[j] = new InternetAddress(ccTos[j]);
				}

				message.addRecipients(Message.RecipientType.CC, ccAddressTo);
			}

			// bcc
			if (!StringUtils.isBlank(bcc)) {
				String bccTos[] = { "" };
				if (bcc.indexOf(",") != -1) {
					bccTos = bcc.split(",");
				} else {
					bccTos[0] = bcc;
				}
				InternetAddress[] bccAddressTo = new InternetAddress[bccTos.length];
				for (int j = 0; j < bccTos.length; j++) {
					bccAddressTo[j] = new InternetAddress(bccTos[j]);
				}

				message.addRecipients(Message.RecipientType.BCC, bccAddressTo);
			}

			message.addRecipients(Message.RecipientType.TO, addressTo);
			message.setSubject(title);

			message.setSentDate(new Date());
			MimeMultipart msgMultipart = new MimeMultipart("mixed");
			message.setContent(msgMultipart);
			MimeBodyPart htmlPart = new MimeBodyPart();

			htmlPart.setContent(content, "text/html;charset=utf-8");
			msgMultipart.addBodyPart(htmlPart);

			if (attachFileName != null && !attachFileName.equals("")) {
				MimeBodyPart file = new MimeBodyPart();
				FileDataSource file_datasource = new FileDataSource(attachFileName);
				DataHandler dh = new DataHandler(file_datasource);
				file.setDataHandler(dh);
				file.setFileName(MimeUtility.encodeText(dh.getName()));
				msgMultipart.addBodyPart(file);
			}

			message.saveChanges();

			if (local == 1) {
				Transport transport = mailSession.getTransport("smtp");
				transport.connect("smtp.gmail.com", "cp.test.zh@gmail.com", "007007");
				transport.send(message);
				transport.close();
			} else {
				Transport transport = mailSession.getTransport("smtp");
				transport.connect(emailHost, 25, "no-reply", "abcd_1234");
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			}

			emailLog.info("[" + token + "]:The mail to " + emailTo + " has been sent at "
					+ (new java.util.Date()).toString());
			emailLog.info("[" + token + "]:----------------->Send email succeed, file name :" + attachFileName);
			return true;
		} catch (Exception e) {
			emailLog.error("[" + token + "]:" + e);
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		String mail_head_name = "this is head of this mail";
		String mail_to = "490182713@qq.com";
		String mail_body = "this is mail_body of this test mail";
		String cc = "";
		String bcc = "";

		SendEmailUtil emailUtil = new SendEmailUtil("mail.infinitus-int.com", "no-reply@iheha.com");
		emailUtil.sendEmail(mail_to, mail_head_name, mail_body, "", cc, bcc);
	}
}
