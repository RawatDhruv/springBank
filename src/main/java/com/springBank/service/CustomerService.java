package com.springBank.service;


import java.util.List;
import java.util.Optional;



import com.springBank.model.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.springBank.model.Customer;
import com.springBank.repository.CustomerRepository;



@Service
public class CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
	
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



}
