package com.zge.leetcode;

public class _48_RotateImage {

    /*
    * Reverse on Diagonal and then Reverse Left to Right
    * Time complexity: O(M). Let M be the number of cells in the matrix.
    * Space complexity: O(1)
     * */
    public void rotate(int[][] matrix){
        int r = matrix.length;
        if(r==0 || r==1) return;

        mirror(matrix, r);
        for(int[] row : matrix){
            reverse(row, r);
        }
    }

    private void mirror(int[][] matrix, int c){
        for(int i = 0; i < c; i++){
            for(int j = i; j < c; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reverse(int[] row, int c){
            int left = 0, right = c - 1;
            while(left < right){
                int temp = row[left];
                row[left++] = row[right];
                row[right--] = temp;
            }
    }

    /*
     * Rotate Groups of Four Cells
     * Time complexity: O(M). Let M be the number of cells in the matrix.
     * Space complexity: O(1)
     * */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
