package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.AccountBalance;
import com.fabrick.assignment.model.AccountBalanceResponsePayload;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper(uses = {CurrencyMapper.class})
public interface AccountBalanceMapper {
    AccountBalanceMapper INSTANCE = Mappers.getMapper(AccountBalanceMapper.class);

    AccountBalance toModel(AccountBalanceResponsePayload payload);
}
