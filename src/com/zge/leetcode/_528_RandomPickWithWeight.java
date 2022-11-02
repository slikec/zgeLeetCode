package com.zge.leetcode;

import java.util.Random;

public class _528_RandomPickWithWeight {
    private int[] preSum;
    private Random rand = new Random();

    public _528_RandomPickWithWeight(int w[]){
        int n = w.length;
        preSum = new int[n+1];
        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i-1] + w[i-1];
        }
    }

    public int pickIndex(){
        int n = preSum.length;

        int target = rand.nextInt(preSum[n-1]) + 1;

        return leftBound(preSum, target) - 1;
    }

    private int leftBound(int[] nums, int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            }
        }
        return left;
    }
}
