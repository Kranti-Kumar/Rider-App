package com.krantikumar.project.RiderApp.strategies;

import com.krantikumar.project.RiderApp.entities.enums.PaymentMethod;
import com.krantikumar.project.RiderApp.strategies.impl.CashPaymentStrategy;
import com.krantikumar.project.RiderApp.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final WalletPaymentStrategy walletPaymentStrategy;
    private final CashPaymentStrategy cashPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return switch (paymentMethod) {
            case WALLET -> walletPaymentStrategy;
            case CASH -> cashPaymentStrategy;
        };
    }
}
