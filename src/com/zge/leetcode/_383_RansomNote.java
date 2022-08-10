package com.zge.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
*Time complexity: O(m)
*Space complexity: O(k)/O(1)
*/

public class _383_RansomNote {
    private static Map<Character, Integer> makeCountsMap(String s){
        Map<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()){
            //getOrDefault: This method returns value mapped with the specified key,
            // otherwise default value is returned.
            int currentCount = counts.getOrDefault(c, 0);
            counts.put(c, currentCount + 1);
        }
        return counts;
    }

    public static boolean canConstruct(String ransomNote, String magazine){
        //Check for obvious fail case.
        if(ransomNote.length() > magazine.length()){
            return false;
        }

        //Make a counts map for the magazine.
        Map<Character, Integer> magazineCounts = makeCountsMap(magazine);

        //For each character in the ransom note
        for(char c : ransomNote.toCharArray()){
            //get the current count for c in the magazine.
            int countInMagazine = magazineCounts.getOrDefault(c, 0);

            //if there are none of c left, return false
            if(countInMagazine == 0) return false;

            //put the updated count for c back into magazineCounts.
            magazineCounts.put(c, countInMagazine - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aaa";
        String magazine = "abaaa";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}
