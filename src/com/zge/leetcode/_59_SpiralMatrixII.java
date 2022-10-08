package com.zge.leetcode;

public class _59_SpiralMatrixII {

    /*
    * Time complexity: O(n*n)
    * Space complexity: O(1)
    * */
    public int[][] generateMatrix(int n){
        int[][] matrix = new int[n][n];
        int leftBound = 0, rightBound = n - 1, upBound = 0, downBound = n - 1;
        int num = 1;

        while(num <= n*n){
            if(upBound <= downBound){
                //Left to right
                for (int left = leftBound; left <= rightBound; left++){
                    matrix[upBound][left] = num++;
                }
                upBound++;
            }

            if(leftBound <= rightBound){
                //up to down
                for(int up = upBound; up <= downBound; up++){
                    matrix[up][rightBound] = num++;
                }
                rightBound--;
            }

            if(upBound <= downBound){
                //right to left
                for(int right = rightBound; right >= leftBound; right--){
                    matrix[downBound][right] = num++;
                }
                downBound--;
            }

            if(leftBound <= rightBound){
                //down to up
                for(int down = downBound; down >= upBound; down--){
                    matrix[down][leftBound] = num++;
                }
                leftBound++;
            }
        }
        return matrix;
    }
}
