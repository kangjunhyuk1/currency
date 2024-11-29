package com.sparta.currency_user.dto.signup;

import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SignupResponseDto {

    private Long userId;
    private String email;
    private String userName;
    private LocalDateTime createdAt;



    public static SignupResponseDto toSignup(User user) {
        return new SignupResponseDto(
                user.getUserId(),
                user.getEmail(),
                user.getUserName(),
                user.getCreatedAt()
        );
    }

    public SignupResponseDto(Long userId, String email, String userName, LocalDateTime createdAt) {
        this.userId = userId;
        this.email = email;
        this.userName = userName;
        this.createdAt = createdAt;
    }


}
