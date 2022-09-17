package com.zge.leetcode;

public class _160_IntersectionOfTwoLinkedLists {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x; next = null;}
    }

    /*
    Time complexity: O(N)
    Space complexity: O(1)
    */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;

        //In the case lists do not intersect, both pointers will reach their respective ends
        //at the same time. Both pointers will be null, p1 == p2, end while loop.
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }

            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
        return p1;

    }
}
