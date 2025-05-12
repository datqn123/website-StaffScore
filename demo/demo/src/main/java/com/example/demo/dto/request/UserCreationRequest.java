package com.example.demo.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.*;

@Data
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 3, message= "USERNAME_INVALID")
    String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;
    String firstName;
    String lastName;
    LocalDate dob;

}

