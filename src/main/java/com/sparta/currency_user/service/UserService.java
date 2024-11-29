package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.login.LoginRequestDto;
import com.sparta.currency_user.dto.signup.SignupRequestDto;
import com.sparta.currency_user.dto.signup.SignupResponseDto;
import com.sparta.currency_user.dto.user.UserRequestDto;
import com.sparta.currency_user.dto.user.UserResponseDto;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(findUserById(id));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }


    @Transactional
    public void deleteUserById(Long id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

    // 회원 가입
    public SignupResponseDto signup(SignupRequestDto signupRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "유효하지 않은 형식입니다");
        }
        User userInformation = new User(signupRequestDto);
        if (userRepository.existsByEmail(signupRequestDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "중복된 사용자 입니다");
        }
        User saveUser = userRepository.save(userInformation);
        return SignupResponseDto.toSignup(saveUser);
    }

    public User login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findByEmail(loginRequestDto.getEmail());

        if (user == null || user.getStatus().equals("N")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않은 사용자 이메일 입니다");
        }
        return user;
    }
}
