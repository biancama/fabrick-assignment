package com.fabrick.assignment.service.impl;

import static java.lang.String.format;

import com.fabrick.assignment.app.model.Order;
import com.fabrick.assignment.mapper.OrderMapper;
import com.fabrick.assignment.model.OrderResponse;
import com.fabrick.assignment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by massimo.biancalani on 04/10/2018.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${fabrick.rest.endpoint}")
    private String restEndpointUrl;

    @Override
    public Order create(Order order, String portalId) {
        HttpEntity<Order> request = new HttpEntity<>(order);
        ResponseEntity<OrderResponse> response = restTemplate.exchange(
            format("%s/gbs/crowdfunding-equity/v3.0/portals/%s/orders", restEndpointUrl, portalId),
            HttpMethod.POST,
            request,
            OrderResponse.class);

        return OrderMapper.INSTANCE.toModel(response.getBody().getPayload());
    }
}
