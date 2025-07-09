package com.example.practic.controllers;

import com.example.practic.model.Product;
import com.example.practic.model.User;
import com.example.practic.service.AccountService;
import com.example.practic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;
    @PostMapping("/")
    public String home(Model model){
        User user =userService.getCurrentUser();
        model.addAttribute("username",user.getFirstName()+" "+user.getLastName());
        model.addAttribute("total_balance",accountService.getTotalBalance());
        model.addAttribute("accounts",userService.getCurrentUser().getAccounts());
        return "home.html";


    }
}
