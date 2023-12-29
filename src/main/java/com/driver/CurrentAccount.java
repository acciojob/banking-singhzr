package com.driver;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId;

    private static final double DEFAULT_MIN_BALANCE = 5000;

    public CurrentAccount(String name, String tradeLicenseId) {
        super(name, DEFAULT_MIN_BALANCE);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        char[] licenseChars = tradeLicenseId.toCharArray();
        for (int i = 0; i < licenseChars.length - 1; i++) {
            if (licenseChars[i] == licenseChars[i + 1]) {
                // Rearrange the characters to create a valid license Id
                rearrangeLicenseId();
                return;
            }
        }
        // License Id is already valid
    }

    private void rearrangeLicenseId() throws Exception {
        char[] licenseChars = tradeLicenseId.toCharArray();
        for (int i = 0; i < licenseChars.length - 1; i++) {
            if (licenseChars[i] == licenseChars[i + 1]) {
                // Swap adjacent characters
                char temp = licenseChars[i];
                licenseChars[i] = licenseChars[i + 1];
                licenseChars[i + 1] = temp;
            }
        }
        tradeLicenseId = new String(licenseChars);
        validateLicenseId(); // Recursively validate the rearranged license Id
    }
}
