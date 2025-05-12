package com.example.rate.models.admin;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    @Id
    private String id;
    private String departmentName;
    private String departmentHead;
    private String divisionDirector;
}
