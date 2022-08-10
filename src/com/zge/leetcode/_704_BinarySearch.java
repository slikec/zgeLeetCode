package com.zge.leetcode;
/*
Time complexity: O(log N)
Space complexity: O(1)
*/
public class _704_BinarySearch {
    public static int search(int[] nums, int target){
        int left = 0, right = nums.length - 1, pivot;

        while(left <= right){
            pivot =left + (right - left) / 2;
            if(nums[pivot] == target) return pivot;
            if(nums[pivot] > target){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 7, 9};
        int target = -1;

        System.out.println(search(nums, target));
    }
}
