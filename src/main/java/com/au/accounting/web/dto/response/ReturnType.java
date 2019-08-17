package com.au.accounting.web.dto.response;

public enum ReturnType {

    OK(0, "عملیات موفقیت آمیز"),
    INVALID_REQUEST_PARAMETER(1, "پارامترهای ارسالی معتبر نیست"),
    THROWS_EXCEPTION(2, "بروز خطای داخلی");

    public final int code;
    public final String desc;

    ReturnType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
