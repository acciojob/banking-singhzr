package com.driver;

public class BankAccount {

    public double getMinBalance() {
        return minBalance;
    }

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {

        String account = accountNumber(digits, sum);
        if(account == null){
            throw new Exception("Account Number can not be generated");
        }
        return account;
    }

    public void deposit(double amount) {
        balance = balance + amount;

    }

    public void withdraw(double amount) throws Exception {
        double newBalance = balance - amount;
        if (newBalance < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance = balance - amount;
    }

    public  String accountNumber(int digits, int sum) throws Exception {
        if (digits <= 0 || sum < 0 || sum > digits * 9) {
            return null;
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
