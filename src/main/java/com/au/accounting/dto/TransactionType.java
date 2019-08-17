package com.au.accounting.dto;

import com.au.accounting.domain.Account;

public enum TransactionType {

    WITHDRAW {//برداشت

        @Override
        public void doAction(Account account, Long amount) {
            account.setBalance(account.getBalance() == null ? 0 : account.getBalance() - amount);
        }
    },

    DEPOSIT {//واریز

        @Override
        public void doAction(Account account, Long amount) {
            account.setBalance(account.getBalance() == null ? 0 : account.getBalance() + amount);
        }
    },

    TRANSFER {//انتقال

        @Override
        public void doAction(Account account, Long amount) {

        }
    };

    public abstract void doAction(Account account, Long amount);
}
