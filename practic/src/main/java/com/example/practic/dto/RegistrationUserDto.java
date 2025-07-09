package com.example.practic.dto;

import com.example.practic.validation.UniqueEmail;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistrationUserDto {

    private String username;
    @NotNull
    @Size(min = 4, max = 16, message = "Пароль должен быть от 4 до 16 символов")
    private String password;

    @NotBlank(message = "cant be null")
    private String firstName;

    @NotBlank(message = "cant be null")
    private String lastName;

    @Email
    @Column(name = "email", unique = true)
    @UniqueEmail
    private String email;

    @NotBlank(message = "cant be 0")
    @Size(min = 10,max = 11,message = "error")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number is invalid")
    private String phoneNumber;
}
