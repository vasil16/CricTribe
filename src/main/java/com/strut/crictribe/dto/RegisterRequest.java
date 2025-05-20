package com.strut.crictribe.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String email;
    private String password;

  
}
