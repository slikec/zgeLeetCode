package com.zge.leetcode;

import java.util.HashSet;
import java.util.Map;

public class _202_HappyNumber {

    //#1 Hash set
    //Time complexity: O(log n)
    //Space complexity: O(log n)

    public static boolean isHappy(int n){
        HashSet<Integer> set = new HashSet<>();

        while(!set.contains(n) && n != 1){
            set.add(n);
            n = getNext(n);
        }
        //if n == 1 true, else false.
        return n == 1;
    }

    //#2 Floyd's cycle-finding algorithm
    //Time complexity: O(log n)
    //Space complexity: O(1)

    public static boolean isHappy2(int n){
        int tortoise = n;
        int hare = getNext(n);

        while(hare != 1 && hare != tortoise){
            tortoise = getNext(n);
            hare = getNext(getNext(n));
        }
        return hare == 1;
    }

    public static int getNext(int n){
        int sum = 0;
        while(n > 0){
            sum += Math.pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        int n = 116;

        System.out.println(isHappy(n));
    }
}
