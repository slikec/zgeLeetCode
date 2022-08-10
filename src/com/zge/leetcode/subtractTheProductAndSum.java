package com.zge.leetcode;

import java.util.ArrayList;

public class subtractTheProductAndSum {
    public static void main(String[] args){
        int n = 234;
        ArrayList<Integer> num = new ArrayList<Integer>();
        do{
            num.add(n % 10);
            n /= 10;
        }
        while (n>0);

        int product = 1, sum = 0, result = 0;

        for(int i=0; i<num.size();){
            product *= num.get(i);
            sum += num.get(i);
            i++;
        }
        result = product - sum;
        System.out.println(result);
        System.out.println(num);

    }
}
