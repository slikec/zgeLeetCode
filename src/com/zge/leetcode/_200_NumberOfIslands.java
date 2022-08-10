package com.zge.leetcode;

/*
Time complexity: O(M * N).
Space complexity: O(M * N).
*/

public class _200_NumberOfIslands {
    static int nr, nc;
    public static int numIslands(char[][] grid){
        if(grid == null || grid.length == 0) return 0;

        int count = 0;
        nr = grid.length;
        nc = grid[0].length;

        for(int r = 0; r<nr; r++){
            for(int c = 0; c<nc; c++){
                if(grid[r][c] == '1'){
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    static void dfs(char[][] grid, int r, int c){
        if(r<0 || c<0 || r>=nr || c>=nc || grid[r][c] == '0') return;

        grid[r][c] = '0';
        //check 4 directions
        dfs(grid, r-1,c);
        dfs(grid, r,c-1);
        dfs(grid, r+1,c);
        dfs(grid, r,c+1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }
}
