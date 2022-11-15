package com.zge.leetcode;

import java.util.*;

public class _870_AdvantageShuffle {
    /*
    * Time complexity: O(n logn)
    * Space complexity: O(n)
    * */
    public int[] advantageCount(int[] nums1, int[] nums2){
        int n = nums1.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] pair1, int[] pair2) -> {
                    return pair2[1] - pair1[1];
                }
        );

        for(int i = 0; i < n; i++){
            pq.offer(new int[]{i, nums2[i]});
        }
        Arrays.sort(nums1);

        int left = 0, right = n - 1;
        int[] res = new int[n];

        while(!pq.isEmpty()){
            int[] pair = pq.poll();

            int i = pair[0], maxVal = pair[1];
            if(maxVal < nums1[right]){
                res[i] = nums1[right];
                right--;
            }else{
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
