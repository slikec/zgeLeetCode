package com.zge.leetcode;

import java.util.Stack;

public class _316_RemoveDuplicateLetters {

    /*
    * Time complexity: O(n)
    * Space complexity: O(n)
    * */
    public String removeDuplicateLetters(String s){

        Stack<Character> stack = new Stack<>();
        int[] count = new int[256];
        boolean[] check = new boolean[256];

        for(char c : s.toCharArray()){
            count[c]++;
        }

        for(char c : s.toCharArray()){
            count[c]--;

            if(check[c]) continue;

            while(!stack.isEmpty() && stack.peek() > c){
                if(count[stack.peek()]==0) break;
                check[stack.pop()] = false;
            }

            stack.push(c);
            check[c] = true;
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
