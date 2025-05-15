package com.example.rate.models.user;

import com.example.rate.constant.PredefinedRole;
import com.example.rate.models.department.Department;
import com.example.rate.models.contract.Contract;
import com.example.rate.models.contract.ContractRepository;
import com.example.rate.models.department.DepartmentRepository;
import com.example.rate.models.role.Role;
import com.example.rate.exception.AppException;
import com.example.rate.exception.ErrorCode;
import com.example.rate.mapper.UserMapper;
import com.example.rate.models.role.RoleRepository;
import com.example.rate.models.department.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;
    DepartmentService departmentService;
    DepartmentRepository departmentRepository;
    ContractRepository contractRepository;

    public UserResponse createUser(UserCreationRequest request) {
        log.info(request.toString());
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<Role> roles = new HashSet<>();
        String role = request.getRole();
        roleRepository.findById(role).ifPresent(roles::add);
        user.setRoles(roles);
        Department department = departmentRepository.findByDepartmentName(request.getDepartment()).orElseThrow(() -> new AppException(ErrorCode.DEPARTMENT_NOT_EXISTED));
        user.setDepartment(department);
        user.setSex(request.getSex());
        user.setCccd(request.getCccd());
        user.setProvided_at(request.getProvided_at());
        user.setProvided_local(request.getProvided_local());
        try {
            user = userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        return userMapper.toUserResponse(user);
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAuthority('GET_ALL_USER')")
    public List<User> getUers() {
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('GET_MY_FOR')")
    public UserResponse getUserByUserName(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found")));
    }

    @PreAuthorize("hasAuthority('GET_MY_INFO')")
    public UserResponse getMyInfor() {
        var context = SecurityContextHolder.getContext();
        String username = context.getAuthentication().getName();
        log.info(username);
        UserResponse response = new UserResponse();
        log.info("Looking for user with username: {}", username);
        userRepository.findByUsername(username).ifPresentOrElse(
                user -> log.info("Found user with ID: {}", user.getId()),
                () -> log.warn("User not found for username: {}", username)
        );
        User user = userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        Contract contract = contractRepository.findByUser_Id(user.getId()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        return response.builder()
                .id(user.getId())
                .department(user.getDepartment())
                .username(username)
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .dob(user.getDob())
                .sex(user.getSex())
                .cccd(user.getCccd())
                .provided_at(user.getProvided_at())
                .provided_local(user.getProvided_local())
                .roles(user.getRoles())
                .contract(contract)
                .build();
    }

    @Transactional
    @PreAuthorize("hasAuthority('UPDATE_MY_INFOR')")
    public UserResponse updateUser(UserUpdateRequest request, String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));
        log.info(request.toString());
        if (request.getFirstname() != null && !request.getFirstname().isBlank()) {
            user.setFirstname(request.getFirstname());
        }
        if (request.getLastname() != null && !request.getLastname().isBlank()) {
            user.setLastname(request.getLastname());
        }
        if (request.getDob() != null) {
            user.setDob(request.getDob());
        }
        if (request.getCccd() != null && !request.getCccd().isBlank()) {
            user.setCccd(request.getCccd());
        }
        if (request.getProvided_at() != null) {
            user.setProvided_at(request.getProvided_at());
        }
        if (request.getProvided_local() != null && !request.getProvided_local().isBlank()) {
            user.setProvided_local(request.getProvided_local());
        }
        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(request.getPassword()));
        }
        User updatedUser = userRepository.save(user);
        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String userid) {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Optional<Contract> optionalContract = contractRepository.findByUser(user);
        optionalContract.ifPresent(contractRepository::delete);
        userRepository.deleteById(userid);
    }

}
