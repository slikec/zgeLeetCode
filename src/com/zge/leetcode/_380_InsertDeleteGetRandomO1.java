package com.zge.leetcode;

import java.util.*;

public class _380_InsertDeleteGetRandomO1 {
    /*
    * Using HashMap and ArrayList
    * Time complexity: O(1)
    * Space complexity:O(N)
    * */

    Map<Integer, Integer> dict;
    List<Integer> list;
    Random rand = new Random();

    public _380_InsertDeleteGetRandomO1() {
        dict = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val){
        if(dict.containsKey(val)) return false;

        dict.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val){
        if(!dict.containsKey(val)) return false;

        //move the last element to the place index of the element to delete
        int lastElement = list.get(list.size() - 1);
        int idx = dict.get(val);
        list.set(idx, lastElement);
        dict.put(lastElement, idx);

        //delete the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom(){
        return list.get(rand.nextInt(list.size()));
    }
}
