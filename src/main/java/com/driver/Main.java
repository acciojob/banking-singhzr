package com.driver;

public class Main {
    public static void main(String[] args) {

        BankAccount A = new SavingsAccount("Suraj", 100, 1, 5);
        try {

            A.withdraw(100.0);
            A.withdraw(1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}