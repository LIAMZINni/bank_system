package com.example.practic.error;

import com.example.practic.error.ErrorDetails;
import com.example.practic.error.NotEnoughMoneyException;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> errorDetailsResponseEntity(){
        ErrorDetails errorDetails= new ErrorDetails();
        errorDetails.setMessage("no money bratan");
        return ResponseEntity.badRequest().body(errorDetails);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity responseResponseEntity(Exception e){
        e.printStackTrace();
        return ResponseEntity.badRequest().body("eror");


    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
