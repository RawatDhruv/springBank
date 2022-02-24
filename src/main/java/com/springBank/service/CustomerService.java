package com.springBank.service;


import java.util.List;
import java.util.Optional;


import com.springBank.exception.ResourceNotFoundException;
import com.springBank.model.Account;
import com.springBank.model.Customer;


import com.springBank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public ResponseEntity<Customer> delete(long id)throws ResourceNotFoundException {

		Account account1 = new Account();
		Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("account" +id));
		Optional<Account> account = accountRepository.findById(account1.getCustomerId());
		if(!account.isPresent())
		{

			customerRepository.delete(customer);
			return ResponseEntity.ok().build();
		}
		return null;

	}


}
