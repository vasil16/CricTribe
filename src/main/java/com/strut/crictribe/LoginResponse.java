package com.strut.crictribe;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private String email;
    private Long userId;
    private Player player;
}