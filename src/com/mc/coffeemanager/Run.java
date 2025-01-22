package com.mc.coffeemanager;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.sale.Sale;
import com.mc.coffeemanager.presentation.Menu;

public class Run {

    public static void main(String[] args) {
        Coffee americano = new Coffee("americano", 1000, 500, 10, 3, 0);
        Coffee mocha = new Coffee("mocha", 2000, 800, 10, 3, 0);
        Coffee latte = new Coffee("latte", 3000, 1000, 10, 3, 0);
        Coffee espresso = new Coffee("espresso", 10000, 4000, 10, 3, 0);

        Coffee[] coffees = {americano, mocha, latte, espresso};
        new Menu(new Sale(), Account.getInstance(100000), coffees).proceed();
    }
}
