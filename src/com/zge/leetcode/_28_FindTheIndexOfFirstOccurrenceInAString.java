package com.zge.leetcode;

import java.util.HashSet;

public class _28_FindTheIndexOfFirstOccurrenceInAString {

    /*
    * Time complexity: O((n-m)*m)
    * Space complexity: O((n-m)*m)
    * */
    public int strStr(String haystack, String needle){
        int n = haystack.length(), m = needle.length();

        for(int i = 0; i + m < n + 1; i++){
            String str = haystack.substring(i, i + m);
            if(str.equals(needle)){
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle){
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
