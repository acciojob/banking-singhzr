package com.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {

            Map<Character, Integer> hm = new HashMap<>();
            for (char c : tradeLicenseId.toCharArray()) {
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
            if (res.toString() != tradeLicenseId) {
                throw new Exception("Valid License can not be generated");
            }
    }
}
