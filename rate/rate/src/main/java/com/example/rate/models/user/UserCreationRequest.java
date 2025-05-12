package com.example.rate.models.user;

import com.example.rate.validatator.DobConstraint;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    @Size(min = 6, message = "USERNAME_INVALID")
    private String username;
    @Size(min = 8, message = "PASSWORD_INVALID")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()+\\-?_~])[A-Za-z0-9!@#$%^&*()+\\-?_~]{8,}$",
            message = "WRONG_FORMAT_PASSWORD")
    private String password;
    private String firstname;
    private String lastname;
    @DobConstraint(min = 18, message = "INVALID_DOB")
    private LocalDate dob;
    private String sex;
    private String department;
}
