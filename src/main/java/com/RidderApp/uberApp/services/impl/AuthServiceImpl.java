package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.SignupDto;
import com.RidderApp.uberApp.dto.UserDto;
import com.RidderApp.uberApp.entities.Rider;
import com.RidderApp.uberApp.entities.User;
import com.RidderApp.uberApp.entities.enums.Role;
import com.RidderApp.uberApp.exceptions.RuntimeConflictException;
import com.RidderApp.uberApp.repositories.UserRepository;
import com.RidderApp.uberApp.services.AuthService;
import com.RidderApp.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String Password) {
        return "";
    }

    @Override
    public UserDto signup(SignupDto signupDto) {

       User user= userRepository.findByEmail(signupDto.getEmail()).orElse(null);
       if (user!=null){
                 throw new RuntimeConflictException("Cannot singup,User already exist with email "+ signupDto.getEmail());
       }

        User mappeduser = modelMapper.map(signupDto,User.class);
        mappeduser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappeduser);

        // create user related entities
         riderService.createNewRider(savedUser);



        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
