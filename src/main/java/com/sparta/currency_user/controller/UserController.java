package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.login.LoginRequestDto;
import com.sparta.currency_user.dto.signup.SignupRequestDto;
import com.sparta.currency_user.dto.signup.SignupResponseDto;
import com.sparta.currency_user.dto.user.UserRequestDto;
import com.sparta.currency_user.dto.user.UserResponseDto;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findUsers() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@Validated @RequestBody SignupRequestDto signupRequestDto, BindingResult bindingResult, HttpServletRequest request) {

        HttpSession session = request.getSession();

        if (session.getAttribute("SESSION_KEY") != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 로그인 된 상태입니다");
        }

        SignupResponseDto signupUser = userService.signup(signupRequestDto, bindingResult);
        return new ResponseEntity<>(signupUser, HttpStatus.CREATED);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest request) {
        User login = userService.login(loginRequestDto);

        HttpSession session = request.getSession();
        if (session.getAttribute("SESSION_KEY") != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 로그인 된 상태입니다");
        }

        session.setAttribute("SESSION_KEY", login.getUser());
        return ResponseEntity.ok().body("로그인되었습니다");
    }

    //로그아웃
    @DeleteMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

    if (session != null) {
        session.invalidate();
    }
    return new ResponseEntity<>("로그아웃 되었습니다", HttpStatus.OK);
    }
}
