package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {

        double balanceRemaining = getBalance();
        if(maxWithdrawalLimit == 0){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(balanceRemaining - amount < 0){
            throw new Exception("Insufficient Balance");
        }else{
            balance = balanceRemaining-amount;
            maxWithdrawalLimit--;
        }

    }
    public double getRate() {
        return rate;
    }

    public double getSimpleInterest(int years){
        double balanceRemaining = getBalance();
        return balanceRemaining + (balanceRemaining * rate * years) / 100;
    }

    public double getCompoundInterest(int times, int years){
        double balanceRemaining = getBalance();
        double compoundAmount = balanceRemaining * Math.pow(1 + (rate / 100 / times), times * years);
        return compoundAmount;
    }
}
