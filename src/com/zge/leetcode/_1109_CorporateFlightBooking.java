package com.zge.leetcode;

public class _1109_CorporateFlightBooking {

    /*
    * Time complexity: O(n*n)
    * Space complexity: O(n)
    * */
    public int[] corpFlightBooking(int[][] bookings, int n){
        int[] answer = new int[n];

        for(int[] reserved : bookings){
            for(int i = reserved[0]; i <= reserved[1]; i++){
                answer[i] += reserved[2];
            }
        }
        return answer;
    }

    /*
    * Time complexity: O(n)
    * Space complexity: O(n)
    * */
    public int[] corpFlightBooking2(int[][] bookings, int n){
        int[] answer = new int[n];

        for(int[] reserved : bookings){
            int start = reserved[0] - 1;
            int end = reserved[1] - 1;
            int seats = reserved[2];

            answer[start] += seats;
            if(end + 1 < n){
                answer[end+1] -= seats;
            }
        }

        for(int i = 1; i < n; i++){
            answer[i] += answer[i-1];
        }
        return answer;
    }

}
