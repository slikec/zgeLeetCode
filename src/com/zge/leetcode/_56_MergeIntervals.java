package com.zge.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class _56_MergeIntervals {
    static int[][] merge(int[][] intervals){
        //Sorting array
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,19}};
        int[][] intervals = {{1,3},{2,6},{8,10},{15,19},{1,9},{0,1},{0,2},{19,20}};

        //deepToString to print 2 or 3 dimensional array.
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
}
