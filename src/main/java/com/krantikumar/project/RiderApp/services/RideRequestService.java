package com.krantikumar.project.RiderApp.services;

import com.krantikumar.project.RiderApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
