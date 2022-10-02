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

    //#1
    //Time complexity: O(n)
    //Space complexity: O(n)
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

    //#2 Reverse second half in-place
    //Time complexity: O(n)
    //Space complexity: O(1)

    public boolean isPalindrome2(ListNode head){
        //Prevent [] or [1]
        if(head == null || head.next == null) return true;

        //Find first half end
        ListNode firstHalfEnd = findFirstHalfEnd(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;

        while(result){
            if(p1.val != p2.val) result = false;
            p1 = p1.next;
            //Prevent [1, 2]
            if(p2.next == null) break;
            p2 = p2.next;
        }

        //Restore the list and return the result
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode tempNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNode;
        }
        return prev;
    }

    //Find mid node
    public ListNode findFirstHalfEnd(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
