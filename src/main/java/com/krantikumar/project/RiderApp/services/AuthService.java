package com.krantikumar.project.RiderApp.services;

import com.krantikumar.project.RiderApp.dto.DriverDto;
import com.krantikumar.project.RiderApp.dto.SignupDto;
import com.krantikumar.project.RiderApp.dto.UserDto;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, String vehicleId);

    String refreshToken(String refreshToken);
}
