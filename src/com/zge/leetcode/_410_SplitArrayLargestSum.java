package com.zge.leetcode;

public class _410_SplitArrayLargestSum {
    /*
     * Time complexity: O(n log(S))
     * Space complexity: O(1)
     * Similar question: 1011.
     * */
    public int splitArray(int[] nums, int k){
        int left = 0;
        int right = 1;
        for(int num : nums){
            left = Math.max(left, num);
            right += num;
        }

        while(left < right){
            int mid = left + (right - left) / 2;

            if(f(nums, mid) <= k){
                right = mid;
            } else if (f(nums, mid) > k) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[]nums, int sum){
        int k = 0;
        for(int i = 0; i< nums.length;){
            int s = sum;
            while(i < nums.length){
                if(nums[i] > s) break;
                else{
                    s -= nums[i];
                }
                i++;
            }
            k++;
        }
        return k;
    }
}
