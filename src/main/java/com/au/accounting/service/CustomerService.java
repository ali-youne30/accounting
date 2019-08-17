package com.au.accounting.service;

import com.au.accounting.domain.Customer;
import com.au.accounting.exception.AccountNotFoundException;
import com.au.accounting.web.dto.request.CustomerDto;

public interface CustomerService {

    Customer findByAccount(Long accountId) throws AccountNotFoundException;

    Customer insert(CustomerDto customerDto);

    Customer update(CustomerDto source, Customer destination);
}
