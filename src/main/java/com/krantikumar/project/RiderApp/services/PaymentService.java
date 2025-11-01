package com.krantikumar.project.RiderApp.services;

import com.krantikumar.project.RiderApp.entities.Payment;
import com.krantikumar.project.RiderApp.entities.Ride;
import com.krantikumar.project.RiderApp.entities.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus status);
}
