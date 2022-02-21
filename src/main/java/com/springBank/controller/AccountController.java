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

	    @PostMapping(value = "/depositmoney")
	    public Account depositMoney(@RequestParam(value = "accountId") long accountId, @RequestParam("amount") double amount) throws ResourceNotFoundException {
	        Account account = accountRepository.findById(accountId)
	                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + accountId));
	        double initialBalance = account.getBalance();
	        account.setBalance(initialBalance+amount);
	        return accountRepository.save(account);
	    }

	    @PostMapping(value = "/withdrawmoney")
	    public Account withdrawMoney(@RequestParam(value = "accountId") long accountId, @RequestParam("amount") double amount) throws ResourceNotFoundException {
	        Account account = accountRepository.findById(accountId)
	                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + accountId));
	        double initialBalance = account.getBalance();
	        if (amount > initialBalance) {
	            System.out.println("Withdrawal amount exceeded");
	            return null;
	        }
	        account.setBalance(initialBalance-amount);
	        return accountRepository.save(account);
	    }


}
