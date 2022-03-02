package com.springBank.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Accounts")
public class Account {


    private long id;
    @NotNull(message = "CustomerID is required.")
    private long customerId;

    private double balance;

    public Account() {
    }

    public Account(long id,@NotNull(message = "CustomerID is required.")long customerId,double balance) {
        this.id = id;
        this.customerId = customerId;
        this.balance = balance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    @Column(name = "customer_id", nullable = false)
    public long getCustomerId(){
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @Column(name = "balance", nullable = false)
    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

   
	
}
