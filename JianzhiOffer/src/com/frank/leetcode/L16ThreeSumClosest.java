package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, 
 * find three integers in S such that 
 * the sum is closest to a given number, target. 
 * Return the sum of the three integers. 
 * You may assume that each input would have exactly one solution.
 */

public class L16ThreeSumClosest {

	 	public int threeSumClosest(int[] nums, int target) {

			Arrays.sort(nums);
			int lens = nums.length;
			int res=0;
			int gap=Integer.MAX_VALUE;
			
			for (int i = 0; i < lens - 2; i++) {
				if (i > 0 && nums[i] == nums[i - 1])
					continue;
				int curr=nums[i];
				
				int left = i + 1;
				int right = lens - 1;
				while (left < right) {
					int sum = nums[left] + nums[right] + curr;
					if (Math.abs(sum-target)<gap){
						gap=Math.abs(sum-target);
						res=sum;
					}
					
					if (sum > target)
					{
						right--;
					}
					else if (sum < target)
					{
						left++;
					}
						
					else {
						return target;
					}
				}
			}
			return res;
		}
	 	
	
	
	public static void main(String[] args) {

	}

}
