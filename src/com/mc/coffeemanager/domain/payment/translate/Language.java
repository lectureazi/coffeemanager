package com.mc.coffeemanager.domain.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public enum Language {
    USA,
    CHINA,
    SPAIN;
    
    public static PaymentTranslator createPaymentTranslator(Language lang, PaymentTranslator target) {
        return switch (lang){
            case USA -> new UsaPaymentInfo(target);
            case CHINA -> new ChinaPaymentInfo(target);
            case SPAIN -> new SpainPaymentInfo(target);
            default -> throw new IllegalStateException("Unexpected value: " + lang);
        };
    }

}
