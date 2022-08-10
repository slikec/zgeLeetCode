package com.zge.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */

public class _412_FizzBuzz {
    static List<String> fizzBuzz(int n){
        List<String> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            boolean divisibleBy3 = (i % 3) == 0;
            boolean divisibleBy5 = (i % 5) == 0;

            if(divisibleBy3 && divisibleBy5){
                answer.add("FizzBuzz");
            } else if (divisibleBy3) {
                answer.add("Fizz");
            } else if (divisibleBy5) {
                answer.add("Buzz");
            }else {
                //Convert integer to String
                answer.add(Integer.toString(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }
}
