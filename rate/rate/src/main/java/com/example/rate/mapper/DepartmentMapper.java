package com.example.rate.mapper;

import com.example.rate.models.department.DepartmentRequest;
import com.example.rate.models.department.DepartmentUpdateRequest;
import com.example.rate.models.department.DepartmentResponse;
import com.example.rate.models.department.Department;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toDepartment(DepartmentRequest request);
    DepartmentResponse toDepartmentResponse(Department department);
    void updateDepartment(@MappingTarget Department department, DepartmentUpdateRequest request);
}
