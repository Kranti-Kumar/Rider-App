package com.RidderApp.uberApp.services;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.RiderDto;
import com.RidderApp.uberApp.entities.Ride;


public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);
    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);
}
