package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.order.Order;

public class Payment {

    private Order order;
    private int paymentPrice;

    public Payment(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void proceed() {
        calPaymentPrice();
        Account account = Account.getInstance();
        account.registSales(paymentPrice);
    }

    private void calPaymentPrice() {
        this.paymentPrice = order.getOrderPrice();
    }
}
