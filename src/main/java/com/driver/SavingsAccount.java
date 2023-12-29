package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;


    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance,0);
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws Exception {

        if(amount>maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }

        super.withdraw (amount);
    }
    public double getRate() {

        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setMaxWithdrawalLimit(double maxWithdrawalLimit) {
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double totaBbalance = super.getBalance();
        double SimpleInterest = totaBbalance*(rate/100)*years;

        return totaBbalance+SimpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double P = getBalance();
        double r = rate/100;
        int n = times;
        int t = years;
        double A = P * (Math.pow((1 + (r/n)), (n*t)));
        return A;
    }
}
