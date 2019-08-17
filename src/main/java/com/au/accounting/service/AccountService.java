package com.au.accounting.service;

import com.au.accounting.domain.Account;
import com.au.accounting.dto.AccountType;
import com.au.accounting.exception.AccountNotFoundException;

public interface AccountService {

    Account findById(Long id) throws AccountNotFoundException;

    String generateAccountNumber();

    Account insert(AccountType accountType, Long balance);

    Account update(Account account);
}
