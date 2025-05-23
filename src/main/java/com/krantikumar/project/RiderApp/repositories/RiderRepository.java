package com.krantikumar.project.RiderApp.repositories;

import com.krantikumar.project.RiderApp.entities.Rider;
import com.krantikumar.project.RiderApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository extends JpaRepository<Rider, Long> {
    Optional<Rider> findByUser(User user);
}
