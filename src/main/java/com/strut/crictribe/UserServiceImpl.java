package com.strut.crictribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegisterDTO dto) {

        if (userRepository.existsByEmailOrUsername(dto.getEmail(), dto.getUsername())) {
            throw new RuntimeException("Email already taken");
        }

        // 1. Create and save Player
        Player player = new Player();
        player.setName(dto.getFullName());
        player.setPhone(dto.getPhone());
        player.setEmail(dto.getEmail());
        player.setTotalRuns(0);
        player.setTotalWickets(0);
        playerRepository.save(player);

        // 2. Create User and link Player
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setPlayer(player);

        return userRepository.save(user);
    }

    public LoginResponse loginUser(LoginDTO dto) {
    String loginInput = dto.getUsername();

    User user = userRepository
        .findByEmailOrUsername(loginInput, loginInput)
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    return new LoginResponse(
        user.getUsername(),
        user.getEmail(),
        user.getId(),
        user.getPlayer()
    );
}
}
