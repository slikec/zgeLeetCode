package com.zge.leetcode;

import java.util.Arrays;

public class largestPerimeterTriangle {
    public static void main (String[] args){
//        int[] arr = new int[]{6,3,4,20,6,15,8,9,10};
        int[] arr = new int[]{2,1,2};
        int maxPerimeter = 0;
        int n = arr.length;

        //sort array from small to large.
        Arrays.sort(arr);

        //reverse array sort.
//        int j = arr.length - 1;
//        for (int i = 0; i < arr.length / 2; i++, j--) {
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//        for(int i=0; i<arr.length; i++){
//            if (arr[i] < arr[i+1] + arr[i+2]) {
//                maxPerimeter = Math.max(maxPerimeter, arr[i] + arr[i+1] + arr[i+2]);
//                break;
//            }
//        }

        for(int i=n-1; i>1; i--){
            if (arr[i] < arr[i-1] + arr[i-2]) {
                maxPerimeter = Math.max(maxPerimeter,
                        arr[i] + arr[i-1] + arr[i-2]);
                System.out.println(arr[i] + arr[i-1] + arr[i-2]);
                break;
            }
        }


        if(maxPerimeter>0){
            System.out.println(maxPerimeter);
        }else{
            System.out.println(0);
        }
//        System.out.println(maxPerimeter);

    }
}
