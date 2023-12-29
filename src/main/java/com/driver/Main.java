package com.driver;

public class Main {
    public static void main(String[] args) {
        SavingsAccount A = new SavingsAccount("S", 1000, 1, 5);

        try{
            A.withdraw(600);
            A.withdraw(100);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(A.getCompoundInterest(5,2));
    }
}