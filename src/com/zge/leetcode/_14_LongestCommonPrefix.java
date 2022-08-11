package com.zge.leetcode;

public class _14_LongestCommonPrefix {

    //#1 Horizontal scanning
    //Time complexity: O(S) S is the sum of all characters in all strings
    //Space complexity: O(1)
    static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        //initial prefix as str[0]
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            // .indexOf means find prefix index of strs.
            while(strs[i].indexOf(prefix) != 0){
                //Remove last character
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
