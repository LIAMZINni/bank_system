package com.example.practic.controllers;

import com.example.practic.dto.AccountDto;
import com.example.practic.dto.TransferDto;
import com.example.practic.error.FormFalidator;
import com.example.practic.model.Account;
import com.example.practic.model.User;
import com.example.practic.repozitory.AccountRepository;
import com.example.practic.repozitory.UserRepository;
import com.example.practic.service.transfer.TransferByCardService;
import com.example.practic.service.transfer.TransferService;


import com.example.practic.service.UserService;
import com.example.practic.service.transfer.TransferServiceFabric;
import jakarta.validation.Valid;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller


public class TransferController {
//    @Autowired
//    AccountRepository accountRepository;
//
//    @Autowired
//    FormFalidator formFalidator;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    TransferByCardService transferByCardService;
//
//    @ModelAttribute("user")
//    public User loadCurrentUser() {
//
//        return userService.getCurrentUser();
//        // Всегда возвращает текущего пользователя
//    }
//
//    @GetMapping("/transfer")
//    public String showTransferForm(Model model) {
//        // Получаем текущего пользователя
//
//        User user = userService.getCurrentUser();
//         if (user == null) {
//            throw new RuntimeException("Пользователь не найден");
//        }
//
//        // Передаем список счетов пользователя в модель
//        model.addAttribute("user", user);
//        model.addAttribute("message", "");
//        return "transfer";
//    }
//    @Autowired
//    TransferServiceFabric transferServiceFabric;
//
//
//    @PostMapping ("/transfer")
//    public String transferMoney(Model model, @Valid @ModelAttribute TransferDto transferDto){
//        try {
//            TransferService transferService=transferServiceFabric.getTransferService(transferDto.getReceiverType());
//            transferService.transfer(transferDto);
//            model.addAttribute("message", "Перевод выполнен успешно!");
//            return "redirect:/transfer/success";
//        } catch (RuntimeException e) {
//            model.addAttribute("message", "Ошибка: " + e.getMessage());
//        }
//        return "transfer";
//
////        TransferService transferService=transferServiceFabric.getTransferService(transferDto.getReceiverType());
////        transferService.transfer(transferDto);
////        model.addAttribute("messege","sucsess");
////
////        return "transfer";
//    }
//
//@GetMapping("/find-accounts")
//@ResponseBody
//public ResponseEntity<?> findReceiverAccounts(
//        @RequestParam String receiverPhoneNumber
//) {
//    User receiverUser = userRepository.findByPhoneNumber(receiverPhoneNumber);
//    if (receiverUser == null) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Collections.singletonMap("error", "Пользователь не найден"));
//    }
//
//    List<AccountDto> accounts = receiverUser.getAccounts().stream()
//            .map(account -> new AccountDto(account)) // Исправленная строка
//            .collect(Collectors.toList());
//
//    return ResponseEntity.ok(Collections.singletonMap("accounts", accounts));
//}
//
//
//
//
//    @GetMapping("/transfer/success")
//    public String showTransferSuccess() {
//        return "transfer-success"; // Имя шаблона Thymeleaf (transfer-success.html)
//    }


@Autowired
private UserService userService;

@Autowired
private TransferServiceFabric transferServiceFabric;

@Autowired
private UserRepository userRepository;

@ModelAttribute("user")
public User loadCurrentUser() {
    return userService.getCurrentUser();
}

@GetMapping("/transfer")
public String showTransferForm(Model model) {
    model.addAttribute("message", "");
    return "transfer";
}

@PostMapping("/transfer")
public String transferMoney(Model model, @Valid @ModelAttribute TransferDto transferDto) {
    try {
        TransferService transferService = transferServiceFabric.getTransferService(transferDto.getReceiverType());
        transferService.transfer(transferDto);
        return "redirect:/transfer/success";
    } catch (RuntimeException e) {
        model.addAttribute("message", "Ошибка: " + e.getMessage());
        model.addAttribute("user", userService.getCurrentUser());
        return "transfer";
    }
}

@GetMapping("/find-accounts")
@ResponseBody
public ResponseEntity<?> findReceiverAccounts(
        @RequestParam String receiverPhoneNumber
) {
    User receiverUser = userRepository.findByPhoneNumber(receiverPhoneNumber);
    if (receiverUser == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("error", "Пользователь не найден"));
    }

    Hibernate.initialize(receiverUser.getAccounts());

    List<AccountDto> accounts = receiverUser.getAccounts().stream()
            .map(AccountDto::new)
            .collect(Collectors.toList());

    return ResponseEntity.ok(Collections.singletonMap("accounts", accounts));
}

@GetMapping("/transfer/success")
public String showTransferSuccess() {
    return "transfer-success";
}
}





