package com.zge.leetcode;

public class countOddNum {

    static int countOdds(int low, int high){
            //the count of odd number between 1 and low - 1 is low/2
            //the count of odd number between 1 and high is (high + 1)/2
            return (high + 1) / 2 - low /2;
    }

    public static void main (String[] args){
        int low = 10;
        int high = 25;
        System.out.println(countOdds(low,high));
    }
}
