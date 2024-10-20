package com.RidderApp.uberApp.repositories;

import com.RidderApp.uberApp.entities.Driver;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    @Query(value = "SELECT d.*, ST_Distance(d.current_location, :pickupLocation) As distance" +
            "fROM driver d " +
            "WHERE d.available = true and ST_DWithin(d.current_location, :pickupLocation,10000) " +
            "ORDER BY distance" +
            "LIMIT 10", nativeQuery = true
    )
    List<Driver> findTenNearestDrivers(Point pickupLocation);
}
