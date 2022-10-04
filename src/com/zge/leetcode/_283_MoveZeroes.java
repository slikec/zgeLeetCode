package com.zge.leetcode;

import java.util.Arrays;

public class _283_MoveZeroes {

    /*
     * Two pointers
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public static void moveZeroes(int[] nums){
        int n = nums.length;

        //Call method from another class
        _27_RemoveElement p = new _27_RemoveElement(nums, 0);
        int k = p.removeElement(nums, 0);
        System.out.println(p);
        System.out.println(k);

        int slow = 0, fast = 0;
        while(fast < n){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        Arrays.fill(nums, slow, n, 0);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
         moveZeroes(nums);
    }
}
