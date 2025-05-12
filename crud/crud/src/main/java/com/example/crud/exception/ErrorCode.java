package com.example.crud.exception;

public enum ErrorCode {
    UNCATEGORIZE_EXCEPTION(9999, "Uncategorize exception error"),
    USER_EXISTED(1001, "User exist"),
    KEY_INVALID(1002, "Invalid mesage key"),
    USERNAME_INVALID(1003, "Username must be at least 3 characters"),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters"),
    USER_NOT_EXISTED(1005, "User not exist"),
    UNAUTHENTICATED(1006    , "Unauthenticated"),
    ;

    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
