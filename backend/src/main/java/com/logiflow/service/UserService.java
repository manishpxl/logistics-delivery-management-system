package com.logiflow.service;

import java.util.List;
import java.util.Optional;

import com.logiflow.entity.User;
import com.logiflow.service.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    Optional<UserDTO> getUserById(Long id);

    List<UserDTO> getAllUsers();

    Optional<UserDTO> getUserByEmail(String email);

    boolean existsByEmail(String email);
}