package com.zge.leetcode;

import java.util.HashMap;

public class _299_BullsAndCows {

    //#1 HashMap: Two Passes
    //Time complexity: O(N)
    //Space complexity: O(1)
    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> secretMap = new HashMap<>();
        int bulls = 0, cows = 0;

        for (char ch : secret.toCharArray()) {
            if (secretMap.containsKey(ch)) {
                secretMap.put(ch, secretMap.get(ch) + 1);
            } else {
                secretMap.put(ch, 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (secretMap.containsKey(ch)) {
                if (secret.charAt(i) == ch) {
                    bulls++;
                    if (secretMap.get(ch) <= 0) cows--;
                }else{
                    if(secretMap.get(ch) > 0) cows++;
                }
                secretMap.put(ch, secretMap.get(ch) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }

    //#2 Array: One pass
    public static String getHint2(String secret, String guess){
        //Numbers: 0-9
        int[] arr = new int[10];

        int bulls = 0, cows= 0;
        int n = guess.length();

        for(int i = 0; i < n; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if(s==g){
                bulls++;
            }else{
                if(arr[s - '0'] < 0) cows++;
                if(arr[g - '0'] > 0) cows++;

                arr[s - '0']++;
                arr[g - '0']--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls);
        sb.append("A");
        sb.append(cows);
        sb.append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        String secret = "1123";
        String guess = "0111";

        System.out.println(getHint(secret, guess));
        System.out.println(getHint2(secret, guess));
    }
}
