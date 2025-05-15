package com.example.rate.mapper;

import com.example.rate.models.role.Role;
import com.example.rate.models.user.User;
import com.example.rate.models.user.UserCreationRequest;
import com.example.rate.models.user.UserResponse;
import com.example.rate.models.user.UserUpdateRequest;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T09:59:55+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserCreationRequest request) {
        if ( request == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( request.getUsername() );
        user.password( request.getPassword() );
        user.firstname( request.getFirstname() );
        user.lastname( request.getLastname() );
        user.dob( request.getDob() );
        user.sex( request.getSex() );
        user.cccd( request.getCccd() );
        user.provided_at( request.getProvided_at() );
        user.provided_local( request.getProvided_local() );

        return user.build();
    }

    @Override
    public UserResponse toUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponse.UserResponseBuilder userResponse = UserResponse.builder();

        userResponse.cccd( user.getCccd() );
        userResponse.provided_at( user.getProvided_at() );
        userResponse.provided_local( user.getProvided_local() );
        userResponse.department( user.getDepartment() );
        userResponse.id( user.getId() );
        userResponse.username( user.getUsername() );
        userResponse.password( user.getPassword() );
        userResponse.firstname( user.getFirstname() );
        userResponse.lastname( user.getLastname() );
        userResponse.dob( user.getDob() );
        userResponse.sex( user.getSex() );
        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userResponse.roles( new LinkedHashSet<Role>( set ) );
        }

        return userResponse.build();
    }

    @Override
    public void updateUser(User user, UserUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        user.setUsername( request.getUsername() );
        user.setPassword( request.getPassword() );
        user.setFirstname( request.getFirstname() );
        user.setLastname( request.getLastname() );
        user.setDob( request.getDob() );
        user.setCccd( request.getCccd() );
        user.setProvided_at( request.getProvided_at() );
        user.setProvided_local( request.getProvided_local() );
    }
}
