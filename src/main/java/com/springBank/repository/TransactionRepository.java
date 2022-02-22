package com.springBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springBank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
