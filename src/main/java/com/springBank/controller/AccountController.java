package com.springBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import javax.validation.Valid;

import com.springBank.service.AccountService;
import com.springBank.model.Account;
import com.springBank.exception.*;

@Validated
@RestController
public class AccountController {
	    
	    @Autowired
	    private AccountService accountService;

	    
	    @GetMapping("/accounts")
	    public List<Account> getAllAccounts() {
	        return (List<Account>) accountService.getAllAccounts();
	    }

	    @GetMapping("/account/{id}")
	    public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") final Long accountId) throws ResourceNotFoundException {
	    	
	    	return accountService.getAccountById(accountId);
	    }

	    @PostMapping("/addAccount")
	    public ResponseEntity createAccount(@Valid @RequestBody Account newAccount) {	        
	        return accountService.createAccount(newAccount);
	    }
	    
	    @DeleteMapping(value = "/deleteAccount/{id}")
		public ResponseEntity<Account> deleteAccount(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
	    	return accountService.deleteAccount(accountId);
	    }



}
