package com.RidderApp.uberApp.repositories;

import com.RidderApp.uberApp.entities.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRequstRepository extends JpaRepository<RideRequest ,Long> {
}
