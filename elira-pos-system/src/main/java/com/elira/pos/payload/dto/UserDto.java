package com.elira.pos.payload.dto;

import com.elira.pos.domain.UserRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {


    private Long id;

    private String fullName;

    private String email;

    private String phone;

    private UserRole role;

    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;
}
