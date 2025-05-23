package com.krantikumar.project.RiderApp.repositories;

import com.krantikumar.project.RiderApp.entities.Driver;
import com.krantikumar.project.RiderApp.entities.Rating;
import com.krantikumar.project.RiderApp.entities.Ride;
import com.krantikumar.project.RiderApp.entities.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByRider(Rider rider);
    List<Rating> findByDriver(Driver driver);

    Optional<Rating> findByRide(Ride ride);
}
