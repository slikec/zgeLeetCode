package com.zge.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* Time complexity: O(n)
* Space complexity: O(n)
* */
public class _234_PalindromeLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head){
        List<Integer> arr = new ArrayList<>();

        //Convert LinkedList to ArrayList
        ListNode currNode = head;
        while(currNode != null) {
            arr.add(currNode.val);
            currNode = currNode.next;
        }

        //Using two pointer technique to check for palindrome
        int front = 0;
        int back = arr.size() - 1;

        while(front < back){
            if(!arr.get(front).equals(arr.get(back))){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
