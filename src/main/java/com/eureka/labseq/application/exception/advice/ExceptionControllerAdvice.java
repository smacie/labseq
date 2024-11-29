package com.eureka.labseq.application.exception.advice;

import com.eureka.labseq.application.exception.NegativeIndexException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NegativeIndexException.class)
    public ResponseEntity<String> handleNegativeIndexException(NegativeIndexException ex){
        String message = String.format("Index %s is invalid. Index can not be negative.", ex.getIndex());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }
}
