package com.zge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _13_RomanToInteger {
    static int romanToInt(String s){
        //Create romans numerals
        Map<Character, Integer> romanMap = new HashMap<>();
        //Fill the map
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L',50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        //Length of strings
        int n = s.length();
        //Variable to store result
        int num = romanMap.get(s.charAt(n - 1));
        //Loop for each character from right to left
        for(int i = n - 2; i >= 0; i--){
            //Check if the character at right of current character is bigger or smaller
            int a = romanMap.get(s.charAt(i));
            int b = romanMap.get(s.charAt(i+1));
            if(a >= b){
                num += a;
            }else{
                num -= a;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println(romanToInt(s));
    }
}
