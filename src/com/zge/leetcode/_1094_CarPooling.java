package com.zge.leetcode;

public class _1094_CarPooling {
    /*
    * Diff array
    * Time complexity: O(Max(N, 1001)
    * Space complexity: O(1 or 1001)
    * */
    public boolean carPooling(int[][] trips, int capacity){
        //There is total of 1001 stops.
        int[] sum = new int[1001];

        for(int[] trip : trips){
            if(trip[0] > capacity) return false;
            sum[trip[1]] += trip[0];
            sum[trip[2]] -= trip[0];
        }


        for(int i = 0; i < 1001; i++){
            //preSum
            sum[i+1] += sum[i];
            if(sum[i] > capacity) return false;
        }
        return true;
    }
}
