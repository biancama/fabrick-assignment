package com.fabrick.assignment.service.impl;

import static java.lang.String.format;

import com.fabrick.assignment.app.model.AccountBalance;
import com.fabrick.assignment.mapper.AccountBalanceMapper;
import com.fabrick.assignment.model.AccountBalanceResponse;
import com.fabrick.assignment.service.AccountBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fabrick.rest.endpoint}")
    private String restEndpointUrl;

    @Override
    public AccountBalance getAccountBalance(Long accountId) {

        ResponseEntity<AccountBalanceResponse> response = restTemplate.exchange(
            format("%s/gbs/banking/v4.0/accounts/%d/balance", restEndpointUrl, accountId),
            HttpMethod.GET,
            null,
            AccountBalanceResponse.class);

        return AccountBalanceMapper.INSTANCE.toModel(response.getBody().getPayload());
    }
}
