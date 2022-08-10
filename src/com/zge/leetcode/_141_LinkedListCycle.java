package com.zge.leetcode;

import java.util.LinkedList;
/*
Time complexity: O(n)
Space complexity: O(1)
*/

public class _141_LinkedListCycle {
    static class Node{
        int data;
        Node next;
        Node(int x){
            this.data = x;
            this.next = null;
        }
    }

    public static boolean hasCycle(Node head){
        if(head == null) return false;

        Node slow = head;
        Node fast = head.next;

        while(slow != fast){
            if(fast == null || fast.next == null) return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

//        System.out.println(hasCycle();
        System.out.println(list);
    }
}
