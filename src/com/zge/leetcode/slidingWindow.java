package com.zge.leetcode;

import java.util.Map;

public class slidingWindow {
    /*
     * Sliding window framework
     * */
    public void slidingWindow(String s){
        Map<Character, Integer> window;

        int left = 0, right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            right++;

            /*Updating sliding window below*/

            System.out.printf("window: [%d, %d)\n", left, right);

            // 判断左侧窗口是否要收缩
            while(true /*window needs shrink*/) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
            }

        }

    }
}
