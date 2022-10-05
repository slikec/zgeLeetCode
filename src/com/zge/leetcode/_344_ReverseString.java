package com.zge.leetcode;

public class _344_ReverseString {

    /*
    * Two pointers
    * Time complexity: O(N)
    * Space complexity: O(1)
    * */
    public void reverseString(char[] s){
        int left = 0, right = s.length-1;

        while(left < right){
            Character temp = s[right];
            s[right] = s[left];
            s[left] = temp;

            left++;
            right--;
        }
    }

}
