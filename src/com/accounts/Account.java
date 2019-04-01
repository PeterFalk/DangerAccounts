package com.accounts;

public class Account {
    private int balance = 50;

    public int getBalance() {
        return balance;
    }

    public void withdrawAmount(int amount) {
        balance = balance - amount;
    }
}
