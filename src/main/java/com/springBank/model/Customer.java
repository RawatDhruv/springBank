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
	private long id;
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Customer() {};

	public Customer(long id, String name, String email, String phoneNo, String address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
		this.address = address;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId(){
		return id;
		}
	
	public void setId(long id){
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
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", address="
				+ address + "]";
	}
	

}
