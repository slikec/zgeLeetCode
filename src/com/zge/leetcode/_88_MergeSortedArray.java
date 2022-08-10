package com.zge.leetcode;

import java.util.Arrays;

/*
* Time complexity = O(n+m)
* Space complexity = O(1)
* */

public class _88_MergeSortedArray {
    static int[] merge(int[] nums1, int m, int[] nums2, int n){
        //Set p1 and p2 to point to the end of their respective arrays
        int p1 = m - 1;
        int p2 = n - 1;
//        int i = m + n - 1;

        //Add move i backwards through the array
        for(int i = m+n-1; i >= 0; i--){
            if(p2 < 0) break;

            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[i] = nums1[p1--];
            }else{
                nums1[i] = nums2[p2--];
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(merge(nums1,m,nums2,n)));
    }
}
