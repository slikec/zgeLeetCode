package com.zge.leetcode;

public class _74_SearchA2DMatrix {
    //# Binary search
    //Time complexity: O(log(mn))
    //Space complexity: O(1)
    public static boolean searchMatrix(int[][] matrix, int target){
        int cn = matrix.length;
        int rn = matrix[0].length;
        int left = 0;
        int right = cn * rn - 1;
        int pivotIndex, pivotElement;

        while(left <= right) {
            pivotIndex = (left + right) / 2;
            //matrix[1][1]
            pivotElement = matrix[pivotIndex / rn][pivotIndex % rn];

            if (target == pivotElement) {
                return true;
            } else {
                if (target < pivotElement) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }
}
