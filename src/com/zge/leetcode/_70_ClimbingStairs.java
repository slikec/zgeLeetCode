package com.zge.leetcode;

public class _70_ClimbingStairs {

    //#1 Brute Force
    //Time complexity: O(2^N)
    //Space complexity: O(N)
    public static int climbStairs(int n){
        return climb_Stairs1(0,n);
    }

    public static int climb_Stairs1(int i, int n){
        if(i>n) return 0;
        if(i==n) return 1;

        return climb_Stairs1(i+1, n) + climb_Stairs1(i+2, n);
    }

    //#2 Recursion with Memoization
    //Time complexity: O(n)
    //Space complexity: O(n)
    public static int climbStairs2(int n){
        int memo[] = new int[n+1];
        return climb_Stairs2(0, n, memo);
    }

    public static int climb_Stairs2(int i, int n, int memo[]){
        if(i>n) return 0;
        if(i==n) return 1;
        //memo[i]>0, it means there already have values.
        if(memo[i]>0) return memo[i];

        memo[i] = climb_Stairs2(i+1, n, memo) + climb_Stairs2(i+2, n, memo);
        return memo[i];
    }

    //#3 Dynamic Programming
    //Time complexity: O(n)
    //Space complexity: O(n)
    public static int climbStairs3(int n){
        if(n==1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //#4 Fibonacci number
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static int climbStairs4(int n){
        if(n==1) return 1;

        int first = 1, second = 2;

        for(int i = 3; i <= n; i++){
           int temp = first + second;
           first = second;
           second = temp;
        }
        return second;
    }

    //#5 Fibonacci formula
    //Time complexity: O(log n)
    //Space complexity: O(1)
    public static int climbStairs5(int n){
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;
        return (int) ((Math.pow(phi,n+1) - Math.pow(psi, n+1)) / sqrt5);
    }

    public static void main(String[] args) {
        int n = 9;

        System.out.println(climbStairs(n));
        System.out.println(climbStairs2(n));
        System.out.println(climbStairs3(n));
    }
}
