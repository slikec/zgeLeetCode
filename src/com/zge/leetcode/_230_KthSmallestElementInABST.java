package com.zge.leetcode;

import java.util.ArrayList;

public class _230_KthSmallestElementInABST {
    //#1
    //Time complexity: O(N)
    //Space complexity: O(N)
    public int kthSmallest(TreeNode root, int k){
        ArrayList<Integer> nums = inorder(root, new ArrayList<Integer>());
        return nums.get(k - 1);
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
