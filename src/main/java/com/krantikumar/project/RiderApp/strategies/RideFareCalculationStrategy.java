package com.krantikumar.project.RiderApp.strategies;

import com.krantikumar.project.RiderApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);

}
