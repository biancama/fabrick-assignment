package com.fabrick.assignment.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@TestConfiguration
@Slf4j
public class AppTestConfig {
    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return
            builder
                .errorHandler(new RestResponseErrorHandler())
                .setConnectTimeout(3000)
                .setReadTimeout(3000)
                .build();
    }

}
