package com.springBank.service; 

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBank.exception.*;
import com.springBank.model.Account;
import com.springBank.repository.AccountRepository;


@Service
@Transactional
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	public ResponseEntity<Account> getAccountById(Long accountId) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + accountId));
        return ResponseEntity.ok().body(account);
	}

	public Account createAccount(Account newAccount) {
		List<Account> accounts = accountRepository.findAll();
        List<Account> customerAccounts = accounts.stream().filter(account1 -> account1.getCustomerId() == newAccount.getCustomerId()).collect(Collectors.toList());
        if (customerAccounts.size()>=3) {
            System.out.println("More than 3 accounts found for customerID " + newAccount.getCustomerId());
            return null;
        }
        return accountRepository.save(newAccount);
	}

	public ResponseEntity<Account> deleteAccount(Long accountId) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException("account" +accountId));
		accountRepository.delete(account);
		return ResponseEntity.ok().build();
	}
	public ResponseEntity<Account> deleteAccount(Long accountId)throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account" +accountId));

		accountRepository.delete(account);
		return ResponseEntity.ok().build();
	}
	
	
}
