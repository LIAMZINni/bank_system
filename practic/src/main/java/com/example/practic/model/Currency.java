package com.example.practic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum Currency {



    USD("US Dollar", "$"),
    EUR("Euro", "€"),
    GBP("British Pound", "£"),
    JPY("Japanese Yen", "¥"),
    RUB("Russian Ruble", "₽");

    private final String displayName;
    private final String symbol;



}
