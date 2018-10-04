package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.OrderThreshold;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper
public interface OrderThresholdMapper {
    OrderThresholdMapper INSTANCE = Mappers.getMapper(OrderThresholdMapper.class);

    OrderThreshold toModel(com.fabrick.assignment.model.OrderThreshold channel);
}
