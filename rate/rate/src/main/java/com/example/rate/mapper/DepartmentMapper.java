package com.example.rate.mapper;

import com.example.rate.models.admin.DepartmentRequest;
import com.example.rate.models.admin.DepartmentUpdateRequest;
import com.example.rate.models.admin.DepartmentResponse;
import com.example.rate.models.admin.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toDepartment(DepartmentRequest request);
    DepartmentResponse toDepartmentResponse(Department department);
    void updateDepartment(@MappingTarget Department department, DepartmentUpdateRequest request);
}
