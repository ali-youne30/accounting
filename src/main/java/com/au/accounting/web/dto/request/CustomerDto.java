package com.au.accounting.web.dto.request;

import com.au.accounting.dto.AccountType;
import com.au.accounting.exception.InvalidRestParameterException;
import com.au.accounting.util.NationalCodeValidator;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements RestParameter {

    private String firstName;

    private String lastName;

    private String issueNumber;

    private String nationalCode;

    private Long balance;

    private AccountType accountType;

    @Override
    public void validate() throws InvalidRestParameterException {

        List<String> errors = new ArrayList<>();

        if (NationalCodeValidator.isNationalCode(nationalCode) == false) {
            errors.add("invalid national code format");
        }


        //other validation and checking rest parameter

        if (errors.isEmpty() == false) {
            throw new InvalidRestParameterException();
        }
    }
}
