package com.au.accounting.web.dto.request;

import com.au.accounting.dto.TransactionType;
import com.au.accounting.exception.InvalidRestParameterException;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto implements RestParameter {

    private Long accountId;
    private Long amount;
    private TransactionType transactionType;


    @Override
    public void validate() throws InvalidRestParameterException {

        //valid parameters
    }
}
