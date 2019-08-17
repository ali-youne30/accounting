package com.au.accounting.domain;


import com.au.accounting.dto.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "sequence",
        sequenceName = "ACCOUNT_SEQ",
        allocationSize = 1
)
public class Account extends BaseEntity {

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Enumerated()
    @Column(name = "ACCOUNT_TYPE")
    private AccountType accountType;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "BALANCE")
    private Long balance;

    @OneToOne(targetEntity = Customer.class, optional = false, mappedBy = "account")
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transaction;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
