package com.springBank.service;

import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.model.Transaction;
import com.springBank.repository.AccountRepository;
import com.springBank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountRepository accountRepository;


    public Account withdraw(double amount , long accountId)throws ResourceNotFoundException {

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
    public Account deposit(double amount,long accountId)throws ResourceNotFoundException
    {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException(("Account not for this id::"+accountId)));
        double intialamount = account.getBalance();
        account.setBalance(amount+intialamount);
        return accountRepository.save(account);

    }
	public Transaction transact(Transaction transaction) throws ResourceNotFoundException {
		String type = transaction.getType();
		if(type.equals("withdraw")) {
			withdraw(transaction.getAmount(),transaction.getFromAccount());
		}
		else if(type.equals("deposit")) {
			deposit(transaction.getAmount(),transaction.getToAccount());
		}
		else if(type.equals("transfer")) {
			withdraw(transaction.getAmount(),transaction.getFromAccount());
			deposit(transaction.getAmount(),transaction.getToAccount());
		}
		return transactionRepository.save(transaction);
	}
    
}