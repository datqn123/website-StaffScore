package com.example.rate.models.department;

import com.example.rate.exception.AppException;
import com.example.rate.exception.ErrorCode;
import com.example.rate.mapper.DepartmentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('GET_ALL_DEPARTMENT')")
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @PreAuthorize("hasAuthority('GET_MY_DEPARTMENT')")
    public DepartmentResponse getOneDepartment(String departmentId) {
        return departmentMapper.toDepartmentResponse(departmentRepository.findById(departmentId).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED)));
    }

    public DepartmentResponse updateDepartment(DepartmentUpdateRequest request, String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new RuntimeException("Department not found"));
        departmentMapper.updateDepartment(department, request);
        return departmentMapper.toDepartmentResponse(departmentRepository.save(department));
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }


}
