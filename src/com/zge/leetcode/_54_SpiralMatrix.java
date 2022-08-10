package com.zge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {

    //#1 Set up boundaries
    //Time complexity: O(M * N)
    //Space complexity: O(1)
    public static List<Integer> spiralOrder(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int up = 0, left = 0;
        int down = rows - 1, right = columns - 1;

        while(result.size() < rows * columns){
            for(int col = left; col <= right; col++){
                result.add(matrix[up][col]);
            }

            for(int row = up + 1; row <= down; row++){
                result.add(matrix[row][right]);
            }

            if (up != down){
                for(int col = right - 1; col >= left; col--){
                    result.add(matrix[down][col]);
                }
            }

            if(left != right){
                for(int row = down - 1; row > up; row--){
                    result.add(matrix[row][left]);
                }
            }

            left++;
            up++;
            right--;
            down--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(spiralOrder(matrix));
    }
}
