package com.example.practic.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class PaymentProxy {
    private final WebClient webClient  ;
    @Value("name.service.url")
    private String url;
    public PaymentProxy(WebClient webClient) {
        this.webClient = webClient;
    }
    public Mono<Payment>  cratePayment(String id,Payment payment){
//        return webClient.post().uri("http://localhost:8080","/payment").header("id",id).body(Mono.just(payment),Payment.class).retrieve().bodyToMono(Payment.class);
//        return webClient.get().uri("http://localhost:8080/payment").header("id",id).retrieve().bodyToMono(Payment.class);
        return webClient.method(HttpMethod.GET).uri("http://localhost:8080/payment").header("id",id).body(Mono.just(payment),Payment.class).retrieve().bodyToMono(Payment.class);

    }
}
