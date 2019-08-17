package com.au.accounting.service;

import com.au.accounting.domain.Account;
import com.au.accounting.domain.Transaction;
import com.au.accounting.repository.TransactionRepository;
import com.au.accounting.web.dto.request.TransactionDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final ModelMapper mapper;
    private final AccountService accountService;
    private final TransactionRepository repository;

    @Override
    @Transactional
    public void commit(Account account, TransactionDto transactionDto) {
        Transaction transaction = mapper.map(transactionDto, Transaction.class);
        transaction.setAccount(account);
        accountService.update(account);
        repository.save(transaction);
    }
}
