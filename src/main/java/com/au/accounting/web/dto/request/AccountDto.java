package com.au.accounting.web.dto.request;


import com.au.accounting.dto.AccountType;
import com.au.accounting.exception.InvalidRestParameterException;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto implements RestParameter {

    private String accountNumber;

    private AccountType accountType;

    private LocalDate creationDate;

    @Override
    public void validate() throws InvalidRestParameterException {

        String numberFormat = "\\d+";
        List<String> errors = new ArrayList<>();

        if (accountNumber.matches(numberFormat) == false) {
            errors.add("invalid account number format");
        }

        //other validation and checking rest parameter

        if (errors.isEmpty() == false) {
            throw new InvalidRestParameterException();
        }
    }
}
