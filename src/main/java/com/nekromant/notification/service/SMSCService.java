package com.nekromant.notification.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SMSCService {
    /**
     * Отправка SMS на список номеров
     *
     * @param phones  - список телефонов
     * @param message - отправляемое сообщение
     */
    ResponseEntity<String> sendSms(List<String> phones, String message);

    /**
     * Отправка SMS на один номер
     *
     * @param phone   - номер телефона(в формате +7...)
     * @param message - отправляемое сообщение
     * @return array (<id>, <количество sms>, <стоимость>, <баланс>) в случае успешной отправки
     * или массив (<id>, -<код ошибки>) в случае ошибки
     */
    ResponseEntity<String> sendSms(String phone, String message);
}
