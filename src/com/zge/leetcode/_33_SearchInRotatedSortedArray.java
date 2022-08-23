package com.zge.leetcode;

public class _33_SearchInRotatedSortedArray {

    //#1 Binary research
    //Time complexity: O(log N)
    //Space complexity: O(1)
    int[] nums;
    int target;

    public int search(int[] nums, int target){
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        if(n==1) return nums[0] == target ? 0 : -1;

        int rotateIndex = findRotateIndex(0, n - 1);

        if(nums[rotateIndex] == target) return rotateIndex;

        //If array not rotate, search entire array
        if(rotateIndex == 0) return searchIndex(0, n-1);
        //Search in left side
        if(target >= nums[0]) return searchIndex(0, rotateIndex);
        //search in right side
        else return searchIndex(rotateIndex, n-1);
    }

    public int searchIndex(int left, int right){
        //Binary search
        while(left <= right){
            int pivot = (left + right) / 2;
            if(nums[pivot] == target) return pivot;
            else{
                if(nums[pivot] > target){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }

    public int findRotateIndex(int left, int right){
        if(nums[left] < nums[right]) return 0;

        while(left <= right){
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot + 1]) return pivot + 1;
            else{
                if(nums[pivot] < nums[left]){
                    right = pivot - 1;
                }else{
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }

    //#2 One-Pass Binary Research
    //Time complexity: O(log N)
    //Space complexity: O(1)

    public int search2 (int[] nums, int target){
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if(target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
            else{
                if(target <= nums[end] && target > nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
