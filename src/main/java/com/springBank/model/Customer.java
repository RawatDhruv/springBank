package com.springBank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")

public class Customer {
	private int id;
	private String name;
	
	public Customer() {}
	
	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
		}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId(){
		return id;
		}
	
	public void setId(int id){
		this.id = id;
		}
	
	@Column(name = "customer_name", nullable = false)
	public String getName(){
	        return name;
	    }
	
	public void setName(String name) {
	        this.name = name;
	        }

	@Override
	public String toString() {
		return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
	}
	

}
