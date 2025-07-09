package com.example.practic.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Table;

import java.time.LocalDateTime;

@Entity
@Data
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @NotBlank(message = "Card number is required")
    @Column(unique = true)
    private String cardNumber;

    @NotBlank(message = "Card type is required")
    @Enumerated(EnumType.STRING)
    private CardType cardType; // e.g., debit, credit

    @NotBlank(message = "Expiry date is required")
    private String expiryDate;

    @NotBlank(message = "CVV is required")
    @Size(min = 3, max = 4, message = "CVV must be 3 or 4 digits")
    private String cvv;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters and Setters
}