package com.krantikumar.project.RiderApp.repositories;

import com.krantikumar.project.RiderApp.entities.Driver;
import com.krantikumar.project.RiderApp.entities.Ride;
import com.krantikumar.project.RiderApp.entities.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    Page<Ride> findByRider(Rider rider, Pageable pageRequest);

    Page<Ride> findByDriver(Driver driver, Pageable pageRequest);
}
