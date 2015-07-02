package com.frank.leetcode;

public class L45JumpGameII {
	public int jump(int[] nums) {
		int ret = 0;
		int n = nums.length;
		int curr = 0;
		int last = 0;
		for (int i = 0; i < n; i++) {
			if(i>curr)
				return -1;
			if(last<i){
				last=curr;
				ret++;
			}
			curr=Math.max(curr, i+nums[i]);

		}
		return ret;
	}

	public static void main(String[] args) {
		new L45JumpGameII().jump(new int[] { 1, 2, 1, 1, 2,1,1,1 });
	}

}
