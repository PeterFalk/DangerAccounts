package com.accounts;


public class AccountDanger implements Runnable {

    private Account jointAccount = new Account();
    public static void main(String[] args) {
        AccountDanger workAccount = new AccountDanger();

        Thread one = new Thread(workAccount);
        Thread two = new Thread(workAccount);
        one.setName("Fred");
        two.setName("Lucy");

        one.start();
        two.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            makeWithdrawal(10);
            if (jointAccount.getBalance() < 10) {
                System.out.println("The account is overdrawn and its values is " + jointAccount.getBalance());
            }
        }

    }

    private synchronized void makeWithdrawal(int amount) {
        if (jointAccount.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw 10 dollars. Current Balance when checked is " + jointAccount.getBalance());
            try {
                Thread.sleep(500);

            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " was interrupted " + ie.getMessage());
            }
            jointAccount.withdrawAmount(10);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal. Balance is: " + jointAccount.getBalance());
        } else {
            System.out.println(Thread.currentThread().getName() + " Not enough money in the account to withdraw " + jointAccount.getBalance());
        }


    }
}
