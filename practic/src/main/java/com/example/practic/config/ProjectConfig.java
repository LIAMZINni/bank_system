package com.example.practic.config;

import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientCodecCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
//@EnableFeignClients(basePackageClasses = com.example.practic.model.PaymentProxy.class)
public class ProjectConfig {
    @Bean
    WebClient webClient(){
        return WebClient.builder().build();
    }

}
