package com.example.rate.mapper;

import com.example.rate.models.permission.PermissionRequest;
import com.example.rate.models.permission.PermissionResponse;
import com.example.rate.models.permission.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);
    PermissionResponse toPermissionResponse(Permission permission);
}
