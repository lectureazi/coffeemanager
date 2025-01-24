package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.discount.PercentDiscount;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.translate.PaymentTranslator;

public class Payment implements PaymentTranslator {

    private Order order;
    private int paymentPrice;

    public Payment(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public String getOrderName() {
        return order.getName();
    }

    @Override
    public String getPaymentPrice() {
        return String.valueOf(paymentPrice);
    }

    @Override
    public Payment getPayment() {
        return this;
    }

    public void proceed() {
        calPaymentPrice();
        Account account = Account.getInstance();
        account.registSales(paymentPrice);
    }

    private void calPaymentPrice() {
        int discount = PercentDiscount.calDiscount(order);
        this.paymentPrice = order.getOrderPrice() - discount;
    }

    public String getCoffeeName() {
        return order.getCoffeeName();
    }
}
