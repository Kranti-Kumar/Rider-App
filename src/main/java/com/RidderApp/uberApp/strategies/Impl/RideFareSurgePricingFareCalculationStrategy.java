package com.RidderApp.uberApp.strategies.Impl;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.RideRequest;
import com.RidderApp.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
