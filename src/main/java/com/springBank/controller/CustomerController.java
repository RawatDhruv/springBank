package com.springBank.controller;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springBank.repository.CustomerRepository;
import com.springBank.service.CustomerService;
import com.springBank.model.Customer;
import com.springBank.exception.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@Transactional
public class CustomerController {
	
	@Autowired
	public CustomerService customerService;
	
	@GetMapping("/customers")
    public List<Customer> customerRepository() {
		
		return (List<Customer>) customerService.findAll();
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable(value = "id") final Long customerId) {
    	
        return customerService.getCustomerbyId(customerId);
    }

    @PostMapping("/addcustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        
        return customerService.save(customer);
    }

}
