package com.mc.coffeemanager.domain.account;

public class Account {

    private int balance;
    private int sales;
    private int expenses;

    private static Account INSTANCE;

    public static Account getInstance(int balance) {
        if (INSTANCE == null) {
            INSTANCE = new Account(balance);
        }

        return INSTANCE;
    }

    public static Account getInstance() {
        return INSTANCE;
    }

    private Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public int getSales() {
        return sales;
    }

    public int getExpenses() {
        return expenses;
    }

    public boolean registExpenses(int price) {
        if (balance < price) return false;
        balance -= price;
        expenses += price;
        return true;
    }

    public void registSales(int price) {
        balance += price;
        sales += price;
    }
}
