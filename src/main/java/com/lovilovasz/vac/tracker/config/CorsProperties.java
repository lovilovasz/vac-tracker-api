package com.lovilovasz.vac.tracker.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsProperties {
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
}
