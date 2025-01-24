package com.mc.coffeemanager.domain.coffee;

import java.time.LocalDate;
import java.time.Month;

public class SeasonCoffee extends Coffee {

    private Month[] seasonMonth;

    public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt, Month[] seasonMonth) {
        super(name, price, purchasePrice, stock, safetyStock, salesCnt);
        this.seasonMonth = seasonMonth;
    }

    public boolean isSeason() {
        int nowMonth = LocalDate.now().getMonthValue();
        for (Month month : seasonMonth) {
            if (nowMonth == month.getValue()) return true;
        }

        return false;
    }
}
