package com.krantikumar.project.RiderApp.repositories;

import com.krantikumar.project.RiderApp.entities.Payment;
import com.krantikumar.project.RiderApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRide(Ride ride);
}
