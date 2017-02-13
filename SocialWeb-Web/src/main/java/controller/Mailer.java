package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {
  public void send(String to) {
    //Get properties object
    Properties props = new Properties();
    final ResourceBundle emailResources = ResourceBundle.getBundle("Email");
    props.put("mail.smtp.host", emailResources.getString("mail.smtp.host"));
    props.put("mail.smtp.socketFactory.port",
        emailResources.getString("mail.smtp.socketFactory.port"));
    props.put("mail.smtp.socketFactory.class",
        emailResources.getString("mail.smtp.socketFactory.class"));
    props.put("mail.smtp.auth", emailResources.getString("mail.smtp.auth"));
    props.put("mail.smtp.port", emailResources.getString("mail.smtp.port"));
    //get Session
    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(emailResources.getString("from"),
                emailResources.getString("password"));
          }
        });
    //compose message
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailResources.getString("from")));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject(emailResources.getString("sub"), "UTF-8");
//      message.setText(msg);
//      message.setContent(msg, "text/html; charset=utf-8");
//      send message
      MimeBodyPart part = new MimeBodyPart();
      part.attachFile("pom.xml");
      MimeBodyPart part2 = new MimeBodyPart();
      part2.setContent(getEmailStringHtml(), "text/html; charset=utf-8");
      MimeMultipart mp = new MimeMultipart();
      mp.addBodyPart(part);
      mp.addBodyPart(part2);
      message.setContent(mp);

      Transport.send(message);
      System.out.println("message sent successfully");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String getEmailStringHtml() {
    String stringHtml = null;
    BufferedReader in;
    String string;
    StringBuffer stringBuffer = null;
    try {
      in = new BufferedReader(new FileReader("SocialWeb-Web/src/main/webapp/emailHtml.html"));
      stringBuffer = new StringBuffer();
      while ((string = in.readLine()) != null) {
        stringBuffer.append(string + "\n");
      }
      stringHtml = stringBuffer.toString();
      System.out.println(stringHtml);
      in.close();
    } catch (FileNotFoundException ex) {
      System.out.println(ex);
    } catch (IOException ex) {
      System.out.println(ex);
    }
    return stringHtml;
  }
}  
  

