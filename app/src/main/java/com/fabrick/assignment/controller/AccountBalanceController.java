package com.fabrick.assignment.controller;

import com.fabrick.assignment.app.model.AccountBalance;
import com.fabrick.assignment.form.AccountBalanceForm;
import com.fabrick.assignment.service.AccountBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Controller
@RequestMapping("account-balance")
@Slf4j
public class AccountBalanceController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @GetMapping
    public String input(AccountBalanceForm form, Model model) {
        form.setAccountNumber(1l); //default
        return "accountBalanceInput";
    }

    @PostMapping
    public String confirm(@Validated @ModelAttribute AccountBalanceForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", "An invalid value was entered");
            return input(form, model);
        }
        AccountBalance accountBalance = accountBalanceService.getAccountBalance(form.getAccountNumber());
        form.setDate(accountBalance.getDate());
        form.setBalance(accountBalance.getBalance().toPlainString());
        form.setAvailableBalance(accountBalance.getAvailableBalance().toPlainString());
        form.setCurrency(accountBalance.getCurrency().toString());

        return "accountBalanceOutput";
    }

}
