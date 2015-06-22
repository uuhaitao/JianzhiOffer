package com.frank.leetcode;

public class L169MajorityElement {
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int res = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == res) {
				count++;
			} else {
				count--;
				if (count < 0) {
					res = nums[i];
					count = 0;
				}
			}
		}
		return res;
	}
}
