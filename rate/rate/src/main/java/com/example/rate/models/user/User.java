package com.example.rate.models.user;

import com.example.rate.models.role.Role;
import com.example.rate.models.department.Department;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String id;
    @ManyToOne
    @JoinColumn(name = "department_id")
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
    @ManyToMany
    private Set<Role> roles;
}
