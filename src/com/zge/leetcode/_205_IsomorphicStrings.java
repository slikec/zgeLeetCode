package com.zge.leetcode;

import java.util.Arrays;

/*
* Time complexity: O(N)
* Space complexity: O(1)
* */

public class _205_IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;

        //The length of ASCII is 256.
        int[] mappingDictSToT = new int[256];
        int[] mappingDictTToS = new int[256];
        Arrays.fill(mappingDictSToT, -1);
        Arrays.fill(mappingDictTToS, -1);

        for(int i = 0; i < s.length(); i++){
            //Character convert to integer
            //ASCII
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mappingDictSToT[c1] == -1 && mappingDictTToS[c2] == -1){
                mappingDictSToT[c1] = c2;
                mappingDictTToS[c2] = c1;
            } else if (!(mappingDictSToT[c1] == c2 && mappingDictTToS[c2] == c1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paperr";
        String t = "titlel";

        System.out.println(isIsomorphic(s, t));

    }
}
