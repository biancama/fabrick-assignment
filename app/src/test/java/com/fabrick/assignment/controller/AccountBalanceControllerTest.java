package com.fabrick.assignment.controller;

import static io.florianlopes.spring.test.web.servlet.request.MockMvcRequestBuilderUtils.postForm;
import static org.apache.commons.lang3.RandomUtils.nextLong;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.fabrick.assignment.app.model.AccountBalance;
import com.fabrick.assignment.app.model.AccountBalanceUtil;
import com.fabrick.assignment.form.AccountBalanceForm;
import com.fabrick.assignment.service.AccountBalanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * tests for {@link AccountBalanceController}.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(AccountBalanceController.class)
public class AccountBalanceControllerTest extends AbstractControllerTest {

    @MockBean
    private AccountBalanceService accountBalanceService;

    @Test
    public void whenAccountControllerIsCalledThenFormAccountIsSetWithDefault() throws Exception {
        mvc.perform(get("/account-balance"))
            .andExpect(status().isOk())
            .andExpect(model().attribute("accountBalanceForm", hasProperty("accountNumber", is(1l))))
            .andExpect(view().name("accountBalanceInput"));

    }

    @Test
    public void whenAccountControllerIsPostedThenFormAccountIsSetWithAccountBalanceFromService() throws Exception {
        final Long accountId = nextLong(1, 9999);
        final AccountBalance accountBalance = AccountBalanceUtil.INSTANCE.createAccountBalance();

        // given
        when(accountBalanceService.getAccountBalance(accountId)).thenReturn(accountBalance);
        mvc.perform(postForm("/account-balance", AccountBalanceForm.builder().accountNumber(accountId).build()))
            .andExpect(status().isOk())
            .andExpect(model().attribute("accountBalanceForm", hasProperty("date", is(accountBalance.getDate()))))
            .andExpect(model().attribute("accountBalanceForm", hasProperty("balance", is(accountBalance.getBalance().toPlainString()))))
            .andExpect(model().attribute("accountBalanceForm", hasProperty("availableBalance", is(accountBalance.getAvailableBalance().toPlainString()))))
            .andExpect(model().attribute("accountBalanceForm", hasProperty("currency", is(accountBalance.getCurrency().toString()))))
            .andExpect(view().name("accountBalanceOutput"));

    }
}
