package com.RidderApp.uberApp.strategies.Impl;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.RideRequest;
import com.RidderApp.uberApp.services.DistanceService;
import com.RidderApp.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class RideFareDefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;

    @Override
    public double calculateFare(RideRequest rideRequest) {

        Double distance = distanceService.calculateDistance(rideRequest.getPickupLocation(),rideRequest.getDropOffLocation());

        return distance*RIDE_FARE_MULTIPLIER;
    }
}
