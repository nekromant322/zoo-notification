package com.nekromant.notification.service.impl;

import com.nekromant.notification.service.EmailService;
import com.nekromant.notification.service.SMSCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private SMSCService smscService;

    public void sendEmail(String email, String emailSubject, String message) {
        emailService.sendEmail(email, emailSubject, message);
    }

    public void sendSms(String phoneNumber, String message) {
        smscService.sendSms(phoneNumber, message);
    }
}