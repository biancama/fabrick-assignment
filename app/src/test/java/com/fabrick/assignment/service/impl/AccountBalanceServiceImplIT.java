package com.fabrick.assignment.service.impl;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static java.lang.String.format;
import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.assertj.core.api.Java6Assertions.assertThat;

import com.fabrick.assignment.app.model.AccountBalance;
import com.fabrick.assignment.app.model.AccountBalanceUtil;
import com.fabrick.assignment.config.AppTestConfig;
import com.fabrick.assignment.model.AccountBalanceResponse;
import com.fabrick.assignment.model.AccountBalanceResponsePayload;
import com.fabrick.assignment.model.Currency;
import com.fabrick.assignment.service.AccountBalanceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link AccountBalanceServiceImpl}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {AppTestConfig.class})
public class AccountBalanceServiceImplIT extends AbstractServiceTest {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @Before
    public void setUp() {
        setRestEndpoints(accountBalanceService);
    }

    @Test
    public void givenAccountBalnaceWhenServiceIsCalledThenAnObjectIsReturn() throws JsonProcessingException {
        final Long accountId = nextLong();
        AccountBalance expectedAccountBalance = AccountBalanceUtil.INSTANCE.createAccountBalance();
        AccountBalanceResponse accountBalanceResponse = AccountBalanceResponse.builder()
            .payload(AccountBalanceResponsePayload.builder()
                .date(expectedAccountBalance.getDate())
                .balance(expectedAccountBalance.getBalance())
                .availableBalance(expectedAccountBalance.getAvailableBalance())
                .currency(Currency.EUR)
                .build())
            .build();
        // given
        this.wireMock.stubFor(get(urlEqualTo(format("/accounts/%d/balance", accountId)))
            .willReturn(aResponse().withStatus(200)
                .withHeader(HttpHeaders.CONTENT_TYPE,
                    MediaType.APPLICATION_JSON_VALUE)
                .withBody(objectMapper.writeValueAsString(accountBalanceResponse))));

        // when
        AccountBalance actualAccountBalance = accountBalanceService.getAccountBalance(accountId);
        assertThat(actualAccountBalance).isEqualTo(expectedAccountBalance);
    }
}
