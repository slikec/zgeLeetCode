package com.zge.leetcode;


import java.util.Arrays;
import java.util.PriorityQueue;

public class _870_AdvantageShuffle {
    /*
    * Time complexity: O(n logn)
    * Space complexity: O(n)
    * */
    public int[] advantageCount(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        int n = nums1.length;
        int[] res = new int[n];

        //Reverse priority queue, get max num first.
        //Since num value put on index 1, so pair1[1]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
//        PriorityQueue<int[]> pq = new PriorityQueue<>(
//                (int[] pair1, int[] pair2) -> {
//                    return pair2[1] - pair1[1];
//                }
//        );

        //Add array to priority queue
        for(int i = 0; i < n; i++){
            pq.offer(new int[]{i, nums2[i]});
        }
        int left = 0, right = n - 1;

        while(!pq.isEmpty()){
            int[] pair = pq.poll();

            int i = pair[0], maxVal = pair[1];
            if(maxVal < nums1[right]){
                res[i] = nums1[right--];
            }else{
                res[i] = nums1[left++];
            }
        }
        return res;
    }
}
