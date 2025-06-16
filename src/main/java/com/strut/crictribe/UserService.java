package com.strut.crictribe;

public interface UserService {
    User registerUser(RegisterDTO dto);
    LoginResponse loginUser(LoginDTO dto);
}