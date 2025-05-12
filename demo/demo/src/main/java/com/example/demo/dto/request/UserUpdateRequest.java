package com.example.demo.dto.request;

import java.time.LocalDate;


import lombok.*;

@Data
public class UserUpdateRequest {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
}
