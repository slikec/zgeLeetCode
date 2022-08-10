package com.zge.leetcode;

/*
Time complexity: O(|T|)
Space complexity: O(1)
*/
public class _392_IsSubsequence {
    public static boolean isSubsequence(String s, String t){
        int left = 0;
        int right = 0;

        while(left<s.length() && right <t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left += 1;
            }
            right += 1;
        }
        return left == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));

    }
}
