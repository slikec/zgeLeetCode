package com.zge.leetcode;

public class _543_DiameterOfBinaryTree {

    //#1 Depth-first search
    //Time complexity: O(n)
    //Space complexity: O(n)
    int diameter;
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        diameter = 0;
        height(root);

        return diameter;
    }

    public int height(TreeNode root){
        if(root == null) return 0;

        int leftPath = height(root.left);
        int rightPath = height(root.right);

        diameter = Math.max(diameter, leftPath + rightPath);

        return 1 + Math.max(leftPath, rightPath);
    }
}


