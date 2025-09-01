package com.example.security_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private String email;
    private String name;
    private String pass;
    private String phoneNumber;
    private long userId;
}
