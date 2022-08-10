package com.zge.leetcode;
/*
Time complexity: O(N)
Space complexity: O(N)
*/

public class _98_ValidateBinarySearchTree {
    //Instead of int, Integer supports a null value.
    private static Integer prev;

    //Definition for a binary tree node
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root){
        prev = null;
        return inorder(root);
    }

    private static boolean inorder(TreeNode root){
        //An empty tree are valid BSTs
        if(root == null) return true;

        if(!inorder(root.left)) return false;
        if(prev != null && root.val <= prev) return false;

        prev = root.val;
        return inorder(root.right);
    }

    public static void main(String[] args) {

    }
}
