package com.RidderApp.uberApp.services;

import com.RidderApp.uberApp.entities.Payment;
import com.RidderApp.uberApp.entities.Ride;
import com.RidderApp.uberApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
