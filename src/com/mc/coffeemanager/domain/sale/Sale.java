package com.mc.coffeemanager.domain.sale;

import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.Payment;
import com.mc.coffeemanager.domain.payment.translate.Language;
import com.mc.coffeemanager.domain.payment.translate.PaymentTranslator;
import com.mc.coffeemanager.domain.payment.translate.SpainPaymentInfo;

import java.util.List;

public class Sale {

    private List<Language> langs;

    public Sale(List<Language> langs) {
        this.langs = langs;
    }

    public PaymentTranslator takeOrder(Order order) {
        order.proceed();
        Payment payment = new Payment(order);
        payment.proceed();
        return translatePayment(payment);
    }

    private PaymentTranslator translatePayment(Payment payment) {
        PaymentTranslator temp = payment;
        for (Language lang : langs) {
            temp = Language.createPaymentTranslator(lang, temp);
        }

        return temp;
    }


}
