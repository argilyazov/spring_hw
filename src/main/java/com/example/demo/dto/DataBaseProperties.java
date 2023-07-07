package com.example.demo.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "db")
@ConfigurationPropertiesScan
public class DataBaseProperties {
    private String url;
    private String username;
    private String password;
}
