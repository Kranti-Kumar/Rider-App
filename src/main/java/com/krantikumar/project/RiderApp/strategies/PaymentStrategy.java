package com.krantikumar.project.RiderApp.strategies;

import com.krantikumar.project.RiderApp.entities.Payment;

public interface PaymentStrategy {
    Double PLATFORM_COMMISSION = 0.3;
    void processPayment(Payment payment);

}
