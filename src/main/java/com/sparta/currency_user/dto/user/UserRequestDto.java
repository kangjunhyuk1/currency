package com.sparta.currency_user.dto.user;

import com.fasterxml.jackson.databind.ser.std.UUIDSerializer;
import com.sparta.currency_user.dto.signup.SignupResponseDto;
import com.sparta.currency_user.entity.User;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name;
    private String email;

    public UserRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getName(),
                user.getEmail()
        );
    }
}
