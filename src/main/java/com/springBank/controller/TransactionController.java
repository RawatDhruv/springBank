package com.springBank.controller;
import com.springBank.model.Transaction;
import com.springBank.service.TransactionService;
import java.time.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBank.exception.ResourceNotFoundException;


@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/transactions")
    public Transaction transact(@RequestBody Transaction transaction)throws ResourceNotFoundException
    {
        return transactionService.transact(transaction);
}

    }

