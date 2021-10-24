package com.nekromant.notification.service.impl;

import com.nekromant.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("prod")
public class EmailServiceImp implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public ResponseEntity<String> sendEmail(String emailReceiver, String emailSubject, String emailText) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailReceiver);
            message.setSubject(emailSubject);
            message.setText(emailText);

            mailSender.send(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Throwable e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не удалось отправить сообщение на email " + emailReceiver, e);
        }
    }
}