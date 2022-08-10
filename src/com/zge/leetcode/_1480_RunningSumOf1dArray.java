package com.zge.leetcode;

import java.util.Arrays;

/*
Time complexity O(n)
Space complexity O(1)
*/

public class _1480_RunningSumOf1dArray {
    public static int[] runningSum(int[] nums){
        for(int i = 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(runningSum(nums)));
    }
}
