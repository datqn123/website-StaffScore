package com.example.rate.mapper;

import com.example.rate.models.user.UserCreationRequest;
import com.example.rate.models.user.UserUpdateRequest;
import com.example.rate.models.user.UserResponse;
import com.example.rate.models.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "department", ignore = true)
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "department", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
