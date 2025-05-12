package com.example.rate.models.admin;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String id;
    private String departmentName;
    private String departmentHead;
    private String divisionDirector;
}
