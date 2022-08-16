package com.zge.leetcode;

public class _148_SortList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;};
        ListNode(int val, ListNode next){this.val = val; this.next = next;};
//        public Integer getValue(){return val;}
//        public ListNode getNext(){return next;}
    }

    //#1 Top Down Merge sort
    //Time complexity: O(n logn)
    //Space complexity: O(N)
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode();
        ListNode tail = head;

        while(left != null && right != null){
            if(left.val < right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left == null ? right : left;
        return head.next;
    }

    public static ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        ListNode head = new ListNode(4, null);

        head = insertNodeAtEnd(head, 2);
        head = insertNodeAtEnd(head, 1);
        head = insertNodeAtEnd(head, 3);


//        System.out.println(head.val);
//        System.out.println(head.next.val);

        System.out.println(sortList(head));
    }


    public static ListNode insertNodeAtEnd(ListNode head, int data){
        ListNode node = new ListNode(data);
        node.next = null;

        if(head == null) return node;
        else{
            ListNode temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }
}
