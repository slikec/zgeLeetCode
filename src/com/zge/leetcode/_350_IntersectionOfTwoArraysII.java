package com.zge.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _350_IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            System.out.println("0");
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums1){
            if(map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else{
                map.put(num,1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int num:nums2){
            if(map.containsKey(num) && map.get(num)>0){
                result.add(num);
                int freq = map.get(num);
                freq--;
                map.put(num, freq);
            }
        }

        int[] listToArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            listToArray[i] = result.get(i);
        }

        //Convert toString
        System.out.println(Arrays.toString(listToArray));

    }
}
