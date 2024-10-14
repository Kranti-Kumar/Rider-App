package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.RideDto;
import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.dto.RiderDto;
import com.RidderApp.uberApp.entities.RideRequest;
import com.RidderApp.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {
    private final ModelMapper modelMapper;
    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        log.info(rideRequest.toString());
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }
}
