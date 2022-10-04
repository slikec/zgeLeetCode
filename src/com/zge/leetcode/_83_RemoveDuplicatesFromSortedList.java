package com.zge.leetcode;

public class _83_RemoveDuplicatesFromSortedList {

    /*
    * Time complexity: O(n)
    * Space complexity: O(1)
    * */
    public ListNode removeDuplicates(ListNode head){
        //[]
        if(head == null) return head;

        ListNode left = head, right = head;

        while(right != null){
            if(left.val != right.val){
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        //[1,1,2,3,3]
        left.next = null;

        return head;
    }


    /*
     * Straight-forward Approach
     * Time complexity: O(n)
     * Space complexity: O(1)
     * */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
