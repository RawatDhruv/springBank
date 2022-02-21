package com.springBank.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.service.TransactionService;
@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/depositmoney")
    public Account depositMoney(@RequestParam(value = "accountId") long accountId, @RequestParam("amount") double amount) throws ResourceNotFoundException {
        return transactionService.deposit(amount,accountId);
    }
    @PostMapping(value = "/withdrawmoney")
    public Account withdrawMoney(@RequestParam(value = "accountId") long accountId, @RequestParam("amount") double amount) throws ResourceNotFoundException {
        {
            return transactionService.withdawal(amount,accountId);
        }
}}

