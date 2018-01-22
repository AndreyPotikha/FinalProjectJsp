package service.impl;

import service.EmailSenderService;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class EmailSenderServiceImpl implements EmailSenderService {

    private String smtpUser = "i.popolin@gmail.com";
    private String smtpPass = "Lifeplus1";
    public static int randomResetConfirm;

    @Override
    public void sendEmail(String email) {

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
            randomResetConfirm = random.nextInt(899) + 100;
            mimeMessage.setText(String.valueOf(randomResetConfirm));

            InternetAddress address = new InternetAddress(email);

            mimeMessage.addRecipients(javax.mail.Message.RecipientType.TO, String.valueOf(address));

            mimeMessage.setSentDate(new Date());

            transport.sendMessage(mimeMessage, mimeMessage.getRecipients(javax.mail.Message.RecipientType.TO));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
