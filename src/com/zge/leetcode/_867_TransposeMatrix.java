package com.zge.leetcode;

/*
* Time complexity = O(r*c)
* Space complexity = O(r*c)
* */
public class _867_TransposeMatrix {
    public static int[][] transpose(int[][] matrix){
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] ans = new int[C][R];

        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++) {
                ans[c][r] = matrix[r][c];
            }
        }
        return ans;
    }
}
