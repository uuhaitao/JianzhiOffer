package com.frank.leetcode;

public class L136SingleNumber {
	public int singleNumber(int[] nums) {
		if (nums.length == 0)
			return -1;
		int res = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res ^= nums[i];
		}
		return res;
	}
}
