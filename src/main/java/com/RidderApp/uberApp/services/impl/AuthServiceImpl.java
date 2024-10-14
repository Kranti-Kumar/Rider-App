package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.SignupDto;
import com.RidderApp.uberApp.dto.UserDto;
import com.RidderApp.uberApp.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String Password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
