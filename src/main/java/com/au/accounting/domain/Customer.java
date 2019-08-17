package com.au.accounting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "sequence",
        sequenceName = "CUSTOMER_SEQ",
        allocationSize = 1
)
public class Customer extends BaseEntity {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ISSUE_NUMBER")
    private String issueNumber;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @OneToOne(targetEntity = Account.class, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    private Account account;
}
