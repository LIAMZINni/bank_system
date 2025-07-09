package com.example.practic.service;

import com.example.practic.model.Account;
import com.example.practic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    UserService userService;

    public Account getCurrentAccount(){
        User user =userService.getCurrentUser();
        return  user.getAccounts().get(0);
    }
    public List<Account> getAccounts(){
        return userService.getCurrentUser().getAccounts();

    }
    public BigDecimal getTotalBalance(){
       return userService.getCurrentUser().getAccounts()
                .stream().map(Account::getBalance).reduce(BigDecimal.ZERO,BigDecimal::add);

    }
}
