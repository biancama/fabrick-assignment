package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper(uses = {ChannelMapper.class, InvestorAccountMapper.class, OrderThresholdMapper.class, CurrencyMapper.class})
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toModel(com.fabrick.assignment.model.Order order);
}
