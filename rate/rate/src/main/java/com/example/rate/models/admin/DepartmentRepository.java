package com.example.rate.models.admin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    boolean existsBydepartmentName(String departmentName);
    Optional<Department> findByDepartmentName(String departmentName);
}
