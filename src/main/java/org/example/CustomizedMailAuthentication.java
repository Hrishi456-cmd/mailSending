package org.example;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class CustomizedMailAuthentication extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailMetaData.myUserMail, MailMetaData.password.toCharArray());
    }
}
