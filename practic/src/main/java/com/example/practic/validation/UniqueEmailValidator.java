package com.example.practic.validation;

import com.example.practic.repozitory.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return true; // Если email null, пропускаем валидацию
        }
        // Проверяем, существует ли пользователь с таким email
        return userRepository.findByEmail(email) == null;
    }
}
