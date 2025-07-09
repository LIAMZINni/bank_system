package com.example.practic.model;

public enum AccountType {
    CURRENT_ACCOUNT("Текущий счет"),       // Текущий счет
    SAVINGS_ACCOUNT("Сберегательный счет"), // Сберегательный счет
    CREDIT_ACCOUNT("Кредитный счет"),      // Кредитный счет
    DEPOSIT_ACCOUNT("Депозитный счет");    // Депозитный счет

    private final String displayName; // Название для отображения

    AccountType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
