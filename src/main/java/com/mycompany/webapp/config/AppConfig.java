package com.mycompany.webapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String name = "Web Application";
    private String version = "1.0.0";
    private String environment = "production";
}