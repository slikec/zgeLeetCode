package com.zge.leetcode;

public class _19_RemoveNthNodeFromEndOfList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    //#1
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static ListNode removeNthFromEnd(ListNode head, int n){
        //Find length of list
        int length = 0;
        ListNode currentNode = head;
        while(currentNode != null){
            currentNode = currentNode.next;
            length++;
        }

        //Find node to remove - index = length - n - 1
        int nodeBeforeRemovedIndex = length - n - 1;
        currentNode = head;

        for(int i = 0; i < nodeBeforeRemovedIndex; i++){
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    //#2
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static ListNode removeNthFromEnd2(ListNode head, int n){
        //Move currentNode n steps into list
        ListNode currentNode = head;
        for(int i = 0; i < n; i++){
            currentNode = currentNode.next;
        }

        if(currentNode == null) return head.next;

        //Move both pointers until currentNode reaches the end of list
        ListNode nodeBeforeRemovedIndex = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            nodeBeforeRemovedIndex = nodeBeforeRemovedIndex.next;
        }

        nodeBeforeRemovedIndex.next = nodeBeforeRemovedIndex.next.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
