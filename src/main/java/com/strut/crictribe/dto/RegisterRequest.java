package com.strut.crictribe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@NoArgsConstructor  // add this
@AllArgsConstructor 

public class RegisterRequest {
    private String username;
    private String email;
    private String password;

  
}
