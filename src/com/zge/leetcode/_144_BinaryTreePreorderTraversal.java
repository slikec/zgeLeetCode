package com.zge.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _144_BinaryTreePreorderTraversal {
    /*
    * Time complexity: O(N)
    * Space complexity: O(N)
    * */
    public List<Integer> preorderTraversal(TreeNode root){
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) return output;

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
        return output;
    }


}
