package com.syriahandwerker.backend.mapper;

import com.syriahandwerker.backend.dto.UserDTO;
import com.syriahandwerker.backend.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import  org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserDTO toDTO(User user);
	@Mapping(target = "password", ignore = true)
	User toEntity(UserDTO userDTO);
}
