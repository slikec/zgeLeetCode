package com.zge.leetcode;
/*
Time complexity: O(log N)
Space complexity: O(1)
*/
public class _278_FirstBadVersion {

    public static boolean isBadVersion(int version, int bad){
        if(version >= bad) return true;
        return false;
    }
    public static int firstBadVersion(int n, int bad){
        int left = 1, right = n;
        while(left < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid, bad)){
                    right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int n = 10, bad = 3;

        System.out.println(firstBadVersion(n, bad));
    }
}
