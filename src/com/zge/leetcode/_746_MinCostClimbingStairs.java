package com.zge.leetcode;

import java.util.HashMap;

public class _746_MinCostClimbingStairs {
    //#1 Bottom-up Dynamic programming (Tabulation)
    //Time complexity: O(N)
    //Space complexity: O(N)
    public static int minCostClimbingStairs1(int[] cost){
        //The Array's length should be 1 longer
        //We can treat the "top floor" as a step to reach.
        int[] miniCost = new int[cost.length + 1];

        //Start iteration from step 2, since the minimum cost of reaching
        //step 0 and step 1 is 0
        for(int i = 2; i<miniCost.length; i++){
            int takeOneStep = miniCost[i-1] + cost[i-1];
            int takeTwoStep = miniCost[i-2] + cost[i-2];
            //Find out the minimum cost of reaching index[i]
            miniCost[i] = Math.min(takeOneStep, takeTwoStep);
        }
        return miniCost[miniCost.length-1];
    }

    //#2 Top-down dynamic programming (Recursion + Memoization)
    //Time complexity: O(N)
    //Space complexity: O(N)
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    public static int minCostClimbingStairs2(int[] cost){
        return miniCost(cost.length, cost);
    }

    public static int miniCost(int i, int[] cost){
        if(i <= 1) return 0;

        //Check calculated or not
        if(memo.containsKey(i)) return memo.get(i);

        int takeOneStep = cost[i-1] + miniCost(i-1, cost);
        int takeTwoStep = cost[i-2] + miniCost(i-2, cost);
        memo.put(i, Math.min(takeOneStep, takeTwoStep));
        return memo.get(i);
    }

    public static int minCostClimbingStairs3(int[] cost){
        int downOne = 0, downTwo = 0;

        for(int i = 2; i < cost.length + 1; i++){
            int temp = downOne;
            downOne = Math.min(downOne + cost[i-1], downTwo + cost[i-2]);
            downTwo = temp;
        }
        return downOne;
    }


    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs1(cost));
        System.out.println(minCostClimbingStairs2(cost));
        System.out.println(minCostClimbingStairs3(cost));
    }
}
