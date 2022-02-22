package com.springBank.controller;
import com.fasterxml.jackson.databind.JsonSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.springBank.repository.AccountRepository;
import com.springBank.service.AccountService;
import com.springBank.model.Account;
import com.springBank.exception.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Transactional
public class AccountController {
	 
	    @Autowired
	    private AccountRepository accountRepository;
	    
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



}}
