package com.ahmadi.onlineshop.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    private long userId;
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
