package com.mc.coffeemanager.domain.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class SpainPaymentInfo extends PaymentDecorator {

    public SpainPaymentInfo(PaymentTranslator target) {
        super(target);
    }

    @Override
    public String translateOrderName() {
        String orderName = target.translateOrderName();
        Payment payment = target.getTarget();

        // 디미터의 법칙을 위반한다.
        // 도메인 객체가 아니라 데이터를 저장하기 위한 용도로 사용하는 객체들 (DTO, VO)이라면 상관없다.
        // String coffee = payment.getOrder().getCoffee().getName();
        String coffee = payment.getCoffeeName();
        int orderCnt = payment.getOrderCnt();
        orderName += ", " + orderCnt + " tazas de " + coffee;
        return orderName;
    }

    @Override
    public String translatePaymentPrice() {
        Payment payment = target.getTarget();
        int paymentPrice = payment.getPaymentPrice();
        double eur = (double) paymentPrice / 1400;
        return target.translatePaymentPrice() + String.format(", %.2f eur", eur);
    }

    @Override
    public Payment getTarget() {
        return target.getTarget();
    }
}
