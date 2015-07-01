package com.frank.leetcode;

public class L152MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		int res = nums[0];
		int last_min = nums[0];
		int lastmax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int max=lastmax;
			lastmax=Math.max(Math.max(nums[i], nums[i]*lastmax),nums[i]*last_min);
			if(lastmax>res)
				res=lastmax;
			last_min=Math.min(nums[i], Math.min(nums[i]*max,nums[i]*last_min));
		}
		return res;
	}
	public static void main(String[] args) {
		int a=new L152MaximumProductSubarray().maxProduct(new int[]{-4,-3,-2});
		System.out.println(a);
	}
}
