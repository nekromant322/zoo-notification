package com.nekromant.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
        "classpath:application-dev.yml"
})
public class ZooNotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZooNotificationApplication.class, args);
    }
}
