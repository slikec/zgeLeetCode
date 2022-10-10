package com.zge.leetcode;

import java.util.Arrays;

public class _567_PermutationInString {

    /*
    * Sliding window
    * Time complexity: O(l1 + 26 * (l2 - l1))
    * Space complexity: O(1)
    * */
    public boolean checkInclusion(String s1, String s2){
        //s1 and s2 only lowercase letters. 26 is enough for it.
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for(char c : s1.toCharArray()){
            s1Map[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = 0, valid = s1.length();

        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;

            s2Map[c - 'a']++;
            count++;

            while(count == valid){
//                if(Arrays.equals(s1Map, s2Map)) return true;
                if(compareArray(s1Map, s2Map)) return true;
                char deleteChar = s2.charAt(left);
                left++;

                s2Map[deleteChar - 'a']--;
                count--;
            }
        }
        return false;
    }

    private boolean compareArray(int[] s1, int[] s2){
        for(int i = 0; i < 26; i++){
            if(s1[i] != s2[i]) return false;
        }
        return true;
    }

    /*
     * Time complexity: O(l1 + (l2 - l1))
     * Space complexity: O(1)
    * */
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (s1map[i] == s2map[i])
                count++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a';
            int l = s2.charAt(i) - 'a';

            if (count == 26) return true;
            s2map[r]++;

            if (s2map[r] == s1map[r]) {
                count++;
            } else if (s2map[r] == s1map[r] + 1) {
                count--;
            }

            s2map[l]--;
            if (s2map[l] == s1map[l]) {
                count++;
            } else if (s2map[l] == s1map[l] - 1) {
                count--;
            }
        }
        return count == 26;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "eidbaooo";

//        System.out.println(checkInclusion(s1, s2));
    }
}
