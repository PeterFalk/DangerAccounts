package com.accounts;

public class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
        // This is the first change made to this file
    }

    public void withdrawAmount(int amount) {
        balance = balance - amount;
    }
}
