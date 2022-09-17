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
    public ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode NodeBeforeRemovedIndex = FindFromEnd(dummy, n + 1);

        NodeBeforeRemovedIndex.next = NodeBeforeRemovedIndex.next.next;
        return dummy.next;
    }

    private ListNode FindFromEnd(ListNode head, int k){
        ListNode p1 = head;
        for(int i = 0; i < k; i++){
            p1 = p1.next;
        }

        ListNode p2 = head;
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {

    }
}
