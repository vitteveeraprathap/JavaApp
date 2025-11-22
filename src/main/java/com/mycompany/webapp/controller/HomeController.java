package com.mycompany.webapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class HomeController {

    @Value("${app.name:Web Application}")
    private String appName;

    @Value("${app.version:1.0.0}")
    private String appVersion;

    @GetMapping("/")
    public Map<String, String> home() {
        log.info("Home endpoint accessed");
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to " + appName + "!");
        response.put("status", "running");
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        log.info("Health check endpoint accessed");
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("application", appName);
        response.put("version", appVersion);
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return response;
    }

    @GetMapping("/info")
    public Map<String, Object> info() {
        log.info("Info endpoint accessed");
        Map<String, Object> response = new HashMap<>();
        response.put("application", appName);
        response.put("version", appVersion);
        response.put("description", "Spring Boot application deployed on Azure");
        response.put("java_version", System.getProperty("java.version"));
        response.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("home", "/");
        endpoints.put("health", "/health");
        endpoints.put("info", "/info");
        response.put("available_endpoints", endpoints);
        
        return response;
    }
}