package com.krantikumar.project.RiderApp.services;

import com.krantikumar.project.RiderApp.dto.DriverDto;
import com.krantikumar.project.RiderApp.dto.RideDto;
import com.krantikumar.project.RiderApp.dto.RideRequestDto;
import com.krantikumar.project.RiderApp.dto.RiderDto;
import com.krantikumar.project.RiderApp.entities.Rider;
import com.krantikumar.project.RiderApp.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RiderService {

    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    Page<RideDto> getAllMyRides(PageRequest pageRequest);

    Rider createNewRider(User user);

    Rider getCurrentRider();
}
