package com.jitterted.ebp.blackjack;


//CMD+SHIFT+T
public class Wallet {
    private int balance = 0;

    public boolean isEmpty() {
        return balance == 0;
    }

    public void addMoney(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Money should be positive");
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
