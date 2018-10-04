package com.fabrick.assignment.controller;

import static com.fabrick.assignment.app.model.Currency.EUR;

import com.fabrick.assignment.app.model.Channel;
import com.fabrick.assignment.app.model.InvestorAccount;
import com.fabrick.assignment.app.model.Order;
import com.fabrick.assignment.app.model.OrderThreshold;
import com.fabrick.assignment.form.OrderForm;
import com.fabrick.assignment.service.OrderService;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Controller
@RequestMapping("create-order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    final static Map<String, OrderThreshold> RADIO_THRESHOLD_ITEMS =
        Collections.unmodifiableMap(new LinkedHashMap<String, OrderThreshold>() {
            {
                put(OrderThreshold.OVER_THRESHOLD.toString(), OrderThreshold.OVER_THRESHOLD);
                put(OrderThreshold.UNDER_THRESHOLD.toString(), OrderThreshold.UNDER_THRESHOLD);

            }
        });

    final static Map<String, Channel> RADIO_CHANNEL_ITEMS =
        Collections.unmodifiableMap(new LinkedHashMap<String, Channel>() {
            {
                put(Channel.CARD.toString(), Channel.CARD);
                put(Channel.MONEYTRANSFER.toString(), Channel.MONEYTRANSFER);

            }
        });
    @GetMapping
    public String input(OrderForm form, Model model) {
        model.addAttribute("radioThresholdItems", RADIO_THRESHOLD_ITEMS);
        model.addAttribute("radioChannelItems", RADIO_CHANNEL_ITEMS);

        form.setPortalId("testPortalId"); //default
        form.setRadioThreshold(OrderThreshold.OVER_THRESHOLD.toString());
        form.setRadioChannel(Channel.CARD.toString());

        return "orderInput";
    }

    @PostMapping
    public String confirm(@Validated @ModelAttribute OrderForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("validationError", "An invalid value was entered");
            return input(form, model);
        }
        Order inputOrder = Order.builder()
            .campaignId(form.getCampaignId())
            .companyId(form.getCompanyId())
            .channel(Channel.valueOf(form.getRadioChannel()))
            .currency(EUR)
            .description(form.getDescription())
            .investorAccount(InvestorAccount.builder().iban(form.getIban()).build())
            .investorId(form.getInvestorId())
            .item(form.getItem())
             .orderAmount(new BigDecimal(form.getOrderAmount()))
            .totalAmount(new BigDecimal(form.getTotalAmount()))
            .feeAmount(new BigDecimal("13.22"))
            .orderThreshold(OrderThreshold.valueOf(form.getRadioThreshold()))
            .orderTimestamp(LocalDateTime.now())
            .build();
        Order orderCreated = orderService.create(inputOrder, form.getPortalId());
        model.addAttribute("order", orderCreated);
        return "orderOutput";
    }

}
