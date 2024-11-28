package com.sparta.currency_user.dto.login;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequestDto {
    private final Long userId;
    private final String emaill;

    public LoginRequestDto(Long userId, String emaill) {
        this.userId = userId;
        this.emaill = emaill;
    }
}
