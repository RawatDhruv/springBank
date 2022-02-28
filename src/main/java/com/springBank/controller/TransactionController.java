package com.springBank.controller;

import com.springBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Transaction;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/withdraw")
    public ResponseEntity<Transaction> withdraw(@RequestBody Transaction transaction) throws ResourceNotFoundException {
        return transactionService.withdraw(transaction);

    }

    @PostMapping(value = "/deposit")
    public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) throws ResourceNotFoundException {
        return transactionService.deposit(transaction);

    }

    @PostMapping(value = "/transfer")
    public ResponseEntity<Transaction> transfer(@RequestBody Transaction transaction) throws ResourceNotFoundException {
        return transactionService.transfer(transaction);

    }
}
