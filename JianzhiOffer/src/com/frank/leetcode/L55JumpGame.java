package com.frank.leetcode;

public class L55JumpGame {
	public boolean canJump(int[] nums) {
		int len=nums.length;
		if(len<1)
			return true;
		int maxstep=nums[0];
		for(int i=1;i<len;i++){
			if(maxstep==0)
				return false;
			maxstep--;
			if(nums[i]>maxstep)
				maxstep=nums[i];
			if(i+maxstep>=len-1)
				return true;
		}
		return false;
	}
}
