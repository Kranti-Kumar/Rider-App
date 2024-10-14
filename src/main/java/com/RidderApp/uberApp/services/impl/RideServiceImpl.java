package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.Driver;
import com.RidderApp.uberApp.entities.Ride;
import com.RidderApp.uberApp.entities.enums.RideStatus;
import com.RidderApp.uberApp.services.RideService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RideServiceImpl implements RideService {
    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void matchWithDriver(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesofRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidesofDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
