package com.fabrick.assignment.service;

import com.fabrick.assignment.app.model.Order;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
public interface OrderService {
    Order create(Order order, String portalId);
}
