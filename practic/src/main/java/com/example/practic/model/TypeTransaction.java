package com.example.practic.model;

import lombok.Data;


public enum TypeTransaction {
    BY_CARD("Перевод с карты"),
    BY_PHONE_NUMBER("Перевод на телефон"),
    BETWEEN_OWN_ACCOUNTS("Между своими счетами ");

    public final String displayName;

    TypeTransaction(String displayName) {
        this.displayName = displayName;
    }
}
