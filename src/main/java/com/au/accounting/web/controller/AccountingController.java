package com.au.accounting.web.controller;


import com.au.accounting.domain.Account;
import com.au.accounting.domain.Customer;
import com.au.accounting.exception.AccountNotFoundException;
import com.au.accounting.exception.InvalidRestParameterException;
import com.au.accounting.service.AccountService;
import com.au.accounting.service.CustomerService;
import com.au.accounting.service.TransactionService;
import com.au.accounting.web.dto.request.CustomerDto;
import com.au.accounting.web.dto.request.TransactionDto;
import com.au.accounting.web.dto.response.Response;
import com.au.accounting.web.dto.response.ReturnType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/accounting")
public class AccountingController {

    private final TransactionService transactionService;
    private final CustomerService customerService;
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Response> createAccount(@RequestBody CustomerDto customerDto)
            throws InvalidRestParameterException {

        customerDto.validate();
        customerService.insert(customerDto);

        return ResponseEntity.ok(new Response(ReturnType.OK));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Response> updateAccount(@PathVariable(value = "accountId") Long accountId,
                                                  @RequestBody CustomerDto customerDto)
            throws AccountNotFoundException {

        Customer customer = customerService.findByAccount(accountId);
        customerService.update(customerDto, customer);

        return ResponseEntity.ok(new Response(ReturnType.OK));
    }

    @PostMapping("/transaction")
    public ResponseEntity<Response> transaction(@RequestBody TransactionDto transactionDto)
            throws AccountNotFoundException {

        Account account = accountService.findById(transactionDto.getAccountId());

        transactionDto.getTransactionType().doAction(account, transactionDto.getAmount());

        transactionService.commit(account, transactionDto);

        return ResponseEntity.ok(new Response(ReturnType.OK));
    }
}
