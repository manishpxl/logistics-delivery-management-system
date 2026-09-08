package com.logiflow.service;

import com.logiflow.service.dto.AuthRequest;
import com.logiflow.service.dto.AuthResponse;

public interface AuthService {

    AuthResponse login(AuthRequest request);

    void registerCustomer(String name, String email, String password, String phoneNumber);
}