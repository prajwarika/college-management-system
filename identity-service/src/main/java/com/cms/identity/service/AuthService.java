package com.cms.identity.service;

import com.cms.identity.entity.Roles;
import com.cms.identity.entity.User;
import com.cms.identity.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    public AuthService(UserRepository repository, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        user.setCreated_at(LocalDateTime.now());

        // If the user object comes with a role that only has an ID, 
        // Hibernate will attempt to link it. 
        // If you want to set a default role (e.g., STUDENT with ID 1):
        if (user.getRole() == null) {
            Roles defaultRole = new Roles();
            defaultRole.setRole_id(1L); // Ensure ID 1 exists in your 'roles' table
            user.setRole(defaultRole);
        }

        repository.save(user);
        return "User registered successfully with Role: " + user.getRole().getRole_id();
    }

    public String generateToken(String email) {
        return jwtService.generateToken(email);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
}