package com.zge.leetcode;

public class _110_BalancedBinaryTree {

    //#1 Recursion
    //Time complexity: O(n log n)
    //Space complexity: O(n)
    public boolean isBalanced(TreeNode root){
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root == null) return -1;

        return 1 + Math.max(height(root.left),height(root.right));
    }
}
