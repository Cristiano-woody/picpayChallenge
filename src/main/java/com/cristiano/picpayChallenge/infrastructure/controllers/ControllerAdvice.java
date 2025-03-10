package com.cristiano.picpayChallenge.infrastructure.controllers;

import com.cristiano.picpayChallenge.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(DocumentAlreadyRegistered.class)
    public ResponseEntity<String> documentAlreadyRegistered(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Conflito: " + ex.getMessage());
    }

    @ExceptionHandler(EmailAlreadyRegistered.class)
    public ResponseEntity<String> emailAlreadyRegistered(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("Conflito: " + ex.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> insufficientBalanceException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(MerchantTransactionException.class)
    public ResponseEntity<String> merchantTransactionException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> resourceNotFound(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(TransactionRefusedException.class)
    public ResponseEntity<String> transactionRefusedException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body("Erro: " + ex.getMessage());
    }
}
