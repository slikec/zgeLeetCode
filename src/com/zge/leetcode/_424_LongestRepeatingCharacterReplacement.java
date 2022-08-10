package com.zge.leetcode;


public class _424_LongestRepeatingCharacterReplacement {

    //#1 Sliding window using Array
    //Time complexity: O(N)
    //Space complexity: O(26), can seem as constant.
    public static int characterReplacement(String s, int k){
        int ns = s.length();
        if(s == null || ns == 0) return 0;

        int[] output = new int[26];
        int maxS = 0, res = 0;

        for(int i = 0; i < ns; i++){
            //ASCII
            // 'A' - 'A' = 0
            // 'B' - 'A' = 1
            // 'C' - 'A' = 2
            maxS = Math.max(maxS, ++output[s.charAt(i) - 'A']);
            if(res - maxS < k){
                res++;
            }else{
                output[s.charAt(i - res) - 'A']--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBACCCCC";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
