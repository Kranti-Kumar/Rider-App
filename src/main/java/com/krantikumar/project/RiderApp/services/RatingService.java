package com.krantikumar.project.RiderApp.services;

import com.krantikumar.project.RiderApp.dto.DriverDto;
import com.krantikumar.project.RiderApp.dto.RiderDto;
import com.krantikumar.project.RiderApp.entities.Ride;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
