package com.frank.leetcode;

public class L213HouseRobberII {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);
		boolean stealfirst[] = new boolean[len];
		stealfirst[0] = true;
		int first = nums[0];
		int second = nums[1];
		int money = first;
		if (second >= first) {
			money = second;
			stealfirst[1] = false;
		} else {
			second = first;
			stealfirst[1] = true;
		}
		for (int i = 2; i < len - 1; i++) {
			int val = nums[i];
			int curr = val;
			if (val + first > second) {
				curr = val + first;
				stealfirst[i] = stealfirst[i - 2];
			} else {
				curr = second;
				stealfirst[i] = stealfirst[i - 1];
			}
			first = second;
			second = curr;
		}
		money = second;
		int val = nums[len - 1];
		if (!stealfirst[len - 3]) {
			int curr = first + Math.max(val, nums[0]);
			if (curr > second)
				money = curr;
		}

		return money;
	}

	public static void main(String[] args) {
		int m = new L213HouseRobberII().rob(new int[] { 1, 2, 1, 0 });
		System.out.println(m);
	}
}
