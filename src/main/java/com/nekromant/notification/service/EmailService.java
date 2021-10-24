package com.nekromant.notification.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    ResponseEntity<String> sendEmail(String emailReceiver, String emailSubject, String emailText);
}
