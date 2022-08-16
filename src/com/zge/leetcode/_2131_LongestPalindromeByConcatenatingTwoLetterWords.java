package com.zge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _2131_LongestPalindromeByConcatenatingTwoLetterWords {

    //#1 HashMap
    //Time complexity: O(N) ?
    //Space complexity: O(N) ?

    public static int longestPalindrome(String[] words){
        int count = 0;
        boolean onlyDuplicate = false;
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            if(!map.containsKey(word)){
                map.put(word, 1);
            }else{
                map.put(word, map.get(word) + 1);
            }
        }

        for(String word : words){
            String ch = reverseString(word);

            if(ch.equals(word) && map.get(ch) > 0){
                if(!onlyDuplicate && map.get(ch) % 2 != 0){
                    count += 2;
                    onlyDuplicate = true;
                }
                count += map.get(ch) / 2 * 4;
                map.put(ch, 0);
                continue;
            }

            if(map.containsKey(ch) && map.get(ch) > 0 && map.get(word) > 0){
                map.put(ch, map.get(ch) - 1);
                map.put(word, map.get(word) - 1);
                count += 4;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"lc", "cl", "gg"};
//        System.out.println(longestPalindrome(words));

        String rev = "ab";
        System.out.println(reverseString(rev));
    }

    public static String reverseString(String s){
        String rev = s.charAt(1) + Character.toString(s.charAt(0));

        return rev;
    }
}
