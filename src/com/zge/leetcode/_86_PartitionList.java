package com.zge.leetcode;

public class _86_PartitionList {

    /*
    * Time complexity: O(N)
    * Space complexity: O(1)
    * */
    public ListNode partition(ListNode head, int x){
        if(head == null) return null;

        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        while(head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
