package com.RidderApp.uberApp.strategies.Impl;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.Driver;
import com.RidderApp.uberApp.strategies.DriverMatchingStrategy;

import java.util.List;

public class DriverMatchingHighestRatedDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
