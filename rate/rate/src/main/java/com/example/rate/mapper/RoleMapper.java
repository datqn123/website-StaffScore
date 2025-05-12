package com.example.rate.mapper;

import com.example.rate.models.role.RoleRequest;
import com.example.rate.models.role.RoleResponse;
import com.example.rate.models.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse (Role role);
}
