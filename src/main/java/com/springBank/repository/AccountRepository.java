package com.springBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springBank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
