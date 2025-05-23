package com.krantikumar.project.RiderApp.repositories;

import com.krantikumar.project.RiderApp.entities.User;
import com.krantikumar.project.RiderApp.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findByUser(User user);
}
