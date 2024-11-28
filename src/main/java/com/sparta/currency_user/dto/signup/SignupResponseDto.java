package com.sparta.currency_user.dto.signup;

import com.sparta.currency_user.entity.User;

import java.time.LocalDateTime;

public class SignupResponseDto {

    private Long userId;
    private String email;
    private String userName;
    private LocalDateTime createdDate;

    public SignupResponseDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.userName = user.getName();
        this.createdDate = user.getCreatedAt();
    }
}
