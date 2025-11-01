package com.RidderApp.uberApp.dto;

import com.RidderApp.uberApp.entities.Ride;
import com.RidderApp.uberApp.entities.Wallet;
import com.RidderApp.uberApp.entities.enums.TransactionMethod;
import com.RidderApp.uberApp.entities.enums.TransactionType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {

    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;

    private String transactionId;

    private WalletDto wallet;

    private LocalDateTime timeStamp;

}
