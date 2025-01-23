package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

public class Coffee {
    private String name;
    private int price;
    private int purchasePrice;
    private int stock;
    private int safetyStock;
    private int salesCnt;

    public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt) {
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.stock = stock;
        this.safetyStock = safetyStock;
        this.salesCnt = salesCnt;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public int getStock() {
        return stock;
    }

    public int getSafetyStock() {
        return safetyStock;
    }

    public int getSalesCnt() {
        return salesCnt;
    }

    // 재고를 차감하고
    // 판매량을 추가하는 것
    public void provide(int orderCnt) {
        deductStock(orderCnt);
        addSalesCnt(orderCnt);
    }

    private void addSalesCnt(int orderCnt) {
        salesCnt += orderCnt;
    }

    private void deductStock(int orderCnt) {
        stock -= orderCnt;
        if(stock < safetyStock){
            int purchaseCnt = safetyStock * 2;
            Purchase purchase = new Purchase(this, purchaseCnt);
            purchase.proceed();
        }
    }

    public void addStock(int cnt) {
        stock += cnt;
    }
}
