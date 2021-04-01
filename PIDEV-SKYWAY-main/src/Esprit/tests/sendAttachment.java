/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esprit.tests;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

class SendAttachment{
 public static void main(String [] args){

  String to="smart.kindergarten0@gmail.com";//change accordingly
  final String user="nour.helali@esprit.tn";//change accordingly
  final String password="181JFT075899";//change accordingly
 
  //1) get the session object   
  Properties properties = System.getProperties();
  properties.setProperty("mail.smtp.host", "mail.javatpoint.com");//change accordingly
  properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", "smtp.googlemail.com");
        properties.put("mail.smtp.port", "587");
        properties.setProperty("mail.pop3.disabletop", "true");
        properties.put("mail.pop3.ssl.enable", "true");
      
        properties.put("mail.smtp.starttls.enable", "true");

  Session session = Session.getDefaultInstance(properties,
   new javax.mail.Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
   return new PasswordAuthentication(user,password);
   }
  });
   
  //2) compose message   
  try{
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress(user));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Message Aleart");
    
    //3) create MimeBodyPart object and set your message content    
    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaooo");
    
    //4) create new MimeBodyPart object and set DataHandler object to this object    
    MimeBodyPart messageBodyPart2 = new MimeBodyPart();
String url="C:/Users/Lenovo/Desktop/PIDEV_R/NourPartCrudCombo/n/src/Esprit/tools/sendAttachment.java";
    String filename = url;//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);
   
   
    //5) create Multipart object and add MimeBodyPart objects to this object    
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);

    //6) set the multiplart object to the message object
    message.setContent(multipart );
   
    //7) send message
    Transport.send(message);
 
   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}