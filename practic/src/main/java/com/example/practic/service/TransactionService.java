package com.example.practic.service;

import com.example.practic.model.Account;
import com.example.practic.model.Transaction;
import com.example.practic.model.User;
import com.example.practic.repozitory.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {


    @Autowired
    UserService userService;
    @Autowired
    TransactionRepository transactionRepository;


    public List<Transaction>getTransactions(){
        User user=userService.getCurrentUser();
//         List<Transaction > transactions=transactionRepository.fuser.getAccounts().stream().map(Account::getId);
        return transactionRepository.findByFromAccountUserOrToAccountUserOrderByCreatedAtDesc(user,user);


    }

}
