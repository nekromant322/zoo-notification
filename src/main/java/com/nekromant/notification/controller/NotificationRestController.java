package com.nekromant.notification.controller;

import com.nekromant.notification.service.impl.NotificationService;
import dto.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class NotificationRestController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("sendEmail")
    public void sendEmail(@RequestBody NotificationDTO notificationDTO) {
        notificationService.sendEmail(notificationDTO.getReceiver(), notificationDTO.getSubject(), notificationDTO.getMessage());
    }

    @PostMapping("sendSms")
    public void sendSms(@RequestBody NotificationDTO notificationDTO) {
        notificationService.sendSms(notificationDTO.getReceiver(), notificationDTO.getMessage());
    }
}
