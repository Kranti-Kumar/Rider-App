package com.RidderApp.uberApp.strategies;

import com.RidderApp.uberApp.dto.RideRequestDto;

public interface RideFareCalculationStrategy {

    double calculateFare(RideRequestDto rideRequestDto);
}
