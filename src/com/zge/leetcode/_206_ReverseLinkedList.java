package com.zge.leetcode;

import java.util.LinkedList;

/*
 * Time complexity: O(n)
 * Space complexity: O(1)
 * */

public class _206_ReverseLinkedList {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

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

    public static void main(String[] args) {
        LinkedList<Integer> lists = new LinkedList<>();
        lists.add(1);
        lists.add(2);
        lists.add(3);
        lists.add(4);
        lists.add(5);

//        ListNode head = null;
//        System.out.println(head.val);
//        System.out.println(lists.getFirst());
//        head.val = lists.getFirst();
//        lists.val = new ListNode(1);

//        System.out.println(reverseList(head));
    }
}
