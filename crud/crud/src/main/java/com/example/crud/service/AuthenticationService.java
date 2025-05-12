package com.example.crud.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.crud.dto.request.AuthenticationRequest;
import com.example.crud.dto.resonse.AuthenticationRespone;
import com.example.crud.dto.resonse.UserReponse;
import com.example.crud.exception.AppException;
import com.example.crud.exception.ErrorCode;
import com.example.crud.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal= true)
public class AuthenticationService {
    UserRepository userRepository;

    protected static final String SIGNER_KEY = "8rhawCtZ4Y5yXrAgt4YgAdZlL1n+7rylH71ae4dQW61yzSWuDTGYuu3fcvXXxXCc";
    public AuthenticationRespone authentication(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByUsername(authenticationRequest.getUsername()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());

        if(!authenticated) 
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        
        var token = generateToken(authenticationRequest.getUsername());
        return AuthenticationRespone.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    private String generateToken(String username) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        // Lấy thời gian hiện tại
        Date now = new Date();
        // Tính thời gian hết hạn: hiện tại + 1 giờ
        Date expirationTime = new Date(now.getTime() + 60 * 60 * 1000);


        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("devteria.com")
                .issueTime(new Date())
                .expirationTime(expirationTime)
                .claim("customClaim", "Custom")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
}
