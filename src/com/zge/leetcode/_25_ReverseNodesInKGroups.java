package com.zge.leetcode;

public class _25_ReverseNodesInKGroups {
    /*
    * Recursion
    *Time complexity: O(N)
    * Space complexity: O(N/k)
    * */

    public static ListNode reverse(ListNode head, int k){
        ListNode newHead = null;
        ListNode ptr = head;

        while(k>0){
            ListNode nextNode = ptr.next;
            ptr.next = newHead;
            newHead = ptr;

            ptr = nextNode;
            k--;
        }
        return newHead;
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        int count = 0;
        ListNode ptr = head;

        while(count < k && ptr != null){
            ptr = ptr.next;
            count++;
        }

        if(count == k){
            ListNode reverseHead = reverse(head, k);

            head.next = reverseKGroup(ptr, k);
            return reverseHead;
        }

        return head;
    }

    /*
    * Iterative
    * Time complexity: O(N)
    * Space complexity: O(1)
    * */
    public static ListNode reverseKGroup2(ListNode head, int k){
        ListNode ptr = head;
        ListNode kTail = null;

        ListNode newHead = null;

        while(ptr != null){
            int count = 0;
            ptr = head;

            while(count < k && ptr != null){
                ptr = ptr.next;
                count++;
            }

            if(count == k){
                ListNode revHead = reverse(head, k);

                if(newHead == null) newHead = revHead;

                if(kTail != null) kTail.next = revHead;

                kTail = head;
                head = ptr;
            }
        }

        if(kTail != null) kTail.next = head;

        return newHead == null ? head : newHead;
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
        ListNode head = reverseKGroup2(node1,2);
        printList(head);
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            head = head.next;
        }
    }
}
