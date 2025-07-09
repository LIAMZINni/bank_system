package com.example.practic.controllers;

import com.example.practic.service.TransactionService;
import com.mysql.cj.xdevapi.Collection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    @Mock
    TransactionService transactionService;
    @Mock
    Model model;
    @InjectMocks
    TransactionController transactionController;

    @Test
    void showTransactions() {
        when(transactionService.getTransactions()).thenReturn(Collections.emptyList());
        String viewName=transactionController.showTransactions(model);
        assertEquals("transaction", viewName);
        verify(transactionService).getTransactions();
        verify(model).addAttribute("transactions", Collections.emptyList());
    }
}