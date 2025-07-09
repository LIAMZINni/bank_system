package com.example.practic.dto;

import com.example.practic.model.Account;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Getter
public class TransferDto {

    private Long senderAccountId; // ID счета отправителя
    private String receiverType;
    private Long receiverAccountId;

    private String receiverCardNumber; // Номер карты получателя
    private String receiverPhoneNumber; // Номер телефона получателя
    private BigDecimal amount; // Сумма перевода


    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;

    private LocalDateTime createdAt;
}
