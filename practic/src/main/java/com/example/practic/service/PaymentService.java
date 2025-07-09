package com.example.practic.service;

import com.example.practic.error.NotEnoughMoneyException;
import com.example.practic.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
