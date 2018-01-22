package service.impl;

import model.Admin;
import service.EmailSenderAdminService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class EmailSenderAdminServiceImpl implements EmailSenderAdminService {

    private String smtpUser = "i.popolin@gmail.com";
    private String smtpPass = "Lifeplus1";
    public static int randomConfirm;


    public void sendEmail(Admin admin) {


        try {
            Properties properties = new Properties();

            properties.put("mail.transport.protocol", "smtps");
            properties.put("mail.smtps.host", smtpPass);
            properties.put("mail.smtps.auth", "true");

            Session session = Session.getDefaultInstance(properties);

            Transport transport = session.getTransport();
            transport.connect("smtp.gmail.com", 465, smtpUser, smtpPass);

            MimeMessage mimeMessage = new MimeMessage(session);

            mimeMessage.setSubject("Confirm the registration");
            Random random = new Random();
            randomConfirm = random.nextInt(899) + 100;
            mimeMessage.setText(String.valueOf(randomConfirm));

            InternetAddress address = new InternetAddress(admin.getEmail());

            mimeMessage.addRecipients(javax.mail.Message.RecipientType.TO, String.valueOf(address));

            mimeMessage.setSentDate(new Date());

            transport.sendMessage(mimeMessage, mimeMessage.getRecipients(javax.mail.Message.RecipientType.TO));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}