package com.logiflow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logiflow.service.AuthService;
import com.logiflow.service.dto.AuthRequest;
import com.logiflow.service.dto.AuthResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register/customer")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> registerCustomer(@RequestBody RegisterCustomerRequest request) {
        authService.registerCustomer(
            request.getName(),
            request.getEmail(),
            request.getPassword(),
            request.getPhoneNumber()
        );
        return ResponseEntity.ok().build();
    }

    public static class RegisterCustomerRequest {
        private String name;
        private String email;
        private String password;
        private String phoneNumber;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getPhoneNumber() { return phoneNumber; }
        public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    }
}