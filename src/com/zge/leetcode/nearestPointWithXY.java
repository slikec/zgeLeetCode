package com.zge.leetcode;

import java.util.Arrays;

public class nearestPointWithXY {
    public static void main(String[] args){
        int x = 3;
        int y = 4;
        int[][] points = new int[][]{{1,2},{3,1},{2,4},{2,3},{4,4}};

        int minManhattan = Integer.MAX_VALUE;
        int tempManhattan = 0;
        int index =-1;

        for(int i=0; i< points.length;i++){
            int dx=points[i][0];
            int dy=points[i][1];

            if(x==dx || y==dy){
                tempManhattan = Math.abs(x-dx) + Math.abs(y-dy);
                //compare new Manhattan distances to find out the smallest one.
                if(tempManhattan!=minManhattan){
                    minManhattan = Math.min(minManhattan,tempManhattan);
                    //if new Manhattan distance is the new smallest one, change the index to it, otherwise index not change.
                    if(minManhattan==tempManhattan){
                        index=i;
                    }
                }
            }
        }

        System.out.println(index);

    }
}
