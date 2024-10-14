package com.RidderApp.uberApp.services;


import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.entities.Driver;
import com.RidderApp.uberApp.entities.Ride;
import com.RidderApp.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDriver(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

    Page<Ride> getAllRidesofRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesofDriver(Long driverId, PageRequest pageRequest);
}
