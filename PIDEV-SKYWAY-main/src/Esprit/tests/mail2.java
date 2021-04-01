/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.tests;

//package com.roytuts.java.bulk.email.send;

import Esprit.gui.GagnantPromotionController;
import Esprit.services.partenaireCRUD;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class mail2 {
 
	public static void sendBulkEmail(final String subject, final List<String> emailToAddresses,
			final String emailBodyText,String linkAttachtest) {
  
   List<String> type;
 String img="";
  String x="";
type =new ArrayList();
type.add("*.jpg");
type.add("*.png");
 type.add("*.*");
 
 GagnantPromotionController attach = new GagnantPromotionController(); 
//String linkAttach =attach.attachMail2();
//String linkAttachtest = attach.linkAttachtest;
            System.out.println("\n \n hevaaaaa essem el path "+ linkAttachtest);
//String linkAttach =attach.attachMail(ActionEvent event);
// System.out.println(linkAttach);
            System.out.println(linkAttachtest +" belfaza \n");
		// from email address
final String username = "nour.helali@esprit.tn";

		// make sure you put your correct password
final String password = "181JFT075899";

		// smtp email server
final String smtpHost = "smtp.googlemail.com";

  Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.port", "587");

		// we authentcate using your email and password and on successful
		// we create the session
		Session session = Session.getInstance( properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String emails = null;

		try {
			// we create new message
Message message = new MimeMessage(session);

			// set the from 'email address'
			message.setFrom(new InternetAddress(username));

			// set email subject
			message.setSubject(subject);


    BodyPart messageBodyPart1 = new MimeBodyPart();

   MimeBodyPart messageBodyPart2 = new MimeBodyPart();

   
   //        String filename = linkAttach;;
   
String filename = linkAttachtest;
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);

    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
 
 
			String contentPart1 = "<html>\n<body>\n";
			contentPart1 += emailBodyText + "\n";
			contentPart1 += "\n";
			contentPart1 += "</body>\n</html>";
                        	
 
                        messageBodyPart1.setContent(contentPart1, "text/html");


     multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
			// form all emails in a comma separated string
			StringBuilder sb = new StringBuilder();

			int i = 0;
			for (String email : emailToAddresses) {
				sb.append(email);
				i++;
				if (emailToAddresses.size() > i) {
					sb.append(", ");
				}
			}

			emails = sb.toString();
 
 
			// you can set also CC or TO for recipient type
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sb.toString()));

			System.out.println("Sending Email to " + emails + " from " + username + " with Subject - " + subject);
//message.setContent(multipart );

 //System.out.println(linkAttach);
			// send the email
			Transport.send(message);

			System.out.println("Email successfully sent to " + emails);
		} catch (MessagingException e) {
			System.out.println("Email sending failed to " + emails);
			System.out.println(e);
		}
	}
public static void sendBulkEmail2 (final String subject, final List<String> emailToAddresses,
			final String emailBodyText) {
  // from email address
		final String username = "nour.helali@esprit.tn";

		// make sure you put your correct password
		final String password = "181JFT075899";

		// smtp email server
		final String smtpHost = "smtp.googlemail.com";

		// We will put some properties for smtp configurations
		//Properties props = new Properties();

		// do not change - start
		//props.put("mail.smtp.user", "username");
		//props.put("mail.smtp.host", smtpHost);
		// props.put("mail.debug", "true");
		//props.put("mail.smtp.auth", "true");
		// do not change - end
  Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.port", "587");

		// we authentcate using your email and password and on successful
		// we create the session
		Session session = Session.getInstance( properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		String emails = null;

		try {
			// we create new message
			Message message = new MimeMessage(session);

			// set the from 'email address'
			message.setFrom(new InternetAddress(username));

			// set email subject
			message.setSubject(subject);

			// set email message
			// this will send html mail to the intended recipients
			// if you do not want to send html mail then you do not need to wrap the message
			// inside html tags
			String content = "<html>\n<body>\n";
			content += emailBodyText + "\n";
			content += "\n";
			content += "</body>\n</html>";
			message.setContent(content, "text/html");

			// form all emails in a comma separated string
			StringBuilder sb = new StringBuilder();

			int i = 0;
			for (String email : emailToAddresses) {
				sb.append(email);
				i++;
				if (emailToAddresses.size() > i) {
					sb.append(", ");
				}
			}

			emails = sb.toString();

			// set 'to email address'
			// you can set also CC or TO for recipient type
			message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(sb.toString()));

			System.out.println("Sending Email to " + emails + " from " + username + " with Subject - " + subject);

			// send the email
			Transport.send(message);

			System.out.println("Email successfully sent to " + emails);
		} catch (MessagingException e) {
			System.out.println("Email sending failed to " + emails);
			System.out.println(e);
		}
	}




}