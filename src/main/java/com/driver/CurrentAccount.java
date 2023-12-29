package com.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000);
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        if(balance<5000){
            throw new Exception ("Insufficient Balance");
        }

        this.tradeLicenseId = tradeLicenseId;
    }
    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(!isValid(this.tradeLicenseId)) {
            String ans = orgString(this.tradeLicenseId);
            if(ans.length()==0) {
                throw new Exception("Valid License can not be generated");
            }
            else {
                this.tradeLicenseId = ans;
            }
        }
    }

    private boolean isValid(String s) {
        for(int i = 1;i < s.length(); i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public String orgString(String s) throws Exception {

        Map<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char key : hm.keySet()) {

            maxHeap.offer(new int[]{key, hm.get(key)});
        }

        StringBuilder res = new StringBuilder();
        int[] prev = new int[]{'*', 0};

        while (!maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            res.append((char) current[0]);
            if (prev[1] > 0) {
                maxHeap.offer(prev);
            }

            current[1]--;
            prev = current;
        }
        return s;
    }
}
