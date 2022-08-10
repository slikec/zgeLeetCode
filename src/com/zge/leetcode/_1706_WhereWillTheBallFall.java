package com.zge.leetcode;

import java.util.Arrays;

public class _1706_WhereWillTheBallFall {

    //Time complexity: O(M * N)
    //Space complexity: O(N)

    public static int[] findBall(int[][] grid){
//        int rows = grid.length;
        int columns = grid[0].length;
        int[] result = new int[columns];

        //i defined which column ball start
        for(int i = 0; i < columns; i++){
            int col1 = i;
            int col2;

            for (int[] row : grid) {
                //decide ball turn left or right
                col2 = col1 + row[col1];

                //Only grid[j][col1] == grid[j][col2], then the ball move from col1 to col2.
                if (col2 < 0 || col2 >= columns || row[col1] != row[col2]) {
                    col1 = -1;
                    break;
                }
                col1 = col2;
            }
            result[i] = col1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        };

        System.out.println(Arrays.toString(findBall(grid)));
    }
}
