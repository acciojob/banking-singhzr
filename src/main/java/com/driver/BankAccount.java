package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    //    public BankAccount(){
//
//    }
    public BankAccount(String name, double balance, double minBalance) {

        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
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

        if (this.balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        this.balance -= amount;
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
