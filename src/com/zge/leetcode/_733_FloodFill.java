package com.zge.leetcode;

import java.util.Arrays;
/*
Time complexity: O(M * N).
Space complexity: O(M * N). Worst case M * N.
*/

public class _733_FloodFill {
    static int[] DIRS = {0, 1, 0, -1, 0};
    static int m, n;

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor){
        int color = image[sr][sc];
        if(color == newColor) return image;
        m = image.length;
        n = image[0].length;
        dfs(image, sr, sc, color, newColor);
        return image;
    }

    static void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        if(r<0 || c<0 || r==m || c==n|| image[r][c] != oldColor) return;
        image[r][c] = newColor;
        /*
        * For loop runs 4 times
        * Every call to dfs will be in following pair:
        * {0,1}-> same row, next column
        * {1,0}-> next row, same column
        * {0,-1}-> same row, previous column
        * {-1,0}-> previous row, same column
        * This covered all 4 directions
        * */
        for(int i = 0; i < 4; i++){
            dfs(image, r + DIRS[i], c + DIRS[i + 1], oldColor, newColor);
        }
    }

    //Another way to covered 4 directions
    static void dfs2(int[][] image, int r, int c, int oldColor, int newColor) {
        if(image[r][c] == oldColor){
            image[r][c] = newColor;
            //previous row, same column
            if(r >= 1) dfs2(image, r-1, c, oldColor, newColor);
            //same row, previous column
            if(c >= 1) dfs2(image, r, c-1, oldColor, newColor);
            //next row, same column
            if(r+1 < m) dfs2(image, r+1, c, oldColor, newColor);
            //same row, next column
            if(c+1 < n) dfs2(image, r, c+1, oldColor, newColor);
        }
    }

        public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0},{1,0,1}};
        int sr = 1, sc = 1, color = 2;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));
    }
}

