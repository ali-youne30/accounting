package com.au.accounting.domain;


import com.au.accounting.dto.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "sequence",
        sequenceName = "TRANSACTION_SEQ",
        allocationSize = 1
)
public class Transaction extends BaseEntity {

    @Enumerated
    @Column(name = "TRANSACTION_TYPE")
    private TransactionType transactionType;

    @Column(name = "AMOUNT")
    private Long amount;

    @ManyToOne(targetEntity = Account.class, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private Account account;
}
