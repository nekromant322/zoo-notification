package com.nekromant.notification.service.mock;

import com.nekromant.notification.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Profile("dev")
@Slf4j
public class EmailServiceMock implements EmailService {
    @Override
    public ResponseEntity<String> sendEmail(String emailReceiver, String emailSubject, String emailText) {
        // Проверка на возврат ошибки
        if (true) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Не удалось отправить рассылку на email " + emailReceiver);
        }
        log.info("Сообщение с текстом:'{}' и темой: '{}' было успешно отправлено на email {}", emailText, emailSubject, emailReceiver);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
