package com.zge.leetcode;

public class _05_LongestPalindromicSubstring {

    /*
    * Time complexity: O(n^2)
    * Space complexity: O(1)
    * */
    public String longestPalindrome(String s){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right++;
        }

        return s.substring(left+1, right);
    }

        public String longestPalindrome2(String s) {
            if (s == null || s.length() < 1) return "";

            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }

}
