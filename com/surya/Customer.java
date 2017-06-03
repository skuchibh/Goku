package com.surya;

/**
 * Created by skuchibh on 4/24/2017.
 */
public class Customer {
    private String name;
    private double balance;
    private int numbersss;
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
