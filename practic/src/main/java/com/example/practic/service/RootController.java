package com.example.practic.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RootController {


    @GetMapping("/")
    public String homePage(){
        return "transfer";
    }


}
