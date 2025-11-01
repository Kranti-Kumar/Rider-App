package com.RidderApp.uberApp.strategies.Impl;

import com.RidderApp.uberApp.entities.Driver;
import com.RidderApp.uberApp.entities.RideRequest;
import com.RidderApp.uberApp.repositories.DriverRepository;
import com.RidderApp.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearestDrivers(rideRequest.getPickupLocation());
    }
}
