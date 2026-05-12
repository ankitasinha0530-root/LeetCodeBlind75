package com.practice.leetcode.blind75.array;

public class BuyAndSellAStock {

	public static void main(String[] args) {

		int[] prices = {7,1,5,2,6,4};
		System.out.println("when prices " + maxProfitBuyAndSellStock(prices));

		int[] prices1 = {7,6,5,2,1,4};
		System.out.println("when prices1 " + maxProfitBuyAndSellStock(prices1));
	}

	private static int maxProfitBuyAndSellStock(int[] prices) {

		int l = 0;
		int r = 1;
		int maxProfit = Integer.MIN_VALUE;
		
		while(r < prices.length) {
			if(prices[l] < prices[r]) {
				int currProfit = prices[r] - prices[l];
				maxProfit = Math.max(maxProfit, currProfit);
			}else {
				l = r;
			}
			r +=1;
		}
		return maxProfit;
	}

}
