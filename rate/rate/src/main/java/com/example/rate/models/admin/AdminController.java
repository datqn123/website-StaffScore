package com.example.rate.models.admin;

import com.example.rate.models.department.*;
import com.example.rate.models.user.UserCreationRequest;
import com.example.rate.dto.response.ApiResponse;
import com.example.rate.models.user.UserResponse;
import com.example.rate.models.user.User;
import com.example.rate.models.user.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin")
public class AdminController {
    DepartmentService departmentService;
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> creataUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        log.info(apiResponse.toString());
        return apiResponse;
    }

    @GetMapping
    List<User> getUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));
        return userService.getUers();
    }
}
