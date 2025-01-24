package com.mc.coffeemanager.domain.order;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.code.OrderStatus;
import com.mc.coffeemanager.domain.coffee.Coffee;

import java.time.LocalDateTime;

public class Order {
    private String name;
    private Coffee coffee;
    private int orderCnt;
    private int orderPrice;
    private LocalDateTime orderTime;
    private OrderStatus status;

    public static Order createOrder(Coffee coffee, int orderCnt) {
        Order order = new Order(coffee, orderCnt);
        order.status = OrderStatus.checkStatus(coffee, orderCnt);
        return order;
    }

    private Order(Coffee coffee, int orderCnt) {
        this.name = coffee.getName() + "[" + orderCnt + "잔]";
        this.coffee = coffee;
        this.orderCnt = orderCnt;
        this.orderTime = LocalDateTime.now();
        this.orderPrice = coffee.getPrice() * orderCnt;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getOrderCnt() {
        return orderCnt;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void proceed() {
        coffee.provide(orderCnt);
    }

    public String getCoffeeName() {
        return coffee.getName();
    }
}
