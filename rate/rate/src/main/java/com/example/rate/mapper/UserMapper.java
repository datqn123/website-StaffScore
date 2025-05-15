package com.example.rate.mapper;

import com.example.rate.models.user.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "department", ignore = true)
    User toUser(UserCreationRequest request);

    @Mapping(source = "cccd", target = "cccd")
    @Mapping(source = "provided_at", target = "provided_at")
    @Mapping(source = "provided_local", target = "provided_local")
    @Mapping(source = "department", target = "department")
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "department", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
