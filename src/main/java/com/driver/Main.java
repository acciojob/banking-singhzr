package com.driver;

public class Main {
    public static void main(String[] args) {
        BankAccount A = new SavingsAccount("S", 1000, 2, 5);

        try{
            A.withdraw(700);
            A.withdraw(300);
            System.out.println(A.getBalance());
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}