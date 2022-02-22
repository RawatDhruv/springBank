package com.springBank.repository;

import com.springBank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springBank.model.Customer;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
