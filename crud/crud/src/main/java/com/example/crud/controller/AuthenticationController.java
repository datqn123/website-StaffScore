package com.example.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.service.AuthenticationService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.crud.dto.request.ApiResponse;
import com.example.crud.dto.request.AuthenticationRequest;
import com.example.crud.dto.resonse.AuthenticationRespone;



@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal= true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationRespone>authenticate(@RequestBody AuthenticationRequest request) {
        var rs = authenticationService.authentication(request);
        return ApiResponse.<AuthenticationRespone>builder()
            .result(rs)
            .build();
    }
    
    
}
