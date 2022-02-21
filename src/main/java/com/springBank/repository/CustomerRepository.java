package com.springBank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.springBank.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
