package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> expHandler(RuntimeException exp){
        return status(HttpStatus.BAD_GATEWAY).body(exp.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationHandler(MethodArgumentNotValidException exp){
        var errors = exp.getBindingResult();
        var fieldMessageError = new HashMap<String,String>();
        for(var error:errors.getFieldErrors()){
            fieldMessageError.put(error.getField(),error.getDefaultMessage());
        }
        return new ResponseEntity(fieldMessageError, HttpStatus.BAD_REQUEST);
    }
}
