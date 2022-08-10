package com.zge.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/*
Time complexity: O(N)
Space complexity: O(1)
*/

public class _409_LongestPalindrome {
    public static int longestPalindrome(String s){
        int longest = 0;
        int[] letter = new int[128];

        for(char c : s.toCharArray()){
            letter[c]++;
//            System.out.println("Character: " + c);
//            System.out.println("Arrays: " + letter[c]);
        }

        for(int v : letter){
            longest += v / 2 * 2;
        }

        //If longest less than s.length() and is even number, then +1;
        if(longest<s.length()) longest += 1;

        return longest;
    }

    public static void main(String[] args) {
        String s = "abccccdd";

        System.out.println(longestPalindrome(s));
    }
}
