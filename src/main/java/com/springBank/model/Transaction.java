package com.springBank.model;
import com.springBank.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountName;
    private String type;
    private BigDecimal balanceBefore;
    private BigDecimal balanceAfter;
//    private Double amount;

    @CreatedBy
    @Column(nullable = false, updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
    protected ZonedDateTime createdDatetime;


    public Transaction(String accountName, String type, BigDecimal balanceBefore, BigDecimal balanceAfter) {
        this.accountName = accountName;
        this.type = type;
        this.balanceBefore = balanceBefore;
        this.balanceAfter = balanceAfter;
    }

}
