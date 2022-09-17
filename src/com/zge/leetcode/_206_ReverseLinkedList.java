package com.zge.leetcode;

public class _206_ReverseLinkedList {

    /*
    * Iterative
    * Time complexity: O(n)
    * Space complexity: O(1)
    */
    public static ListNode reverseList(ListNode head){
        ListNode prevNode = null;
        ListNode currNode = head;

        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    /*
    * Recursive
    * Time complexity: O(n)
    * Space complexity: O(n)
    * */
    public static ListNode reverseList2(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode last = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        printList(node1);
        System.out.println();
        ListNode head = reverseList2(node1);
        printList(head);
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

}
