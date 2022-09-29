package Tests;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.eclipse.jetty.server.Authentication;




public class Email {
	

	public static void main(String[] args)throws MessagingException {
		
		System.out.println("preparing to send message...");
		String message = "Hello, Dear, this is message for security check.";
		String subject = "CodeArea : Confirmation";
		String to = "raut8234@gmail.com";
		String from = "dsanity6@gmail.com";
		
		sendEmail(message.subject,to,from);
		
			
	}
	
	// this is responsible to send email...
	private static void sendEmail(String message, String subject, String to, String from) {
		
		//Variable for email
		String host = "smtp.gmail.com";
		
		
		//get the system properties
		
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		//setting important information to properties object
		
		//host set
		
		properties.put("mail.smtp.host", host);
		properties.put("mail.smpt.port","465");
		properties.put("mail.smpt.ssl.enable","true");
		properties.put("mail.smpt.auth","true");
		
		//step 1: to get the session object...
		
		Session session = Session.getInstance(properties, null);
		
		session.setDebug(true);
		
		//step 2: compose the message [text,multimedia]
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			
			//from email
			
			m.setFrom(from);
			
			//adding recipient to message
			
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding subject to message
			
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//Step 3: send the message using transport class
			Transport.send(m);
			
			
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("Message sent successfully...");
			
	
		}
	}
}
