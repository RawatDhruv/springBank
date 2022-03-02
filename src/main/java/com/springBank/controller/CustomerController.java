package com.springBank.controller;


import com.springBank.exception.ResourceNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.springBank.service.CustomerService;
import com.springBank.model.Customer;


import javax.validation.Valid;
import java.util.List;

@Validated
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
    public ResponseEntity createCustomer(@Valid @RequestBody Customer customer) {
        if((customer.getName() == null)||(customer.getAddress() == null) || (customer.getEmail() == null))
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing Customer Field");
         customerService.save(customer);
         return ResponseEntity.status(HttpStatus.CREATED).body("Customer id Created");
    }


    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable(value ="id" )  long id) throws ResourceNotFoundException {
        return customerService.delete(id);
    }


    


}
