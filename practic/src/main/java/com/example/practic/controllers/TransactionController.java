package com.example.practic.controllers;

import com.example.practic.model.Transaction;
import com.example.practic.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @GetMapping("/transactions")
    public String showTransactions(Model model){
        model.addAttribute("transactions",transactionService.getTransactions());
        return "transaction";


    }
}
