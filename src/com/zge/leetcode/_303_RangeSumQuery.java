package com.zge.leetcode;

import java.util.Arrays;

public class _303_RangeSumQuery {

    /*
    * Caching
    * Time complexity: O(1)
    * Space complexity: O(n)
    * */
    private int[] sum;

    public _303_RangeSumQuery(int[] nums){
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right){
        return sum[right+1] - sum[left];
    }

}
