package com.example.rate.models.user;

import com.example.rate.models.admin.Department;
import com.example.rate.models.report.PerformanceReport;
import com.example.rate.models.role.Role;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    @Id
    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String sex;
    Set<Role> roles;
    private Set<PerformanceReport> performanceReports;
    private Department department_id;
}
