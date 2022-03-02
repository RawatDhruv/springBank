package com.springBank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId(){
		return id;
		}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "customer_name", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "Email_Id", nullable = false)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "Phone_No.", nullable = false)
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	@Column(name = "Address", nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	
	public Customer() {}

}
