package com.frank.leetcode;


public class L41FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		// Arrays.sort(nums);
		// int len = nums.length;
		// if (len < 1)
		// return 1;
		// int val = 0;
		// int i = 0;
		// while (i < len && nums[i] <= 0) {
		// i++;
		// }
		// for (; i < len ; i++) {
		// if (nums[i] == val)
		// continue;
		// if (nums[i] - val != 1)
		// return val+1;
		// else
		// val = nums[i];
		// }
		// return val+1;

		if (nums == null || nums.length == 0)
			return 1;
		int i=0;
		for(;i<nums.length;i++){
			while(nums[i]!=i+1){
				if(nums[i]<=0 || nums[i]>=nums.length || nums[i]==nums[nums[i]-1])
					break;
				else{
					int tmp=nums[i];
					nums[i]=nums[tmp-1];
					nums[tmp-1]=tmp;
				}
			}
		}
		i=0;
		for(;i<nums.length;i++){
			if(nums[i]!=i+1)
				return i+1;
		}

		return nums.length+1;

	}

	public static void main(String[] args) {
		int n = new L41FirstMissingPositive().firstMissingPositive(new int[] {0,0,0,0,-1});
		System.out.println(n);
	}

}
