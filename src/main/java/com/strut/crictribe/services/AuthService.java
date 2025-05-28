package com.strut.crictribe.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import com.strut.crictribe.dto.AuthenticationResponse;
import com.strut.crictribe.dto.AuthenticationRequest;
import org.springframework.stereotype.Service;

import com.strut.crictribe.dto.RegisterRequest;
import com.strut.crictribe.model.User;
import com.strut.crictribe.dto.LoginRequest;
import com.strut.crictribe.model.User.Role;
import com.strut.crictribe.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public String register(RegisterRequest request) {
        var user = User.builder()
        .username(request.getUsername())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.PLAYER)
        .build();

        userRepository.save(user);
        return jwtService.generateToken(user.getEmail());

    }
    
    public String login(LoginRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }
    
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        var jwtToken = jwtService.generateToken(user.getEmail());

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


} 
