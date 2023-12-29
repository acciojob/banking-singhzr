package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public String getInstitutionName() {
        return institutionName;
    }

    public StudentAccount(String name, double balance, String institutionName) {
        super(name, 0);
        this.institutionName = institutionName;
    }

}
