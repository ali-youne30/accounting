package com.au.accounting.service;

import com.au.accounting.domain.Account;
import com.au.accounting.domain.Customer;
import com.au.accounting.exception.AccountNotFoundException;
import com.au.accounting.repository.CustomerRepository;
import com.au.accounting.web.dto.request.CustomerDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final ModelMapper mapper;
    private final AccountService accountService;
    private final CustomerRepository customerRepository;

    @Override
    public Customer findByAccount(Long accountId) throws AccountNotFoundException {

        return customerRepository.findCustomerByAccount(accountId)
                .orElseThrow(() -> new AccountNotFoundException());
    }

    @Override
    @Transactional
    public Customer insert(CustomerDto customerDto) {

        Account account = accountService.insert(customerDto.getAccountType(), customerDto.getBalance());

        Customer entity = mapper.map(customerDto, Customer.class);
        entity.setAccount(account);
        customerRepository.save(entity);

        return entity;
    }

    @Override
    @Transactional
    public Customer update(CustomerDto source, Customer destination) {
        mapper.map(source, destination);

        return customerRepository.save(destination);
    }
}
