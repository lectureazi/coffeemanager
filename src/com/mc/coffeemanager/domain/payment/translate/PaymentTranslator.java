package com.mc.coffeemanager.domain.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public interface PaymentTranslator {
    String getOrderName();
    String getPaymentPrice();
    Payment getPayment();
}
