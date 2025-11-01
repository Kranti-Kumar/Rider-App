package com.RidderApp.uberApp.services;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.RideDto;
import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.dto.RiderDto;
import com.RidderApp.uberApp.entities.Rider;
import com.RidderApp.uberApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
