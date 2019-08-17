package com.au.accounting.repository;

import com.au.accounting.domain.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("select c from Customer c where c.account.id = :accountId")
    Optional<Customer> findCustomerByAccount(@Param("accountId") Long accountId);
}
