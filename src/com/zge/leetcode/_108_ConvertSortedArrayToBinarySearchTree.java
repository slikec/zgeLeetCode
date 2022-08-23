package com.zge.leetcode;

public class _108_ConvertSortedArrayToBinarySearchTree {

    //#1 Preorder traversal
    //Time complexity: O(N)
    //Space complexity: O(logN)
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums){
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int left, int right){
        if(left > right) return null;
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }


    public static void main(String[] args) {

    }
}
