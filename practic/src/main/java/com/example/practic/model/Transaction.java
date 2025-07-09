package com.example.practic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long transactionId;

  @ManyToOne
  @JoinColumn(name = "from_account_id", nullable = false)
  private Account fromAccount;

  @ManyToOne
  @JoinColumn(name = "to_account_id", nullable = false)
  private Account toAccount;


  @Enumerated(EnumType.STRING)
  private TypeTransaction transactionType; // e.g., deposit, withdrawal, transfer

  @Positive(message = "Amount must be positive")
  private BigDecimal amount;

  @Enumerated(EnumType.STRING)
  private Currency currency;



  @Size(max = 255, message = "Description must be less than 255 characters")
  private String description;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Timestamp createdAt;

  public Transaction(Account fromAccount, Account toAccount, TypeTransaction transactionType, BigDecimal amount, Currency currency, String description) {
    this.fromAccount = fromAccount;
    this.toAccount = toAccount;
    this.transactionType = transactionType;
    this.amount = amount;
    this.currency = currency;
    this.description = description;

  }



}

