package com.springBank.controller;

import com.springBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.model.Transaction;

@RestController
public class TransactionController {
	
    @Autowired
    TransactionService transactionService;
    
    @PostMapping(value="/transaction")
    public Transaction transact(@RequestBody Transaction transaction) throws ResourceNotFoundException {
    	
    	return transactionService.transact(transaction);
    	
    }
    
}

