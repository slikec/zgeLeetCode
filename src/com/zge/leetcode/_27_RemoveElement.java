package com.zge.leetcode;

public class _27_RemoveElement {

    public _27_RemoveElement(int[] nums, int i) {
    }

    /*
    * Two pointers
    * Time complexity: O(n)
    * Space complexity: O(1)
    * */
    public int removeElement(int[] nums, int val){
        int n = nums.length;

        int slow = 0, fast = 0;

        while(fast < n){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /*
     * Two pointers - when element to remove are rare
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public int removeElement2(int[] nums, int val){
        int i = 0;
        int n = nums.length;

        while(i < n){
            if(nums[i] == val){
                //Order of elements doesn't matter.
                nums[i] = nums[n-1];
                n--;
            }else{
                i++;
            }
        }
        return n;
    }

}
