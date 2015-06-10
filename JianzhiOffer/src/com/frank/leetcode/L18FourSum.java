package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L18FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return res;
		int lens = nums.length;
		Arrays.sort(nums);
		for (int i = 0; i < lens - 3; i++) {
		    if(i>0 && nums[i]==nums[i-1])
				continue;
			for (int j = i + 1; j < lens - 2; j++) {
			    if(j>i+1 && nums[j]==nums[j-1])
					continue;
				int l = j + 1;
				int r = lens - 1;
				while (l < r)
				{
					if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
						List<Integer> found = new ArrayList<Integer>();
						found.add(nums[i]);
						found.add(nums[j]);
						found.add(nums[l]);
						found.add(nums[r]);
						res.add(found);
						while(l+1 < r && nums[l+1]==nums[l]) l++;
						while(l < r-1 && nums[r-1]==nums[r]) r--;
						l++;
						r--;
					} 
					else if (nums[i] + nums[j] + nums[l] + nums[r] < target)
						l++;
					else
						r--;
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		new L18FourSum().fourSum(new int[] { 0, 0, 0, 0 }, 0);
	}
}
