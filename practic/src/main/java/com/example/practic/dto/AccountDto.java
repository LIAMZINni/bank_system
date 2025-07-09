package com.example.practic.dto;

import com.example.practic.model.Account;
import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String accountNumber;
    private String accountType;


    public AccountDto(Account account) {
        this.id = account.getId();
        this.accountNumber = account.getAccountNumber();

        this.accountType = account.getAccountType().getDisplayName();
    }
}

