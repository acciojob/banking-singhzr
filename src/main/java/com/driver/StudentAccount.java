package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, balance);
        this.institutionName = institutionName;
    }
    public String getInstitutionName() {
        return institutionName;
    }
}
