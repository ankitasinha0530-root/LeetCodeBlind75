package com.leetcode.blind75.arrays;

public class BuyAndSellAStock {

    // https://www.youtube.com/watch?v=34WE6kwq49U

    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 2, 6, 4};
        System.out.println("when prices " + maxProfitBuyAndSellStock(prices));

        int[] prices1 = {7, 6, 5, 2, 1, 4};
        System.out.println("when prices1 " + maxProfitBuyAndSellStock(prices1));
    }

    private static int maxProfitBuyAndSellStock(int[] prices) {

        int l = 0;
        int r = 1;
        int maxProfit = Integer.MIN_VALUE;

        while (r < prices.length) {
            if (prices[l] < prices[r]) {
                int currProfit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, currProfit);
            } else {
                l = r; // mark minimum element as left
            }
            r += 1;
        }
        return maxProfit;
    }

}
