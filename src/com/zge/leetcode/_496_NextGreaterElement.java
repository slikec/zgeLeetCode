package com.zge.leetcode;

import java.util.*;

public class _496_NextGreaterElement {
    public static void main(String[] args) {

        int[] nums1 = new int[]{4,1,2};
        int[] nums2 = new int[]{1,3,4,2};

        int[] result = new int[nums1.length];
        Stack<Integer> stack=new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums2){
            while(!stack.isEmpty() && num > stack.peek())
                map.put(stack.pop(), num);
            stack.push(num);
        }

        int i=0;
        for(int num : nums1)
            result[i++] = map.getOrDefault(num, -1);
//        return result;

        for(int j =0; j<result.length;j++)
            System.out.println(result[j]);


    }

}
