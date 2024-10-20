package com.RidderApp.uberApp.controllers;

import com.RidderApp.uberApp.dto.SignupDto;
import com.RidderApp.uberApp.dto.UserDto;
import com.RidderApp.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignupDto signupDto){
        return authService.signup(signupDto);
    }
}
