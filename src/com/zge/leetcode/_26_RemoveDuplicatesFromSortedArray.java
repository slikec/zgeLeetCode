package com.zge.leetcode;

import java.util.Arrays;

public class _26_RemoveDuplicatesFromSortedArray {

    /*
    * Time complexity: O(N)
    * Space complexity: O(1)
    * */
    public int removeDuplicates(int[] nums){
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return 1;

        int slow = 0, fast = 0;

        while(fast < n){
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
