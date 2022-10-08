package com.zge.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _151_ReverseWordsInAString {

    /*
    *  Built in split + reverse
    * Time complexity: O(N)
    * Space complexity: O(N)
    * */
    public String reverseWords(String s){
        //Remove whitespace from both sides of a string.
        s = s.trim();

        // \\s+ means multiple whitespaces, \\s means single whitespace.
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);

        return String.join(" ", wordList);
    }


    /*
    * Time complexity: O(N)
    * Space complexity: O(N)
    * */
    public String reverseWords2(String s){
        if(s==null) return s;
        s=s.trim();
        s = s.replaceAll("\\s+", " ");

        char[] wordList = s.toCharArray();
        int n = wordList.length;

        reverse(wordList, 0, n-1);
        reverseWord(wordList, n);

        String str = String.valueOf(wordList);
        return str;
    }

    private void reverseWord(char[] c, int n){
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && c[i] == ' ') i++; // skip spaces
            while (j < i || j < n && c[j] != ' ') j++; // skip non spaces
            reverse(c, i, j - 1);                      // reverse the word
        }
    }

    private void reverse(char[] c, int i, int j){
        while(i < j){
            char temp = c[i];
            // Assign value then increment
            c[i++] = c[j];
            c[j--] = temp;
        }
    }

//    public String reverseWords3(String s){}
}
