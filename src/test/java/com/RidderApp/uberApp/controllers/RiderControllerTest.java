package com.RidderApp.uberApp.controllers;

import com.RidderApp.uberApp.dto.*;
import com.RidderApp.uberApp.services.RiderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RiderControllerTest {

    @Mock
    private RiderService riderService;

    @InjectMocks
    private RiderController riderController;

    private RideRequestDto rideRequestDto;
    private RideDto rideDto;
    private DriverDto driverDto;
    private RiderDto riderDto;
    private RatingDto ratingDto;

    @BeforeEach
    void setUp() {
        rideRequestDto = new RideRequestDto();
        rideRequestDto.setId(1L);

        rideDto = new RideDto();
        rideDto.setId(1L);

        driverDto = new DriverDto();
        driverDto.setId(1L);

        riderDto = new RiderDto();
        riderDto.setId(1L);

        ratingDto = new RatingDto();
        ratingDto.setRideId(1L);
        ratingDto.setRating(5);
    }

    @Test
    void testRequestRide_success() {
        // Arrange
        when(riderService.requestRide(any(RideRequestDto.class))).thenReturn(rideRequestDto);

        // Act
        ResponseEntity<RideRequestDto> response = riderController.requestRide(rideRequestDto);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(1L);
        verify(riderService).requestRide(rideRequestDto);
    }

    @Test
    void testCancelRide_success() {
        // Arrange
        Long rideId = 1L;
        when(riderService.cancelRide(rideId)).thenReturn(rideDto);

        // Act
        ResponseEntity<RideDto> response = riderController.cancelRide(rideId);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(riderService).cancelRide(rideId);
    }

    @Test
    void testRateDriver_success() {
        // Arrange
        when(riderService.rateDriver(eq(1L), eq(5))).thenReturn(driverDto);

        // Act
        ResponseEntity<DriverDto> response = riderController.rateDriver(ratingDto);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(riderService).rateDriver(ratingDto.getRideId(), ratingDto.getRating());
    }

    @Test
    void testGetMyProfile_success() {
        // Arrange
        when(riderService.getMyProfile()).thenReturn(riderDto);

        // Act
        ResponseEntity<RiderDto> response = riderController.getMyProfile();

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(riderService).getMyProfile();
    }

    @Test
    void testGetAllMyRides_success() {
        // Arrange
        Page<RideDto> page = Page.empty();
        when(riderService.getAllMyRides(any(PageRequest.class))).thenReturn(page);

        // Act
        ResponseEntity<Page<RideDto>> response = riderController.getAllMyRides(0, 10);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(riderService).getAllMyRides(any(PageRequest.class));
    }

    @Test
    void testGetAllMyRides_withCustomPagination() {
        // Arrange
        Page<RideDto> page = Page.empty();
        when(riderService.getAllMyRides(any(PageRequest.class))).thenReturn(page);

        // Act
        ResponseEntity<Page<RideDto>> response = riderController.getAllMyRides(2, 20);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        verify(riderService).getAllMyRides(any(PageRequest.class));
    }
}

