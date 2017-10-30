package com.travix.medusa.busyflights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceAccessConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
