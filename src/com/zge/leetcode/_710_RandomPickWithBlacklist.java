package com.zge.leetcode;

import java.util.*;

public class _710_RandomPickWithBlacklist {

    /*
    * Time complexity: O(N)
    * Space complexity: O(N)
    * */
    int N;
    Map<Integer, Integer> map;
    Random r;

    public _710_RandomPickWithBlacklist(int n, int[] blacklist){
        N = n - blacklist.length;
        map = new HashMap<>();
        int last = n - 1;

        for(int b : blacklist) map.put(b, -1);

        for(int b : blacklist){
            if(b < N){
                while(map.containsKey(last)) last--;
                map.put(b,last);
                last--;
            }
        }
        r = new Random();
    }

    public int pick(){
        int idx = r.nextInt(N);
        if(map.containsKey(idx)) return map.get(idx);
        return idx;
    }
}
