package com.springBank.model;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import java.util.Date;


@Entity
@Table(name = "Transactions")
public class Transaction {

    private Long id;
	private Long fromAccount;
	private Long toAccount;
    private String type;
    @NonNull
    private double amount;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
		return id;
	}
    public void setId(long id){
        this.id = id;
    }

    @Column(name = "from_Account")
	public Long getFromAccount() {
		return fromAccount;
	}

  
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}

	@Column(name = "to_Account")
	public Long getToAccount() {
		return toAccount;
	}

    
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

 
	@Column(name = "amount", nullable = false)
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
	private Date time;

	@PrePersist
	private void onCreate()
	{
		time = new Date();
		}
	
	public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

	public Transaction(Long id, Long fromAccount, Long toAccount, String type, Double amount, Date time) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.type = type;
        this.amount = amount;
        this.time= time;
    }
	
}
