package com.mc.coffeemanager.domain.discount;

import com.mc.coffeemanager.domain.discount.policy.PercentDiscountPolicy;
import com.mc.coffeemanager.domain.order.Order;

public class PercentDiscount {

    public static int calDiscount(Order order) {
        int discount = 0;

        for (PercentDiscountPolicy e : PercentDiscountPolicy.values()) {
            if (e.checkRange(order)) {
                discount = (int) (order.getOrderPrice() * e.rate());
            }
        }

        return discount;
    }
}
