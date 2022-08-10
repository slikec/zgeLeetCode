package com.zge.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _142_LinkedListCycleII {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            val = x;
            next = null;
        }
    }

    private static ListNode getIntersect(ListNode head){
        ListNode tortoise = head;
        ListNode hare = head;

        while(hare != null && hare.next != null){
            tortoise = tortoise.next;
            hare = hare.next.next;
            if(tortoise == hare){
                return tortoise;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head){
        //#1 HashTable
        //Time complexity O(n)
        //Space complexity O(n)
        /*Set<ListNode> visited = new HashSet<>();

        ListNode node = head;
        while(node != null){
            //Check if node contains in set
            if(visited.contains(node)){
                return node;
            }
            //Add to Hash Set
            visited.add(node);
            node = node.next;
        }
        return null;
        */

        //#2 Floyd's Tortoise and Hare
        /*
        * Time complexity: O(n)
        * Space complexity: O(1)
        * This algorithm allocates only pointers, so it suns with constant overall memory usage.
        * */
        if(head == null){
            return null;
        }

        //If there is a cycle, the fast/slow pointers will intersect at some
        //node. Otherwise, there is no cycle, so we cannot find an entrance to a cycle.
        ListNode intersect = getIntersect(head);
        if(intersect == null){
            return null;
        }

        //To find the entrance to the cycle, we have two pointers traverse at
        //the same speed -- one from the front of the list, and the other from
        //the point of intersection.

        //The intersection point is naturally the point that distance to the cycle entrance
        //is the same distance from the beginning(head) to the cycle entrance.!!! Bravo!
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList();
        //  3, 2, 0, -4, 5, 9, 10, 22, 30, 4, 5, 6  //    5

    }
}
