package com.example.practic.model;

import jakarta.persistence.*;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;



import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class TransferReqvest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idTransfer;

    @ManyToOne
    @JoinColumn(name = "from_account_id", nullable = false)
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id", nullable = false)
    private Account toAccount;

    @Positive(message = "Amount must be positive")
    private double amount;

    @NotBlank(message = "Currency is required")
    private String currency;

    private LocalDateTime transferDate;

    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    private LocalDateTime createdAt;
}
