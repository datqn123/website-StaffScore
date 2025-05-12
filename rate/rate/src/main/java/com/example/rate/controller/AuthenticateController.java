package com.example.rate.controller;

import com.example.rate.dto.request.AuthenticationRequest;
import com.example.rate.dto.request.IntrospectRequest;
import com.example.rate.dto.request.LogoutRequest;
import com.example.rate.dto.request.RefreshRequest;
import com.example.rate.dto.response.ApiResponse;
import com.example.rate.dto.response.AuthenticationResponse;
import com.example.rate.dto.response.IntrospectResponse;
import com.example.rate.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticateController {
    AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var rs = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(rs)
                .build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
        var rs = authenticationService.refreshToken(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(rs)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> authenticate(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var rs = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(rs)
                .build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);
        return ApiResponse.<Void>builder()
                .build();
    }
    

}
