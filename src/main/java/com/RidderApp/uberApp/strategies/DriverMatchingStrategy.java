package com.RidderApp.uberApp.strategies;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
