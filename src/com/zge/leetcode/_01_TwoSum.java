package com.zge.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class _01_TwoSum {
    static int[] twoSum(int[] nums, int target){
        System.out.println(Arrays.toString(nums));
        System.out.println(target);

        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int b = nums[i];
            int a = target - b;
            if(seen.containsKey(a)) return new int[]{seen.get(a), i};
            seen.put(b, i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        //input example values
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        //Output results
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
