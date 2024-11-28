package com.sparta.currency_user.dto.user;

import com.sparta.currency_user.entity.User;
import lombok.Getter;

@Getter
public class UserResponseDto {
    private Long userId;

    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public UserResponseDto(Long id, String name, String email) {
        this.userId = id;
        this.name = name;
        this.email = email;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getName(),
                user.getEmail()
        );
    }
}
