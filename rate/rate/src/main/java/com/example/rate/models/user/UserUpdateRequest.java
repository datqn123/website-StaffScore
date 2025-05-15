package com.example.rate.models.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class UserUpdateRequest {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
    private String cccd;
    private LocalDate provided_at;
    private String provided_local;
    List<String> roles;
}
