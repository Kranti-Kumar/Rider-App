package com.RidderApp.uberApp.services;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.RideDto;
import com.RidderApp.uberApp.dto.RiderDto;

import java.util.List;

public interface DriverService {

    RideDto acceptRide(Long rideId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    List<RideDto> getAllMyRides();
}
