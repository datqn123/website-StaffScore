package com.example.crud.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.crud.dto.request.UserCreationRequest;
import com.example.crud.dto.request.UserUpdateRequest;
import com.example.crud.dto.resonse.UserReponse;
import com.example.crud.entity.User;

@Mapper(componentModel="spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserReponse toUserResponse(User user);
    void userUpdate(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}
