package com.zge.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _217_ContainsDuplicate {
    static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            //Check set contains i.
            if(!set.add(i)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(containsDuplicate(nums));
    }
}
