package com.logiflow.service.mapper;

import org.springframework.stereotype.Component;

import com.logiflow.entity.User;
import com.logiflow.service.dto.UserDTO;

@Component
public class UserMapper {

    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setActive(dto.getActive());
        return user;
    }

    public UserDTO toDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setActive(entity.getActive());
        return dto;
    }
}