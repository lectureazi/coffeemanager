package com.mc.coffeemanager;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.coffee.SeasonCoffee;
import com.mc.coffeemanager.domain.payment.translate.Language;
import com.mc.coffeemanager.domain.sale.Sale;
import com.mc.coffeemanager.presentation.Menu;

import java.time.Month;
import java.util.List;

public class Run {

    public static void main(String[] args) {
        Coffee americano = new Coffee("americano", 1000, 500, 10, 3, 0);
        Coffee mocha = new Coffee("mocha", 2000, 800, 10, 3, 0);
        Coffee latte = new Coffee("latte", 3000, 1000, 10, 3, 0);
        Coffee espresso = new SeasonCoffee("espresso", 10000, 4000
                , 10, 3, 0, new Month[]{Month.JULY, Month.AUGUST, Month.OCTOBER});

        Coffee[] coffees = {americano, mocha, latte, espresso};
        List<Language> langs = List.of(Language.SPAIN, Language.USA);
        new Menu(new Sale(langs), Account.getInstance(100000), coffees).proceed();
    }
}
