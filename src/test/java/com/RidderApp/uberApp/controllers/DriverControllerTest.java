package com.RidderApp.uberApp.controllers;

import com.RidderApp.uberApp.dto.*;
import com.RidderApp.uberApp.services.DriverService;
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
class DriverControllerTest {

    @Mock
    private DriverService driverService;

    @InjectMocks
    private DriverController driverController;

    private RideDto rideDto;
    private DriverDto driverDto;
    private RiderDto riderDto;
    private RatingDto ratingDto;
    private RideStartDto rideStartDto;

    @BeforeEach
    void setUp() {
        rideDto = new RideDto();
        rideDto.setId(1L);

        driverDto = new DriverDto();
        driverDto.setId(1L);

        riderDto = new RiderDto();
        riderDto.setId(1L);

        ratingDto = new RatingDto();
        ratingDto.setRideId(1L);
        ratingDto.setRating(4);

        rideStartDto = new RideStartDto();
        rideStartDto.setOtp("1234");
    }

    @Test
    void testAcceptRide_success() {
        // Arrange
        Long rideRequestId = 1L;
        when(driverService.acceptRide(rideRequestId)).thenReturn(rideDto);

        // Act
        ResponseEntity<RideDto> response = driverController.acceptRide(rideRequestId);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).acceptRide(rideRequestId);
    }

    @Test
    void testStartRide_success() {
        // Arrange
        Long rideRequestId = 1L;
        when(driverService.startRide(eq(rideRequestId), eq("1234"))).thenReturn(rideDto);

        // Act
        ResponseEntity<RideDto> response = driverController.startRide(rideRequestId, rideStartDto);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).startRide(rideRequestId, rideStartDto.getOtp());
    }

    @Test
    void testEndRide_success() {
        // Arrange
        Long rideId = 1L;
        when(driverService.endRide(rideId)).thenReturn(rideDto);

        // Act
        ResponseEntity<RideDto> response = driverController.endRide(rideId);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).endRide(rideId);
    }

    @Test
    void testCancelRide_success() {
        // Arrange
        Long rideId = 1L;
        when(driverService.cancelRide(rideId)).thenReturn(rideDto);

        // Act
        ResponseEntity<RideDto> response = driverController.cancelRide(rideId);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).cancelRide(rideId);
    }

    @Test
    void testRateRider_success() {
        // Arrange
        when(driverService.rateRider(eq(1L), eq(4))).thenReturn(riderDto);

        // Act
        ResponseEntity<RiderDto> response = driverController.rateRider(ratingDto);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).rateRider(ratingDto.getRideId(), ratingDto.getRating());
    }

    @Test
    void testGetMyProfile_success() {
        // Arrange
        when(driverService.getMyProfile()).thenReturn(driverDto);

        // Act
        ResponseEntity<DriverDto> response = driverController.getMyProfile();

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).getMyProfile();
    }

    @Test
    void testGetAllMyRides_success() {
        // Arrange
        Page<RideDto> page = Page.empty();
        when(driverService.getAllMyRides(any(PageRequest.class))).thenReturn(page);

        // Act
        ResponseEntity<Page<RideDto>> response = driverController.getAllMyRides(0, 10);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        verify(driverService).getAllMyRides(any(PageRequest.class));
    }

    @Test
    void testGetAllMyRides_withCustomPagination() {
        // Arrange
        Page<RideDto> page = Page.empty();
        when(driverService.getAllMyRides(any(PageRequest.class))).thenReturn(page);

        // Act
        ResponseEntity<Page<RideDto>> response = driverController.getAllMyRides(1, 15);

        // Assert
        assertThat(response.getStatusCode().value()).isEqualTo(200);
        verify(driverService).getAllMyRides(any(PageRequest.class));
    }
}

