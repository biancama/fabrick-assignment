package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.Currency;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper(CurrencyMapper.class);

    Currency toModel(com.fabrick.assignment.model.Currency currency);
}
