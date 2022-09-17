package com.zge.leetcode;

public class _92_ReverseLinkedListII {

    /*
    * Recursion
    * Time complexity: O(n)
    * Space complexity: O(n)
    * */
    static ListNode successor = null;
    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(left == 1){
            return reverseN(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right -1);
        return head;
    }

    public static ListNode reverseN(ListNode head, int right){
        if(right == 1){
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, right - 1);

        head.next.next = head;
        head.next = successor;
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
        ListNode head = reverseBetween(node1, 2, 4);
        printList(head);
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }

}
