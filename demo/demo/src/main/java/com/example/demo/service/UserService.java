package com.example.demo.service;


import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
//import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal= true)
public class UserService {
    UserRepository userRepository;

//    UserMapper userMapper;

//    public User createUser(UserCreationRequest request) {
//
//        if(userRepository.existsByUsername(request.getUsername())) throw new RuntimeException("ErrorCode.USER_EXISTED");
//
//        System.out.println(request.getFirstName());
//
//        User user = userMapper.toUser(request);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        user.setPassword(passwordEncoder.encode(request.getPassword()));
//        return userRepository.save(user);
//    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

//    public UserResponse getUser(String userId) {
//        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found")));
//    }

//    public UserResponse updateUser(String userId, UserUpdateRequest request) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        userMapper.userUpdate(user, request);
//        return userMapper.toUserResponse(userRepository.save(user));
//    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}

