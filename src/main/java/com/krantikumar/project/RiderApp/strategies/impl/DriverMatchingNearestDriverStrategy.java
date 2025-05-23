package com.krantikumar.project.RiderApp.strategies.impl;

import com.krantikumar.project.RiderApp.entities.Driver;
import com.krantikumar.project.RiderApp.entities.RideRequest;
import com.krantikumar.project.RiderApp.repositories.DriverRepository;
import com.krantikumar.project.RiderApp.strategies.DriverMatchingStrategy;
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
