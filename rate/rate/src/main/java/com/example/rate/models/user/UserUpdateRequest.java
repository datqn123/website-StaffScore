package com.example.rate.models.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserUpdateRequest {
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    List<String> roles;
}
