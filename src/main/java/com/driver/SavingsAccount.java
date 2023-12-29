package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    double totalBalance = 0;

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getBalance() {
        return totalBalance;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance);
        this.totalBalance = balance;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {

        double balanceRemaining = totalBalance;
        if(maxWithdrawalLimit == 0){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(balanceRemaining - amount < 0){
            throw new Exception("Insufficient Balance");
        }else{
            totalBalance = balanceRemaining-amount;
            maxWithdrawalLimit--;
        }

    }
    public double getRate() {
        return rate;
    }

    public double getSimpleInterest(int years){
        double balanceRemaining = totalBalance;
        return balanceRemaining + (balanceRemaining * rate * years) / 100;
    }

    public double getCompoundInterest(int times, int years){
        double balanceRemaining = totalBalance;
        double compoundAmount = balanceRemaining * Math.pow(1 + (rate / 100 / times), times * years);
        return compoundAmount + balanceRemaining;
    }
}
