package com.frank.leetcode;

public class L121BestTimetoBuyandSell {
	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int len = prices.length;
		int[] pre = new int[len];
		int[] last = new int[len];

		int profit = 0;
		int low = prices[0];
		pre[0] = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] < low) {
				low = prices[i];
			} else if (prices[i] - low > profit)
				profit = prices[i] - low;
			pre[i] = profit;
		}

		profit = 0;
		int high = prices[len - 1];
		last[len - 1] = 0;
		for (int i = len - 2; i >= 0; i--) {
			if (prices[i] > high) {
				high = prices[i];
			} else if (high - prices[i] > profit)
				profit = high - prices[i];
			last[i] = profit;
		}
		int max = pre[0] * last[0];
		for (int j = 0; j < len; j++) {
			if (pre[j] + last[j] > max)
				max = pre[j] + last[j];
		}
		return max;
	}
}
