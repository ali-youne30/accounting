package com.au.accounting.service;

import com.au.accounting.domain.Account;
import com.au.accounting.web.dto.request.TransactionDto;

public interface TransactionService {
    void commit(Account account, TransactionDto transactionDto);
}
