package com.example.rate.models.user;

import com.example.rate.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @GetMapping("/myinfor")
    ApiResponse<UserResponse> getMyInfor() {
        return ApiResponse.<UserResponse>builder().result(userService.getMyInfor()).build();
    }

    @GetMapping("{userId}")
    UserResponse getUserByUserName(@PathVariable String userId) {
        return userService.getUserByUserName(userId);
    }

    @PutMapping("{userId}")
    UserResponse updateUser(@RequestBody UserUpdateRequest request, @PathVariable String userId) {
        return userService.updateUser(request, userId);
    }

    @DeleteMapping("/{userid}")
    String deleteUser(@PathVariable String userid) {
        userService.deleteUser(userid);
        return "User has been deleted";
    }

}
