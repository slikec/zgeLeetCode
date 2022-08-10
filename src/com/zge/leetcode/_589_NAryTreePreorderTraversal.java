package com.zge.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _589_NAryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}
        public Node(int _val) {val = _val;}
        public Node(int _val, List<Node> _children) {val = _val; children = _children;}
    };

    public static List<Integer> preorder(Node root){
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) return output;

        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            output.add(node.val);
            //reverse
            Collections.reverse(node.children);
            for(Node item : node.children){
                stack.add(item);
            }
        }
        return output;
    }

    public static void main(String[] args) {

    }

}
