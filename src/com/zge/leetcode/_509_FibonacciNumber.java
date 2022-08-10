package com.zge.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _509_FibonacciNumber {

    //#1 Recursion
    //Time complexity: O(2^N)
    //Space complexity: O(N)
    public static int fib(int n){
        if(n <= 1) return n;
        return fib(n-1) + fib(n-2);
    }

    //#2 Bottom-up approach using tabulation
    //Time complexity: O(N)
    //Space complexity: O(N)
    public static int fib2(int n){
        if(n <= 1) return n;

        int[] cache = new int[n+1];
        cache[1] = 1;
        for(int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n];
    }


    //#3 Top-down approach using memoization
    //Time complexity: O(N)
    //Space complexity: O(N)
    private Map<Integer, Integer> map = new HashMap<>();
    public int fib3(int n){
        map.put(0,0);
        map.put(1,1);

        if(map.containsKey(n)) return map.get(n);

        map.put(n, fib3(n-1) + fib3((n-2)));

        return map.get(n);
    }

    //#4 Iterative Bottom-up approach
    //Time complexity: O(N)
    //Space complexity: O(1)
    public int fib4(int n){
        if(n<=1) return n;

        int current = 0, prev1 = 1, prev2 = 0;

        for(int i = 2; i<=n; i++){
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

    //#5 Matrix Exponentiation
    //Time complexity: O(logN)
    //Space complexity: O(logN)

    //#6 Math: Golden ratio, Binet's formula
    //Time complexity: O(logN)
    //Space complexity: O(1)
    public int fib6(int n){
        double goldenRatio = (1 + Math.sqrt(5)) / 2;

        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(fib(n));
    }
}
