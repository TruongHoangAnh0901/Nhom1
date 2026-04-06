package com.congnghevn.newsportal.service;

import com.congnghevn.newsportal.dto.LoginRequest;
import com.congnghevn.newsportal.entity.User;
import com.congnghevn.newsportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean login(LoginRequest loginRequest) {
        Optional<User> userOptional = userRepository.findByUsername(loginRequest.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        }
        return false;
    }
}