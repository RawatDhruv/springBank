package com.springBank.model;
import com.springBank.*;
import org.hibernate.internal.util.ZonedDateTimeComparator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "Transactions")
public class Transaction {

    private Long id;
    private Long fromAccount;
    private Long toAccount;
    private String type;
    private double amount;

    public Transaction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(nullable = false)
    private Date Time;

    @PrePersist
    private void onCreate()
    {
        Time = new Date();
    }

    public Date getUpadtedtime() {
        return Time;
    }

    public void setUpadtedtime(Date Time) {
        Time = Time;
    }

    public Transaction(Long id, Long fromAccount, Long toAccount, String type, Double amount, Date Time) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.type = type;
        this.amount = amount;
        this.Time= Time;
    }



}
