package com.RidderApp.uberApp.entities;

import com.RidderApp.uberApp.entities.enums.TransactionMethod;
import com.RidderApp.uberApp.entities.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
public class WalletTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double Amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    private String transactionId;
    @ManyToOne
    private Wallet wallet;

    @CreationTimestamp
    private LocalDate timeStamp;
}
