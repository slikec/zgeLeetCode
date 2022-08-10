package com.zge.leetcode;

/*
 * Time complexity O(n)
 * Space complexity O(1)
 * */
public class _680_ValidPalindromeII {
    private static boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static boolean validPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;

        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return (checkPalindrome(s, i, j-1) || checkPalindrome(s, i+1, j));
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "abca";

        System.out.println(validPalindrome(s));
    }
}
