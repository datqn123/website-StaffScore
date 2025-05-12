package com.example.rate.models.admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentUpdateRequest {
    private String departmentName;
    private String departmentHead;
    private String divisionDirector;
}
