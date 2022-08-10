package com.zge.leetcode;

public class _121_BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));

        if(prices.length == 0)
            System.out.println("0");

        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++){

                if(prices[i] > minPrice) {
                    maxProfit = Math.max(maxProfit,prices[i] - minPrice);
                }else{
                    minPrice = prices[i];
                }
        }
//        System.out.println(maxProfit);
    }
}
