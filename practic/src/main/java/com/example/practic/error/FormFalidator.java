package com.example.practic.error;

import com.example.practic.repozitory.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class FormFalidator {
    @Autowired
    AccountRepository accountRepository ;





    public String formValidator(long senderId, long receiverId, BigDecimal amount){
        String result=" ";

        if(Objects.isNull(senderId)||Objects.isNull(receiverId)|| amount.equals("")){
            result+="данные не ввведены ";
        }

        boolean senderEmptyResult=accountRepository.existsById(senderId);

        if(senderId==receiverId){
            result+="Вы не можете отправить деньги самому себе ";
        }



        boolean resiverEmptyResult=accountRepository.existsById(receiverId);
        if(senderEmptyResult==false||resiverEmptyResult==false){
            result+="Не верный id пользователя ";
        }
        else {
            BigDecimal senderBalance = accountRepository.findById(senderId).get().getBalance();
            if (accountRepository.findById(senderId).get().getBalance().intValue()-amount.intValue()<0) {
                result += "  not money bratan ";

            }
        }

        String message=null;
        message=result;
        System.out.println(message);

        return result;
    }
}
