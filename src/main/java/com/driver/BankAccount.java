package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {

        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {

        String account = accountNumber(digits, sum);

        return account;
    }

    public void deposit(double amount) {
        balance += amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        try {
            double newBalance = balance - amount;
            if (newBalance < minBalance) {

            }
        } catch (Exception e) {
            throw new Exception("Insufficient Balance");
        }
    }

    public  String accountNumber(int digits, int sum) throws Exception {
        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            throw new Exception("Account Number can not be generated");
        }

        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits - 1; i++) {
            int digit = Math.min(9, sum);
            accountNumber.append(digit);
            sum -= digit;
        }

        if (sum >= 0 && sum <= 9) {
            accountNumber.append(sum);
        }
        else {
            return null;
        }

        return accountNumber.toString();
    }
}
