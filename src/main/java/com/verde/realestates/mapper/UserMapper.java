package com.verde.realestates.mapper;


import com.verde.realestates.dto.response.RegisterUserResDto;
import com.verde.realestates.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    RegisterUserResDto userToRegisterUserDto(User user);
}
