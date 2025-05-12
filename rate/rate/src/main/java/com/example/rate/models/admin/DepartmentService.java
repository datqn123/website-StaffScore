package com.example.rate.models.admin;

import com.example.rate.exception.AppException;
import com.example.rate.exception.ErrorCode;
import com.example.rate.mapper.DepartmentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class DepartmentService {

    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper;

    public DepartmentResponse createDepartment(DepartmentRequest request) {
        if(departmentRepository.existsBydepartmentName(request.getDepartmentName())){
            throw new AppException(ErrorCode.DEPARTMENT_EXISTED);
        }
        Department department = departmentMapper.toDepartment(request);
        try {
            department = departmentRepository.save(department);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.DEPARTMENT_EXISTED);
        }
        return departmentMapper.toDepartmentResponse(department);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public DepartmentResponse updateDepartment(DepartmentUpdateRequest request, String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentMapper.updateDepartment(department, request);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public Department findByName(String departmentName) {
        Department department = departmentRepository.findByDepartmentName(departmentName).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        return department;
    }
}
