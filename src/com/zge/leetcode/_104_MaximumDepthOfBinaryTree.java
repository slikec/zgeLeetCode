package com.zge.leetcode;

public class _104_MaximumDepthOfBinaryTree {
    /*
    * Time complexity: O(N)
    * Space complexity: O(N)
    * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int res = Math.max(leftMax, rightMax) + 1;

        return res;
    }
}
