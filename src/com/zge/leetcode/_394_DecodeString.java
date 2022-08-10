package com.zge.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _394_DecodeString {

    //#1 Using stack
    //Time complexity: O(max (K ^ countK) * n)
    //Space complexity: O(sum(max (K ^ countK) * n))
    public static String decodeString(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == ']'){
                List<Character> decodeString = new ArrayList<>();
                while(stack.peek() != '['){
                    decodeString.add(stack.pop());
                }

                //pop '[' from stack
                stack.pop();
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    //stack is Character, in order to show num need - '0'
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                while(k != 0){
                    for(int j = decodeString.size() - 1; j >= 0; j--){
                        stack.push(decodeString.get(j));
                    }
                    k--;
                }
            }
            //push current character to stack
            else{
                stack.push(s.charAt(i));
            }
            i++;
        }

        char[] result = new char[stack.size()];
        for(int num = result.length - 1; num >= 0; num--){
            result[num] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
}
