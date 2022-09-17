package com.zge.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _03_LongestSubstringWithoutRepeatingChar {

    /*
    * Sliding Window
    * Time complexity: O(2n). In the worth case each char will visit twice by i and j.
    * Space complexity: O(k). Size of set.
    * */
    public static int lengthOfLongestSubstring(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        int maxSub = 0;
        int left = 0, right = 0;

        while(right < s.length()){
            char r = s.charAt(right);
            map.put(r, map.getOrDefault(r, 0) + 1);

            while(map.get(r) > 1){
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }

            maxSub = Math.max(maxSub, right - left + 1);

            right++;
        }

        return maxSub;
    }

    /*
    * Time complexity: O(n)
    * Space complexity: O(min(m,n))
    * */
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();
        int ans = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0, j = 0; j < n; j++){
            char r = s.charAt(j);
            if(map.containsKey(r)){
                i = Math.max(map.get(r), i);
            }

            ans = Math.max(ans, j - i + 1);
            map.put(r, j + 1);
        }

        return ans;
    }

    /*
    * Time complexity: O(n)
    * Space complexity: O(m). Based on array size.
    * */

    public static int lengthOfLongestSubstring3(String s){
        //128 Size of ASCII
        Integer[] chars = new Integer[128];
        Arrays.fill(chars,-1);

        int left = 0, right = 0;
        int ans = 0;

        while(right < s.length()){
            char r = s.charAt(right);
            Integer index = chars[r];

            //Move the left pointer
            if(index != -1 && index >= left && index < right){
                left = chars[r] + 1;
            }

            ans = Math.max(ans, right - left + 1);

            chars[r] = right;
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
}
