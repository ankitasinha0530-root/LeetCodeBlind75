package com.practice.leetcode.blind75.array;

public class BuyAndHoldOrSellAStock {

	public static void main(String[] args) {
		// we can plan to hold the stock and then get the profit by selling at max price

		int[] prices = {7,1,5,3,6,4};
		System.out.println(maxProfitBuyAndSellStock(prices));
		
		int[] prices1 = {1,2,3,4,5};
		System.out.println(maxProfitBuyAndSellStock(prices1));
	}

	private static int maxProfitBuyAndSellStock(int[] prices) {

		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if(prices[i-1] < prices[i]) {
				profit += prices[i] - prices[i-1];
			}
		}
		return profit;
	}

}
