package com.frank.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * 
 * 
 */
public class L15ThreeSum {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3)
			return result;
		Arrays.sort(nums);
		int lens = nums.length;
		for (int i = 0; i < lens - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int target = nums[i];
			int left = i + 1;
			int right = lens - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + target;
				if (sum > 0)
					right--;
				else if (sum < 0)
					left++;
				else {
					ArrayList<Integer> l = new ArrayList<Integer>();
					l.add(target);
					l.add(nums[left]);
					l.add(nums[right]);
					result.add(l);
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					left++;
					right--;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
//		List<List<Integer>> r = new L15ThreeSum().threeSum(new int[] { 7, 5,
//				-8, -6, -13, 7, 10, 1, 1, -4, -14, 0, -1, -10, 1, -13, -4, 6,
//				-11, 8, -6, 0, 0, -5, 0, 11, -9, 8, 2, -6, 4, -14, 6, 4, -5, 0,
//				-12, 12, -13, 5, -6, 10, -10, 0, 7, -2, -5, -12, 12, -9, 12,
//				-9, 6, -11, 1, 14, 8, -1, 7, -13, 8, -11, -11, 0, 0, -1, -15,
//				3, -11, 9, -7, -10, 4, -2, 5, -4, 12, 7, -8, 9, 14, -11, 7, 5,
//				-15, -15, -4, 0, 0, -11, 3, -15, -15, 7, 0, 0, 13, -7, -12, 9,
//				9, -3, 14, -1, 2, 5, 2, -9, -3, 1, 7, -12, -3, -1, 1, -2, 0,
//				12, 5, 7, 8, -7, 7, 8, 7, -15 });
		
	}

}
