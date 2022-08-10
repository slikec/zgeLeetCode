package com.zge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _438_FindAllAnagramsInAString {

    //#1 Sliding window with HashMap
    //Time complexity: O(Ns)
    //Space complexity: O(K).
    //Since K is fixed at 26 letters, this can be considered as O(1) space
    public static List<Integer> findAnagrams(String s, String p){
        int ns = s.length(), np = p.length();
        if(ns < np) return new ArrayList();

        HashMap<Character, Integer> pCount = new HashMap<>();
        HashMap<Character, Integer> sCount = new HashMap<>();

        for(char ch : p.toCharArray()){
            if(pCount.containsKey(ch)){
                pCount.put(ch, pCount.get(ch) + 1);
            }else{
                pCount.put(ch, 1);
            }
        }

        List<Integer> output = new ArrayList<>();

        //Sliding window on the string s
        for(int i = 0; i < ns; i++){
            char ch = s.charAt(i);
            if(sCount.containsKey(ch)){
                sCount.put(ch, sCount.get(ch) + 1);
            }else{
                sCount.put(ch, 1);
            }

            //Sliding window.
            //Remove one letter from left side of the window
            if(i >= np){
                ch = s.charAt(i - np);
                if(sCount.get(ch) == 1){
                    sCount.remove(ch);
                }else{
                    sCount.put(ch, sCount.get(ch) - 1);
                }
            }

            //Compare
            if(sCount.equals(pCount)){
                output.add(i - np + 1);
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagrams2(s, p));
    }

    //#2 Sliding window with Array
    //Time complexity: O(Ns)
    //Space complexity: O(K).
    //Since K is fixed at 26 letters, this can be considered as O(1) space
    //ASCII - 128

    public static List<Integer> findAnagrams2(String s, String p){
        int ns = s.length(), np = p.length();
        if(ns < np) return new ArrayList<>();

        int[] pCount = new int[128];
        int[] sCount = new int[128];

        for(char ch : p.toCharArray()){
            pCount[ch]++;
        }

        List<Integer> output = new ArrayList<>();

        for(int i = 0; i < ns; i++){
            sCount[s.charAt(i)]++;

            if(i >= np){
                sCount[s.charAt(i-np)]--;
            }

            if(Arrays.equals(pCount,sCount)){
                output.add(i - np + 1);
            }
        }
        return output;
    }
}
