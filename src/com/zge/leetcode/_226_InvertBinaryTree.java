package com.zge.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _226_InvertBinaryTree {

    //#1 Recursion
    //Time complexity: O(n)
    //Space complexity: O(n)
    public TreeNode invertTree(TreeNode root){
        //Base case - return without recursion
        if(root != null){
            //invert child trees
            invertTree(root.left);
            invertTree(root.right);

            //swap children
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    //#2 Iterative
    //Time complexity: O(n)
    //Space complexity: O(n)
    public TreeNode invertTree2(TreeNode root){
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode curNode = queue.poll();
                TreeNode temp = curNode.left;
                curNode.left = curNode.right;
                curNode.right = temp;

                if(curNode.left != null){queue.add(curNode.left);}
                if(curNode.right != null){queue.add(curNode.right);}
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root = insertTreeNode(root, 2);
        root = insertTreeNode(root, 7);
        root = insertTreeNode(root, 1);
        root = insertTreeNode(root, 3);
        root = insertTreeNode(root, 6);
        root = insertTreeNode(root, 9);

//        printAll(root);
    }

    //Not working well
    public static void printAll(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            System.out.println(cur.val);
            printAll(cur.left);
            printAll(cur.right);
        }
    }

    //Need improve
    public static TreeNode insertTreeNode(TreeNode root, Integer n){
        TreeNode current = root;
        while(current != null){
            if(current.left == null){
                TreeNode temp = new TreeNode(n, null, null);
                current.left = temp;
                break;
            } else if (current.right == null) {
                TreeNode temp = new TreeNode(n, null, null);
                current.right = temp;
                break;
            }else{
                if(current.right.left != null){
                    current = current.left;
                }else{
                    current = current.right;
                }
            }
        }
        return current;
    }
}
