package com.mc.coffeemanager.domain.payment.translate;

public class UsaPaymentInfo extends PaymentDecorator{

    public UsaPaymentInfo(PaymentTranslator target) {
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
