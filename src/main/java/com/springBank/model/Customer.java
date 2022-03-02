package com.springBank.model;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.lang.String;

@Entity
@Table(name = "Customers")

public class Customer {
	private long id;
	@NotEmpty(message = "Name is required.")
	private String name;
	@NotEmpty(message = "Email is required.")
	private String email;
	@NotEmpty(message = "Phone No. is required.")
	private String phoneNo;
	@NotEmpty(message = "Address is required.")
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

	public Customer(long id, @NotEmpty(message = "Name is required.") String name,
					@NotEmpty(message = "Email is required.") String email,
					@NotEmpty(message = "Phone No. is required.") String phoneNo,
					@NotEmpty(message = "Address is required.") String address) {
		super();
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
