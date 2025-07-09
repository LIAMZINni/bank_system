package com.example.practic.controllers;

import com.example.practic.model.Payment;
import com.example.practic.model.PaymentProxy;
import com.example.practic.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    private static Logger logger=Logger.getLogger(PaymentController.class.getName());
    @Autowired
    private  PaymentProxy paymentProxy;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }



    @GetMapping("/payment")
    public Mono<Payment> makePay(@RequestBody Payment payment,@RequestHeader(required = false) String id
            ){

        logger.info("id="+payment.getId()+"amount   "+payment.getAmount());
             id=UUID.randomUUID().toString();
            return paymentProxy.cratePayment("543",payment);




    }
}
