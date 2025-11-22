package com.mycompany.webapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        log.info("===========================================");
        log.info("Application is ready and running!");
        log.info("Access the application at: http://localhost:8080");
        log.info("Health check: http://localhost:8080/health");
        log.info("===========================================");
    }
}