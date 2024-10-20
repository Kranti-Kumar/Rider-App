package com.RidderApp.uberApp.services.impl;

import com.RidderApp.uberApp.dto.DriverDto;
import com.RidderApp.uberApp.dto.RideDto;
import com.RidderApp.uberApp.dto.RideRequestDto;
import com.RidderApp.uberApp.dto.RiderDto;
import com.RidderApp.uberApp.entities.RideRequest;
import com.RidderApp.uberApp.entities.Rider;
import com.RidderApp.uberApp.entities.User;
import com.RidderApp.uberApp.entities.enums.RideRequestStatus;
import com.RidderApp.uberApp.repositories.RideRequstRepository;
import com.RidderApp.uberApp.repositories.RiderRepository;
import com.RidderApp.uberApp.services.RiderService;
import com.RidderApp.uberApp.strategies.DriverMatchingStrategy;
import com.RidderApp.uberApp.strategies.RideFareCalculationStrategy;
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
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequstRepository rideRequstRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest = rideRequstRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);



        return modelMapper.map(savedRideRequest,RideRequestDto.class);
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

    @Override
    public Rider createNewRider(User user) {
        Rider rider = Rider
                .builder()
                .user(user)
                .rating(0.0)
                .build();
        return riderRepository.save(rider);
    }
}
