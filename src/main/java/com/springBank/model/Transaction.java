package com.springBank.model;
import com.springBank.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Entity
@Table(name = "Transactions")
public class Transaction {

    private Long id;
	private Long fromAccount;
	private Long toAccount;
    private String type;
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

	@CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    protected ZonedDateTime createdDatetime;

	public Transaction(Long id, Long fromAccount, Long toAccount, String type, Double amount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.type = type;
		this.amount = amount;
	}

	
}
