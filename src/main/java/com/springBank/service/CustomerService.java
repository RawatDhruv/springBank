package com.springBank.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.model.Customer;


import com.springBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Customer;

import com.springBank.repository.CustomerRepository;



@Service
@Transactional
public class CustomerService {
	
	@Autowired
   CustomerRepository customerRepository;
	@Autowired
	AccountRepository accountRepository;
	
	public void addCustomer(Customer customer) {
		
	}

	public Customer save(Customer customer) {		
		return customerRepository.save(customer);
	}

	public ResponseEntity<Customer> getCustomerbyId(Long customerId) {
		Optional<Customer> optionalUser = customerRepository.findById(customerId);
        Customer customer;
        if (optionalUser.isPresent()) {
            customer = optionalUser.get();
            return ResponseEntity.ok().body(customer);
        }
        return null;
	}

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	public ResponseEntity  delete(long id)throws ResourceNotFoundException {

		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("account" +id));
		List<Account> accounts = accountRepository.findAll();
		List<Account> customerAccounts = accounts.stream().filter(account1 -> account1.getCustomerId() == id).collect(Collectors.toList());
		if (customerAccounts.size()>0) {
			System.out.println("Accounts found for customerID " + id);
			return null;
		}
		customerRepository.delete(customer);
		return ResponseEntity.ok().body("Customer deleted");

	}


}
