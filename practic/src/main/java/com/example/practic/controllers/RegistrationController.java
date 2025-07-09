package com.example.practic.controllers;

import com.example.practic.dto.RegistrationUserDto;
import com.example.practic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    UserService userService;






    @GetMapping
    public String showRegistrationUser(){
        return "reg/registration";

    }
    @ModelAttribute("user")
    public RegistrationUserDto registrationUserDto(){return new RegistrationUserDto();}
    @PostMapping
    public String registrationAccaunt(@Valid @ModelAttribute("user")  RegistrationUserDto registrationUser, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "reg/registration";
        }
        userService.saveUser(registrationUser);
        return "redirect:registration?success";

    }
}
