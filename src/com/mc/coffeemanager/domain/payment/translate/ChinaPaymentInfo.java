package com.mc.coffeemanager.domain.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class ChinaPaymentInfo extends PaymentDecorator{

    public ChinaPaymentInfo(PaymentTranslator target) {
        super(target);
    }

    @Override
    public String getOrderName() {

        String orderName = target.getOrderName();
        Payment payment = target.getPayment();
        String coffee = payment.getCoffeeName();

        return "";
    }

    @Override
    public String getPaymentPrice() {
        return "";
    }
}
