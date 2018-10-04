package com.fabrick.assignment.mapper;

import com.fabrick.assignment.app.model.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by massimo.biancalani on 03/10/2018.
 */
@Mapper
public interface ChannelMapper {
    ChannelMapper INSTANCE = Mappers.getMapper(ChannelMapper.class);

    Channel toModel(com.fabrick.assignment.model.Channel channel);
}
