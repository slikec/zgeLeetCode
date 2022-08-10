package com.zge.leetcode;

import java.util.HashMap;

/*
 * Time complexity: O()
 * Space complexity: O()
 *
 * Not Finish Yet!!!!!
 *
 * */
public class _792_NumberOfMatchingSubsequences {
    public static int numMatchingSubseq(String s, String[] words){
        HashMap<String, Integer> map = new HashMap<>();
        int count = words.length;

        //Set up hashmap
        for(int i = 0; i < s.length()-1; i++){
            String str = Character.toString(s.charAt(i));
            if(!map.containsKey(str)){
                map.put(str, 1);
            }else{
                map.put(str,map.get(str) + 1);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            int wordNum = 0;
            for(int j = 0; j < words[i].length() - 1; j++){
                String str2 = Character.toString(words[i].charAt(j));
                if(map.containsKey(str2)){
                    wordNum += 1;
//                    System.out.println(wordNum);
                    if(wordNum > map.get(str2)){
                        count--;
                        break;
                    }
                }else{
                    count--;
                    break;
                }
            }
//            System.out.println(wordNum);
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace", "b"};

        System.out.println(numMatchingSubseq(s, words));
    }
}
