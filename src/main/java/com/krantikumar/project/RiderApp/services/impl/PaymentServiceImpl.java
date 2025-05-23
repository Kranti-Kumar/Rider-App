package com.krantikumar.project.RiderApp.services.impl;

import com.krantikumar.project.RiderApp.entities.Payment;
import com.krantikumar.project.RiderApp.entities.Ride;
import com.krantikumar.project.RiderApp.entities.enums.PaymentStatus;
import com.krantikumar.project.RiderApp.exceptions.ResourceNotFoundException;
import com.krantikumar.project.RiderApp.repositories.PaymentRepository;
import com.krantikumar.project.RiderApp.services.PaymentService;
import com.krantikumar.project.RiderApp.strategies.PaymentStrategyManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentStrategyManager paymentStrategyManager;

    @Override
    public void processPayment(Ride ride) {
        Payment payment = paymentRepository.findByRide(ride)
                        .orElseThrow(() -> new ResourceNotFoundException("Payment not found for ride with id: "+ride.getId()));
        paymentStrategyManager.paymentStrategy(payment.getPaymentMethod()).processPayment(payment);
    }

    @Override
    public Payment createNewPayment(Ride ride) {
        Payment payment = Payment.builder()
                .ride(ride)
                .paymentMethod(ride.getPaymentMethod())
                .amount(ride.getFare())
                .paymentStatus(PaymentStatus.PENDING)
                .build();
        return paymentRepository.save(payment);
    }

    @Override
    public void updatePaymentStatus(Payment payment, PaymentStatus status) {
        payment.setPaymentStatus(status);
        paymentRepository.save(payment);
    }
}
