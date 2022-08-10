package com.zge.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* Time complexity O(m + n)
* Space complexity O(1)
* Iteration
* */

public class _21_MergeTwoSortedLists {
    public static class ListNode{
        ListNode head;
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){this.val = val;}
        ListNode(int val, ListNode next){this.val = val; this.next = next;}
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode head = new ListNode();
        ListNode tail = head;

        //Iterate until we reach the end of one list
        while(list1 != null && list2 != null){
            //Compare the heads of both lists
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail= tail.next;
        }

        tail.next = list1 == null ? list2 : list1;

        return head.next;
    }

    public static void main(String[] args) {
//        LinkedList<Integer> list1 = new LinkedList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();

//        list1.addToTheLast()

//        System.out.println(mergeTwoLists(list1, list2));
    }
}
