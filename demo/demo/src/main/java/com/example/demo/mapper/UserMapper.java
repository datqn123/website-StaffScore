//package com.example.demo.mapper;
//
//
//import com.example.demo.dto.response.UserResponse;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//
//import com.example.demo.dto.request.UserCreationRequest;
//import com.example.demo.dto.request.UserUpdateRequest;
//import com.example.demo.entity.User;
//
//@Mapper(componentModel="spring")
//public interface UserMapper {
//    User toUser(UserCreationRequest request);
//    UserResponse toUserResponse(User user);
//    void userUpdate(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
//}
//
