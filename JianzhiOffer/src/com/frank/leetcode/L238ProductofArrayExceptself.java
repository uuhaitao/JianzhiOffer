package com.frank.leetcode;

public class L238ProductofArrayExceptself {
	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		res[0] = 1;
		for (int i = 1; i < len; i++)
			res[i] = res[i - 1] * nums[i - 1];
		int last = nums[len - 1];
		for (int i = len - 2; i >= 0; i--) {
			res[i] = res[i] * last;
			last*=nums[i];
		}

		return res;
	}

	public static void main(String[] args) {
		new L238ProductofArrayExceptself()
				.productExceptSelf(new int[] { 1, 0 });
	}
}
