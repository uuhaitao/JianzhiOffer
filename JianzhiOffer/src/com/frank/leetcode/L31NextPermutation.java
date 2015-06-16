package com.frank.leetcode;

import java.util.Arrays;

public class L31NextPermutation {
	public void nextPermutation(int[] nums) {
		int lens = nums.length;
		if (lens <= 1)
			return;

		int ind = lens - 1;
		while (ind > 0) {
			if (nums[ind - 1] < nums[ind])
				break;
			ind--;
		}
		if (ind == 0) {
			Arrays.sort(nums);
			return;
		}

		int last = lens - 1;
		for (; last > ind - 1; last--) {
			if (nums[last] > nums[ind - 1]) {
				int tmp = nums[last];
				nums[last] = nums[ind - 1];
				nums[ind - 1] = tmp;
				break;
			}
		}

		Arrays.sort(nums, ind, lens);
	}
}
