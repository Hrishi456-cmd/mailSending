package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {

     void sendMail()

    {
       Properties sysProperties =  System.getProperties();

        System.out.println(sysProperties);

        sysProperties.put("mail.smtp.host",MailMetaData.HostServer);
        sysProperties.put("mail.smtp.port",MailMetaData.port);
        sysProperties.put(MailMetaData.sslProperty,"true");
        sysProperties.put(MailMetaData.authPerm,"true");

          CustomizedMailAuthentication mailAuthenticator = new CustomizedMailAuthentication();
        Session mailSession =  Session.getInstance(sysProperties,mailAuthenticator);

        MimeMessage mailMessage = new MimeMessage(mailSession);

        try {
            Address sender = new InternetAddress(MailMetaData.myUserMail);
            mailMessage.setFrom(sender);
            mailMessage.setSubject("this is my java code testing");
            mailMessage.setText("Hey..This is Hrishi");

            Address receiverEmail = new InternetAddress(MailMetaData.receiverMail);
            mailMessage.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(MailMetaData.receiverMail)));

            Transport.send(mailMessage);
        }
        catch (Exception mailException)
        {
            System.out.println(mailException.toString());

        }
    }

}
