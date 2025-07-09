package com.example.practic.model;

public enum CardType {
    DIBIT("Дебтовая"),
    CREDIT("Кредитная"),
    VIRTUAL("");
    private String displayName;

    CardType(String displayName) {
        this.displayName = displayName;
    }
}
