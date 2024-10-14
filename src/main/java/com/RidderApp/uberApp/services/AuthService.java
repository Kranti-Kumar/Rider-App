package com.RidderApp.uberApp.services;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.SignupDto;
import com.RidderApp.uberApp.dto.UserDto;

public interface AuthService {

    String login(String email , String Password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId);
}
