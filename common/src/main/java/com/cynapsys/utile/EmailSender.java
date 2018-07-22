package com.cynapsys.utile;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {

	private final static String ACCOUT_USER = "cynapsys.gat@gmail.com";
	private final static String ACCOUT_PASSWORD = "cynapsysgat";
	
	public static void sendEmail(String objet, String msg,String sender ,String destinaire) {
		
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.user", ACCOUT_USER);
		prop.setProperty("mail.from", ACCOUT_USER);
		
		prop.setProperty("mail.smtp.starttls.enable", "true");

		
		Session session = Session.getInstance(prop);
		
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			
			message.setSubject(objet);
			message.setText("Sender : "+sender+"\nMessage : "+msg);
			message.addRecipients(Message.RecipientType.TO, destinaire);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			
			Transport transport = session.getTransport("smtp");
			transport.connect(ACCOUT_USER, ACCOUT_PASSWORD);
			transport.sendMessage(message, new Address[] {new InternetAddress(destinaire)});
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void sendEmail(String objet, String msg,String destinaire) {
		
		Properties prop = new Properties();
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.host", "smtp.gmail.com");
		prop.setProperty("mail.smtp.user", ACCOUT_USER);
		prop.setProperty("mail.from", ACCOUT_USER);
		
		prop.setProperty("mail.smtp.starttls.enable", "true");

		
		Session session = Session.getInstance(prop);
		
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			
			message.setSubject(objet);
			message.setText(msg);
			message.addRecipients(Message.RecipientType.TO, destinaire);
			
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			
			Transport transport = session.getTransport("smtp");
			transport.connect(ACCOUT_USER, ACCOUT_PASSWORD);
			transport.sendMessage(message, new Address[] {new InternetAddress(destinaire)});
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
}
