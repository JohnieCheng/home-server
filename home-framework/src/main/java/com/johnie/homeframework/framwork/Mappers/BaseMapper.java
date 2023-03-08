package com.johnie.homeframework.framwork.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BaseMapper<SOURCE, TARGET> {

    BaseMapper INSTANCE = Mappers.getMapper(BaseMapper.class);

    TARGET from(SOURCE source);
}
