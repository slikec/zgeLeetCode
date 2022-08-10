package com.zge.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1046_LastStoneWeight {

    //Heap-Based Simulation
    //Time complexity: O(N logN)
    //Space complexity: O(N) to create the PriorityQueue
    public static int lastStoneWeight(int[] stones){
        //Head/Priority Queue data structure. A heap always returning the maximum item.
        //Min-heap, so we need reverse order.
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int stone : stones){
            heap.add(stone);
        }

        while(heap.size() > 1){
            int stone1 = heap.remove();
            int stone2 = heap.remove();

            if(stone1 != stone2){
                heap.add(stone1 - stone2);
            }
        }

        return heap.isEmpty() ? 0 : heap.remove();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};

        System.out.println(lastStoneWeight(stones));
    }
}
