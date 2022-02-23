package com.springBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import com.springBank.service.AccountService;
import com.springBank.model.Account;
import com.springBank.exception.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

	    @PostMapping("/addaccount")
	    public Account createAccount(@RequestBody Account newAccount) {	        
	        return accountService.createAccount(newAccount);
	    }
	    
	    @DeleteMapping(value = "/deleteaccount/{id}")
		public ResponseEntity<Account> deleteAccount(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
	    	return accountService.deleteAccount(accountId);
	    }


	   @DeleteMapping(value = "/deleteaccount/{id}")
	   public ResponseEntity<Account> deleteAccount(@PathVariable(value = "id") Long accountId) throws ResourceNotFoundException {
		 return accountService.deleteAccount(accountId);



}}
