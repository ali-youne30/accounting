package com.au.accounting.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NationalCodeValidator {

    private static final List<String> invalidList =
            Arrays.asList("0000000000", "1111111111", "2222222222", "3333333333",
                    "4444444444", "5555555555", "6666666666", "7777777777", "8888888888", "9999999999");

    public static boolean isNationalCode(String code) {
        if (!code.matches("^\\d{10}$"))
            return false;


        if (invalidList.contains(code))
            return false;

        int check = Integer.parseInt(code.substring(9, 10));

        int sum = IntStream.range(0, 9)
                .map(x -> Integer.parseInt(code.substring(x, x + 1)) * (10 - x))
                .sum() % 11;

        return (sum < 2 && check == sum) || (sum >= 2 && check + sum == 11);
    }
}
