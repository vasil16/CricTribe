package com.strut.crictribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterDTO dto) {
        return ResponseEntity.ok(userService.registerUser(dto));
    }

     @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO dto) {        
        return ResponseEntity.ok(userService.loginUser(dto));
    }
}
