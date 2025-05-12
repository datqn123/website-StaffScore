package com.example.rate.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(1004, "Password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    WRONG_FORMAT_PASSWORD(1009, "Password must contain at least one number and one special character", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age must be at least {min}",HttpStatus.BAD_REQUEST),
    DEPARTMENT_EXISTED(1010, "Department existed", HttpStatus.BAD_REQUEST),
    DEPARTMENT_NOT_EXISTED(1011, "Department was not existed", HttpStatus.NOT_FOUND),
    CONTRACT_EXISTED(1012, "Contract was existed", HttpStatus.BAD_REQUEST),
    CONTRACT_NOT_FOUND(1013, "Contract not found", HttpStatus.NOT_FOUND),
    REPORT_EXISTED(1014, "Report was created", HttpStatus.BAD_REQUEST),
    REPORT_NOT_FOUND(1015, "Report not founded", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
