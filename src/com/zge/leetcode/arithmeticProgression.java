package com.zge.leetcode;

import java.util.Arrays;

public class arithmeticProgression {
    public static void main(String[] args){
//        int[] arr = new int[]{3,5,1};
        int[] arr = new int[]{2,4,1};

        Arrays.sort(arr);

        int arithmetic = 0;
        boolean sign = false;

        arithmetic = arr[1] - arr[0];
        for(int i=0; i<arr.length-1; i++){
            int a = arr[i];
            int b = arr[i+1];
            if(arithmetic == b-a) {
                sign = true;
            }else{
                sign =false;
                break;
            }

        }
        System.out.println(sign);
    }


}
