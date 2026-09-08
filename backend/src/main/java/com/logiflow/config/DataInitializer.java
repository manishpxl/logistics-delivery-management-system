package com.logiflow.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.logiflow.entity.Role;
import com.logiflow.entity.User;
import com.logiflow.repository.RoleRepository;
import com.logiflow.repository.UserRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(
        RoleRepository roleRepository,
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
    ) {
        return args -> {
            // Create roles if not exist
            String[] roleNames = {"ADMIN", "CUSTOMER", "DELIVERY_PARTNER", "WAREHOUSE_STAFF"};

            for (String roleName : roleNames) {
                if (!roleRepository.existsByName(roleName)) {
                    Role role = new Role();
                    role.setName(roleName);
                    roleRepository.save(role);
                    System.out.println("Created role: " + roleName);
                }
            }

            // Create default admin user if not exist
            if (!userRepository.existsByEmail("admin@logiflow.com")) {
                Role adminRole = roleRepository.findByName("ADMIN")
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));

                User admin = new User();
                admin.setName("Admin User");
                admin.setEmail("admin@logiflow.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setActive(true);
                admin.setRoles(List.of(adminRole));

                userRepository.save(admin);
                System.out.println("Created admin user: admin@logiflow.com / admin123");
            }
        };
    }
}