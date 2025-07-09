package com.example.practic.controllers;

import com.example.practic.model.Account;
import com.example.practic.model.User;
import com.example.practic.service.AccountService;
import com.example.practic.service.TransactionService;
import com.example.practic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {


    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;


    @GetMapping ("/home")
    public String home(Model model){
        User user =userService.getCurrentUser();
        model.addAttribute("username",user.getFirstName()+" "+user.getLastName());
        model.addAttribute("total_balance",accountService.getTotalBalance());
        model.addAttribute("accounts",userService.getCurrentUser().getAccounts());
        model.addAttribute("transactions",transactionService.getTransactions());
        return "home.html";


    }





}
