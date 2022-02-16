package com.springBank.service;

import com.springBank.Exception.Resourcenotfound;
import com.springBank.model.Customer;
import com.springBank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private UserRepository userRepository;
    public CustomerService createUser(long id, String name)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        return  userRepository.save(customer);

    }
    public  Customer updatename(long id,String name) throws Exception {
        Customer account = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Resource not found"));
        account.setName(name);
        Customer account1 = userRepository.save(account);
        return account1;

    }
    public ResponseEntity<?> delete(long id,String name) throws Exception {
        Customer account = userRepository.findById(id)
                .orElseThrow(()-> new Exception("Resource not found"));

        userRepository.delete(account);
        return ResponseEntity.ok().build();
    }

}
