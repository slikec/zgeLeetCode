package com.zge.leetcode;

public class _34_FindFirstAndLastPositionOfElementInSortedArray {
    /*
    * Time complexity: O(logN)
    * Space complexity: O(1)
    * */
    public int[] searchRange(int[] nums, int target){
        int left = 0, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                int first = leftBound(nums, mid, target);
                int last = rightBound(nums, mid, target);
                return new int[]{first, last};
            }
        }
        return new int[]{-1,-1};
    }

    private int leftBound(int[] nums, int rightBound, int target){
        int left = 0, right = rightBound - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if(left == rightBound) return rightBound;

        return nums[left] == target ? left : rightBound;
    }

    private int rightBound(int[] nums, int leftBound, int target){
        int left = leftBound + 1, right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        return nums[left - 1] == target ? left - 1 : leftBound;
    }
}
