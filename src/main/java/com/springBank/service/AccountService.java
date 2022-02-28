package com.springBank.service; 

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.springBank.model.Customer;
import com.springBank.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	@Autowired
	private CustomerRepository customerRepository;

	public List<Account> getAllAccounts() {
		return (List<Account>) accountRepository.findAll();
	}

	public ResponseEntity<Account> getAccountById(Long accountId) throws ResourceNotFoundException {
		Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + accountId));
        return ResponseEntity.ok().body(account);
	}

	public ResponseEntity createAccount(Account newAccount) {
		Optional<Customer> customer = customerRepository.findById(newAccount.getCustomerId());
		if(!customer.isPresent()) {
			System.out.println("No Customer Found");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No id customer id");
		}
		List<Account> accounts = accountRepository.findAll();
		List<Account> customerAccounts = accounts.stream().filter(account1 -> account1.getCustomerId() == newAccount.getCustomerId()).collect(Collectors.toList());
		if (customerAccounts.size()>=3) {
			System.out.println("More than 3 accounts found for customerID " + newAccount.getCustomerId());
			return ResponseEntity.status(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED).body("More than 3 accounts found for customerID ");
		}
		 accountRepository.save(newAccount);
		return ResponseEntity.status(HttpStatus.CREATED).body("Account Created Successfully");
	}


	public ResponseEntity deleteAccount(Long accountId)throws ResourceNotFoundException {
		accountRepository.deleteById(accountId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account Deleted ");
	}
	
	
}
