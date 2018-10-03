package com.fabrick.assignment.app.model;

import static org.apache.commons.lang3.RandomUtils.nextLong;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
public enum AccountBalanceUtil {
    INSTANCE;

    public AccountBalance createAccountBalance() {
        return AccountBalance.builder()
            .date(LocalDate.now().plusDays(nextLong(1, 365)))
            .balance(BigDecimal.valueOf(Math.random()))
            .availableBalance(BigDecimal.valueOf(Math.random()))
            .currency(Currency.EUR)
            .build();
    }
}
