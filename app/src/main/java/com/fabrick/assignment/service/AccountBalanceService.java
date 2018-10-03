package com.fabrick.assignment.service;

import com.fabrick.assignment.app.model.AccountBalance;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
public interface AccountBalanceService {
    AccountBalance getAccountBalance(Long accountId);
}
