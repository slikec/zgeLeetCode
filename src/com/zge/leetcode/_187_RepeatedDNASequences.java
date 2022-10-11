package com.zge.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _187_RepeatedDNASequences {

    /*
    * Linear-time Slice Using Substring + HashSet
    * Time complexity: O((N-L)*L)
    * Space complexity: O((N-L)*L)
    * */
    public List<String> findRepeatedDnaSequences(String s){
        int n = s.length();
        int L = 10;
        HashSet<String> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        for(int i = 0; i + L <= n; i++){
            String subStr = s.substring(i, i+L);

            if(seen.contains(subStr)){
                res.add(subStr);
            }else{
                seen.add(subStr);
            }
        }
        return new LinkedList<>(res);
    }

    /*
    * Rabin-Karp : Constant-time Slice Using Rolling Hash
    * Time complexity: O(N - L)
    * Space complexity: O(N - L)
    * */
    public static List<String> findRepeatedDnaSequences2(String s){
        int n = s.length();

        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            switch(s.charAt(i)){
                case 'A':
                    nums[i] = 0;
                    break;
                case 'C':
                    nums[i] = 1;
                    break;
                case 'G':
                    nums[i] = 2;
                    break;
                case 'T':
                    nums[i] = 3;
                    break;
            }
        }

        HashSet<Integer> seen = new HashSet<>();
        HashSet<String> res = new HashSet<>();

        //数字位数
        int L = 10;
        //进制
        int R = 4;
        int RL = (int)Math.pow(R, L-1);
        //滑动窗口中字符串的Hash值
        int windowHash = 0;

        int left = 0, right = 0;

        while(right < n){
            windowHash = R * windowHash + nums[right];
            right++;

            if(right - left == L){
                if(seen.contains(windowHash)){
                    res.add(s.substring(left, right));
                }else{
                    seen.add(windowHash);
                }
                windowHash = windowHash - nums[left] * RL;
                left++;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(findRepeatedDnaSequences2(s));
    }
}
