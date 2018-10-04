package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.InvestorAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper
public interface InvestorAccountMapper {
    InvestorAccountMapper INSTANCE = Mappers.getMapper(InvestorAccountMapper.class);

    InvestorAccount toModel(com.fabrick.assignment.model.InvestorAccount investorAccount);
}
