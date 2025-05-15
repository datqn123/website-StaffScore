package com.example.rate.models.user;

import com.example.rate.models.department.Department;
import com.example.rate.models.contract.Contract;
import com.example.rate.models.role.Role;
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
    private String id;
    private Department department;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String sex;
    private String cccd;
    private LocalDate provided_at;
    private String provided_local;
    private Set<Role> roles;
    private Contract contract;
}
