package com.mc.coffeemanager.domain.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public interface PaymentTranslator {
    String translateOrderName();
    String translatePaymentPrice();
    Payment getTarget();
}
