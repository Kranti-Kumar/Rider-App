package com.RidderApp.uberApp.strategies.Impl;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequestDto rideRequestDto) {
        return 0;
    }
}
