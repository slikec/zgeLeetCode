package com.zge.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
    static List<List<Integer>> generate(int numRows){

        List<List<Integer>> triangle = new ArrayList<>();

        //Base case, first row is always [1].
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i = 1; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(i-1);

            row.add(1);

            for(int j = 1; j < i; j++){
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }

            row.add(1);

            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }
}
