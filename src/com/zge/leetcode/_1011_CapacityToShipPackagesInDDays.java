package com.zge.leetcode;

public class _1011_CapacityToShipPackagesInDDays {
    /*
    * Time complexity: O(n log(S))
    * Space complexity: O(1)
    * Similar question: 410
    * */
    public int shipWithinDays(int[] weights, int days){
        int left = 0;
        int right = 1;
        //Find min capacity, and sum.
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while(left < right){
            int mid = left + (right - left) / 2;

            if(f(weights, mid) <= days){
                right = mid;
            } else if (f(weights, mid) > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] weights, int capacity){
        int D = 0;

        for(int i = 0; i < weights.length;){
            int c = capacity;
            while(i < weights.length){
                if(weights[i] > c) break;
                else{
                    c -= weights[i];
                }
                i++;
            }
            D++;
        }
        return D;
    }

}
