package com.springBank.service;

import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.model.Transaction;
import com.springBank.repository.AccountRepository;
import com.springBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;

	public ResponseEntity withdraw(Transaction transaction) throws ResourceNotFoundException {
		 Account account = accountRepository.findById(transaction.getFromAccount())
	                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + transaction.getFromAccount()));
	        double initialBalance = account.getBalance();
	        if (transaction.getAmount() > initialBalance) {
	            System.out.println("Withdrawal amount exceeded");
	            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Insufficient Balance");
	        }
	        account.setBalance(initialBalance - transaction.getAmount());
	        accountRepository.save(account);
	        transaction.setType("withdraw");
	        transactionRepository.save(transaction);
	        return ResponseEntity.ok().body("Withdrawl Successfull");	
	}

	public ResponseEntity<Transaction> deposit(Transaction transaction) throws ResourceNotFoundException {
		 Account account = accountRepository.findById(transaction.getToAccount()).orElseThrow(() -> new ResourceNotFoundException(("Account not for this id::"+transaction.getToAccount())));
	        double intialamount = account.getBalance();
	        account.setBalance(transaction.getAmount()+intialamount);
	        accountRepository.save(account);
	        transaction.setType("deposit");
	        transactionRepository.save(transaction);
	        System.out.println("inside deposit");
	        return ResponseEntity.ok().build();
	}

	public ResponseEntity transfer(Transaction transaction) throws ResourceNotFoundException {
		Account account1 = accountRepository.findById(transaction.getFromAccount())
                .orElseThrow(() -> new ResourceNotFoundException("Account not for for this id :: " + transaction.getFromAccount()));
        double initialBalance = account1.getBalance();
        if (transaction.getAmount() > initialBalance) {
            System.out.println("Withdrawal amount exceeded");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Insufficient Balance");
        }
        account1.setBalance(initialBalance - transaction.getAmount());
        accountRepository.save(account1);
        Account account2 = accountRepository.findById(transaction.getToAccount()).orElseThrow(() -> new ResourceNotFoundException(("Account not for this id::"+transaction.getToAccount())));
        double intialamount = account2.getBalance();
        account2.setBalance(transaction.getAmount()+intialamount);
        accountRepository.save(account2);
        transaction.setType("transfer");
        transactionRepository.save(transaction);
        return ResponseEntity.ok().body("Transfer Successful");
	}
}