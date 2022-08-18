package com.zge.leetcode;

import java.util.HashMap;

public class _437_PathSumIII {
    int count = 0;
    int k;
    HashMap<Integer, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum){
        k = targetSum;
        preorder(root, 0);
        return count;
    }

    public void preorder(TreeNode root, int currSum){
        if(root == null) return;

        //Current prefix sum
        currSum += root.val;

        if(currSum == k) count++;

        count += map.getOrDefault(currSum - k, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        preorder(root.left, currSum);
        preorder(root.right, currSum);

        map.put(currSum, map.get(currSum) - 1);

    }
}
