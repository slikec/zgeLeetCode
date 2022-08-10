package com.zge.leetcode;

import java.util.HashMap;

/*
* Time complexity: O(N)
* Space complexity: O(M)
* */

public class _290_WordPattern {
    public static boolean wordPattern(String pattern, String s){
        HashMap mapIndex = new HashMap();
        String[] words = s.split(" ");
        System.out.println(words.length);
        System.out.println(pattern.length());

        if(words.length != pattern.length()) return false;

        for(int i = 0; i < words.length; i++){
            //Using different data type to avoid same hash key
            char c = pattern.charAt(i);
            String w = words[i];

            if(!mapIndex.containsKey(c)){
                mapIndex.put(c, i);
            }

            if(!mapIndex.containsKey(w)){
                mapIndex.put(w, i);
            }

            //Using .equals instead of ==.
            //Integer values from -128 to 127
            //(Integer)127 == (Integer)127, but (Integer)128 != (Integer)128
            if(!mapIndex.get(c).equals(mapIndex.get(w))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String pattern = "abba";
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
//        String s = "dog cat cat dog";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";

        System.out.println(wordPattern(pattern, s));
    }
}
