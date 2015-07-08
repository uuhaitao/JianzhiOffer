package com.frank.leetcode;

public class L198HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		int len = nums.length;
		if (len == 1)
			return nums[0];
		if (len == 2)
			return Math.max(nums[0], nums[1]);
		int sum = 0;
		int n1=nums[0];
		int n2=Math.max(nums[0], nums[1]);
		for(int i=2;i<len;i++){
			int curr=nums[i]+n1;
			curr=curr>n2?curr:n2;
			if(curr>sum)
				sum=curr;
			n1=n2;
			n2=curr;
		}
		return sum;
	}
}
