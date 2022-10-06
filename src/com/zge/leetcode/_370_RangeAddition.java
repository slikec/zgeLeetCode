package com.zge.leetcode;

public class _370_RangeAddition {

    /*
    * Time complexity: O(n*k)
    * Space complexity: O(1)
    * */
    private int[] arr;

    public int[] getModifiedArray(int length, int[][] updates){
        arr = new int[length];
        int m = updates.length;

        for (int[] update : updates) {
            for (int j = update[0]; j <= update[1]; j++) {
                arr[j] += update[2];
            }
        }
        return arr;
    }

    /*
    * Time complexity: O(n + k)
    * Space complexity: O(1)
    * */
    public int[] getModifiedArray2(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];

            res[start] += value;

            if(end < length - 1)
                res[end + 1] -= value;
        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }
}
