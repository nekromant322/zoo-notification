package com.nekromant.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String emailReceiver, String emailSubject, String emailText) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailReceiver);
            message.setSubject(emailSubject);
            message.setText(emailText);

            mailSender.send(message);
        } catch (Throwable e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не удалось отправить сообщение на email " + emailReceiver, e);
        }
    }
}