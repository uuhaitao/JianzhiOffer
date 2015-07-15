package com.frank.leetcode;

public class L198HouseRobber {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);
		int dp[] = new int[len + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		int v1 = dp[len - 1];
		dp[0] = 0;
		dp[1] = nums[1];
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		int v2 = dp[len - 1];
		return Math.max(v1, v2);
	}
}
