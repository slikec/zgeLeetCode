package com.zge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _76_MinimumWindowSubstring {

    /*
    * Sliding window
    * Time complexity: O(|S| + |T|). Worth case we may need go over s twice.
    * Space complexity: O(2 * |T|)
    * */
    public static String minWindow(String s, String t){
        if(t.length() > s.length() || s.length() == 0 || t.length() == 0) return "";

        //Set up t map
        Map<Character, Integer> tMap = new HashMap<>();
        for(char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, start = 0, valid = 0;
        int minSub = Integer.MAX_VALUE;

        while(right < s.length()){

            char c = s.charAt(right);

            right++;

            if(tMap.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                //Integers instead of '==', using .equals.
                if(window.get(c).equals(tMap.get(c))){
                    valid++;
                }
            }

            while(tMap.size() == valid){
                if(right - left < minSub){
                    start = left;
                    minSub = right - left;
                }
//                System.out.printf("window: [%d, %d)\n", left, right);

                char deleteChar = s.charAt(left);
                left++;

                if(tMap.containsKey(deleteChar)){
                    if(window.get(deleteChar).equals(tMap.get(deleteChar))){
                        window.put(deleteChar, window.get(deleteChar) - 1);
                        valid--;
                    }else{
                        window.put(deleteChar, window.get(deleteChar) - 1);
                    }
                }
            }
        }
        System.out.println(start);
        return minSub == Integer.MAX_VALUE ? "" : s.substring(start, start + minSub);
    }

    /*
     * Sliding window
     * Time complexity: O(|S| + |T|). Worth case we may need go over s twice.
     * Space complexity: O(128)
     * */
    public String minWindow2(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE,
                counter = t.length();

        while (end < s.length()) {
            final char c1 = s.charAt(end);

            if (map[c1] > 0) counter--;

            map[c1]--;
            end++;

            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }

                final char c2 = s.charAt(start);

                map[c2]++;

                if (map[c2] > 0) counter++;

                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
