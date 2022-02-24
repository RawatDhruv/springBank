package com.springBank.controller;


import com.springBank.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springBank.service.CustomerService;
import com.springBank.model.Customer;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PostMapping("/addCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        
        return customerService.save(customer);
    }


    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(value ="id" )  long id) throws ResourceNotFoundException {
        return customerService.delete(id);
    }


    


}
