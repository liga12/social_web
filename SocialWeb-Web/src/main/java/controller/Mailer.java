package controller;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

public class Mailer {

    private static final String smtpHost = "mail.smtp.host";
    private static final String smtpSocketFactoryPort = "mail.smtp.socketFactory.port";
    private static final String smtpSocketFactoryClass = "mail.smtp.socketFactory.class";
    private static final String smtpAuth = "mail.smtp.auth";
    private static final String smtpPort = "mail.smtp.port";

    public void send(String to, String URLLogcalhost) {
        final ResourcesBandler bandler = new ResourcesBandler();
        //Get properties object
        Properties props = new Properties();
        props.put(smtpHost, bandler.getResourcesEmail(smtpHost));
        props.put(smtpSocketFactoryPort, bandler.getResourcesEmail(smtpSocketFactoryPort));
        props.put(smtpSocketFactoryClass, bandler.getResourcesEmail(smtpSocketFactoryClass));
        props.put(smtpAuth, bandler.getResourcesEmail(smtpAuth));
        props.put(smtpPort, bandler.getResourcesEmail(smtpPort));
        //get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(bandler.getResourcesEmail("from"),
                                bandler.getResourcesEmail("password"));
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(bandler.getResourcesEmail("from")));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setSubject(bandler.getResourcesEmail("sub"));

            MimeMultipart mp = new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            HtmlToString htmltoString = new HtmlToString();
            String str = htmltoString.getEmailStringHtml();
            String htmlString = MessageFormat.format(str, URLLogcalhost);

            messageBodyPart.setContent(htmlString, "text/html; charset=utf-8");
            mp.addBodyPart(messageBodyPart);

            InputStream resourceAsStream = HtmlToString.class.getClassLoader()
                    .getResourceAsStream("images.jpg");
            DataHandler dataHandler = new DataHandler(new InputStreamDataSource(resourceAsStream, "t"));

            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setDataHandler(dataHandler);
            messageBodyPart.setHeader("Content-ID", "<image>");
            mp.addBodyPart(messageBodyPart);

            message.setContent(mp);
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}  
  

