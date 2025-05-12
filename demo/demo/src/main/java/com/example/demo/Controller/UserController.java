package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCreationRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @DeleteMapping("/{userId}")
    public String deletaUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

//    @PostMapping
//    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
//        ApiResponse<User> apiRespone = new ApiResponse<>();
//
//        apiRespone.setResult(userService.createUser(request));
//        return apiRespone;
//    }

    @GetMapping
    List<User> getUser() {
        return userService.getUser();
    }

//    @GetMapping("/{userId}")
//    UserResponse getUser(@PathVariable String userId) {
//        return userService.getUser(userId);
//    }

//    @PutMapping("{userId}")
//    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
//        return userService.updateUser(userId, request);
//    }

}
