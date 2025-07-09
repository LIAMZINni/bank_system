package com.example.practic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User user;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    @NotBlank(message = "Account number is required")
    @Column(unique = true)
    private String accountNumber;


    private String name;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;


    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Card> cards;

    public Account(String name, BigDecimal amount) {
        this.name = name;
        this.balance = amount;
    }

    public Account(long id, String name, BigDecimal amount) {
        this.id = id;
        this.name = name;
        this.balance = amount;
    }

    public Account(User user, String name, BigDecimal amount) {
        this.user = user;
        this.name = name;
        this.balance = amount;
    }
}
