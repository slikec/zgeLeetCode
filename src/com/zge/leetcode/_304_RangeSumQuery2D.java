package com.zge.leetcode;

public class _304_RangeSumQuery2D {

    /*
    * Caching
    * Time complexity: O(1)
    * Space complexity: O(mn)
    * */
    private int[][] preSum;

    public _304_RangeSumQuery2D(int[][] matrix){
        int r = matrix.length, c = matrix[0].length;
        if(r==0 || c==0) return;

        preSum = new int[r+1][c+1];

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                preSum[i][j] = preSum[i-1][j] + preSum[i][j-1] + matrix[i-1][j-1] - preSum[i-1][j-1];
            }
        }
    }

    public int sumRanger(int row1, int col1, int row2, int col2){
        return preSum[row2+1][col2+1] - preSum[row1][col2+1] - preSum[row2+1][col1] + preSum[row1][col1];
    }

}
