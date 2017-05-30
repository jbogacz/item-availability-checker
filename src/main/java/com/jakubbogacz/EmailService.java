package com.jakubbogacz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by JBOGACZ on 30.05.2017.
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.recipients}")
    private String recipients;

    public void send(String subject, String text) throws MessagingException {
        MimeMessage mail = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail, true);
        helper.setFrom("item.availability.checker@gmail.com");
        helper.setTo(recipients.split(","));
        helper.setSubject(subject);
        helper.setText(text, true);
        javaMailSender.send(mail);
    }
}
