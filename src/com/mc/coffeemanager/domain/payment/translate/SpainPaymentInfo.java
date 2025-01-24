package com.mc.coffeemanager.domain.payment.translate;

public class SpainPaymentInfo extends PaymentDecorator {

    public SpainPaymentInfo(PaymentTranslator target) {
        super(target);
    }

    @Override
    public String getOrderName() {
        return "";
    }

    @Override
    public String getPaymentPrice() {
        return "";
    }
}
