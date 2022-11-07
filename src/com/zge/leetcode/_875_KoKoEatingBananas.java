package com.zge.leetcode;

public class _875_KoKoEatingBananas {
    /*
    * Time complexity: O(n * logm)
    * Space complexity: O(1)
    * */
    public int minEatingSpeed(int[] piles, int h){
        //Min eating speed is 1.
        int left = 1;
        //1 <= piles[i] <= 10^9
        int right = 1000000000 + 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(f(piles, mid) <= h){
                right = mid;
            } else if (f(piles, mid) > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int f(int[] piles, int k){
        int h = 0;
        for(int pile : piles){
            h += pile / k;
            if(pile % k > 0){
                h++;
            }
        }
        return h;
    }
}
