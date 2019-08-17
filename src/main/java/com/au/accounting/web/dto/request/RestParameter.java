package com.au.accounting.web.dto.request;

import com.au.accounting.exception.InvalidRestParameterException;

public interface RestParameter {

    void validate() throws InvalidRestParameterException;
}
