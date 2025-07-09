package com.example.practic.validation;

import com.example.practic.validation.UniqueEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // Аннотация применяется к полям
@Retention(RetentionPolicy.RUNTIME) // Аннотация доступна в runtime
@Constraint(validatedBy = UniqueEmailValidator.class) // Указываем класс-валидатор
public @interface UniqueEmail {
    String message() default "Email already exists"; // Сообщение об ошибке

    Class<?>[] groups() default {}; // Группы валидации

    Class<? extends Payload>[] payload() default {}; // Полезная нагрузка
}