package com.frank.leetcode;

import java.util.Arrays;

public class L217ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		if (len <= 1)
			return false;
		int curr = nums[0];
		for (int i = 1; i < len; i++) {
			int num = nums[i];
			if (num == curr) {
				return true;
			} else {
				curr = num;
			}
		}
		return false;
	}
}
