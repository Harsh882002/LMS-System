package com.cia.lms.system.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

}
