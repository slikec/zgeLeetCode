package com.zge.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class _20_ValidParentheses {
    static boolean isValid(String s){
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //Check the map contains char or not, if not push it to the top of Stack.
            //If map contains char, check stack empty() and pop() it
            if(map.containsKey(c)){
                char topStack = stack.empty()? '#' : stack.pop();
                //Check pop() values equals map values
                if(topStack != map.get(c)) return false;
            }else{
                stack.push(c);
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "(({{[]}})))";
        System.out.println(isValid(s));
    }
}
