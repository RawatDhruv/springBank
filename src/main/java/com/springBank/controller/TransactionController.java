package com.springBank.controller;
import com.springBank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @PostMapping(value="/withdraw")
    public ResponseEntity withdraw(@RequestBody Transaction transaction) throws ResourceNotFoundException{
        if(transaction.getFromAccount() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing FromAccount Field");
        return transactionService.withdraw(transaction);

    }

    @PostMapping(value="/deposit")
    public ResponseEntity deposit(@RequestBody Transaction transaction) throws ResourceNotFoundException{
        if(transaction.getToAccount() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing ToAccount Field");
        return transactionService.deposit(transaction);

    }

    @PostMapping(value="/transfer")
    public ResponseEntity transfer(@RequestBody Transaction transaction) throws ResourceNotFoundException{
        if(transaction.getFromAccount() == null || transaction.getToAccount() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing Account Field");
        return transactionService.transfer(transaction);

    }


}
