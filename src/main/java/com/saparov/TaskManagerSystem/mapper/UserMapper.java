package com.saparov.TaskManagerSystem.mapper;

import com.saparov.TaskManagerSystem.dto.UserDto;
import com.saparov.TaskManagerSystem.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        if(user == null){
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setUserRole(user.getUserRole());
        userDto.setStatus(user.getStatus());

        return userDto;
    }

    public User toEntity(UserDto userDto){
        if(userDto == null){
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserRole(userDto.getUserRole());
        user.setStatus(userDto.getStatus());

        return user;
    }
}
