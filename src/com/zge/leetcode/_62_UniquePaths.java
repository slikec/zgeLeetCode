package com.zge.leetcode;

import java.util.Arrays;

public class _62_UniquePaths {

    //#1 Dynamic programing
    //Time complexity: O(M * N)
    //Space complexity: O(M * N)
    public static int uniquePaths(int m, int n){
        int[][] grid = new int[m][n];

        for(int[] arr : grid){
            Arrays.fill(arr, 1);
        }

        for(int col = 1; col < m; m++){
            for(int row = 1; row < n; row++){
                grid[col][row] = grid[col-1][row] + grid[col][row-1];
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        System.out.println(uniquePaths(m, n));

    }
}
