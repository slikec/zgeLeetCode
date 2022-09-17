package com.zge.leetcode;

import java.util.PriorityQueue;

public class _23_MergeKSortedLists {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    /*
    * Time complexity: O(NlogK)
    * Space complexity: O(n)
    * New linkedList cost O(n) space.
    * PriorityQueue cost O(k) space.
    * */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length,(a,b)->(a.val - b.val)
        );

        for(ListNode head:lists){
            if(head != null) pq.add(head);
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            if(node.next != null){
                pq.add(node.next);
            }

            p = p.next;
        }
        return dummy.next;
    }

    /*
    * Time complexity: O(kN)
    * Space complexity: O(1)
    * */
    public ListNode mergeKLists2(ListNode[] lists){
        if(lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        int minIndex = 0;

        while(true){
            boolean isBreak = true;
            int min = Integer.MAX_VALUE;

            for(int i = 0; i < lists.length; i++){
                if(lists[i] != null){
                    if(lists[i].val < min){
                        minIndex = i;
                        min = lists[i].val;
                    }
                    isBreak = false;
                }
            }

            if(isBreak) break;

            head.next = lists[minIndex];
            head = head.next;
            lists[minIndex] = lists[minIndex].next;
        }
        head.next = null;
        return dummy.next;
    }
}
