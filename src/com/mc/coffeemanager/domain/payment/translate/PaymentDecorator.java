package com.mc.coffeemanager.domain.payment.translate;

public abstract class PaymentDecorator implements PaymentTranslator{

    protected PaymentTranslator target;

    public PaymentDecorator(PaymentTranslator target) {
        this.target = target;
    }
}
