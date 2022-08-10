package com.zge.leetcode;
/*
Time complexity O()
Space complexity O()
*/

public class _724_FindPivotIndex {
    public static int pivotIndex(int[] nums){
        int sum = 0, leftSum = 0;
        for(int n : nums) sum += n;

        for(int i = 0; i < nums.length; i++){

            if(leftSum == sum - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};

        System.out.println(pivotIndex(nums));

    }
}
