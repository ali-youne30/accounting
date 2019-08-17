package com.au.accounting.service;

import com.au.accounting.domain.Account;
import com.au.accounting.dto.AccountType;
import com.au.accounting.exception.AccountNotFoundException;
import com.au.accounting.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account findById(Long id) throws AccountNotFoundException {
        return repository.findById(id).orElseThrow(() -> new AccountNotFoundException());
    }

    public String generateAccountNumber() {

        Page<Account> result = repository.findAll(PageRequest.of(0, 1, Sort.by(Sort.Direction.DESC, "creationDate")));

        String lastAccount = result.get().findFirst().orElse(new Account("0")).getAccountNumber();

        int lastAccountNumber = Integer.parseInt(lastAccount) + 1;

        return String.format("%8s", lastAccountNumber).replace(' ', '0');
    }

    @Override
    @Transactional
    public Account insert(AccountType accountType, Long balance) {
        Account entity = new Account();
        entity.setAccountNumber(generateAccountNumber());
        entity.setBalance(balance);
        entity.setAccountType(accountType);
        entity.setCreationDate(new Date());

        return repository.save(entity);
    }

    @Override
    @Transactional
    public Account update(Account account) {
        return repository.save(account);
    }
}
