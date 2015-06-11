package com.frank.leetcode;

/*
 * Given an array and a value,
 * remove all instances of that value in place and return the new length.

 The order of elements can be changed. 
 It doesn't matter what you leave beyond the new length.
 * 
 */

public class L27RemoveElement {

	public int removeElement(int[] nums, int val) {
		int lens = nums.length;
		if (nums.length == 0)
			return 0;
		int newsize = 0;
		int new_ind = 0;

		for (int j = 0; j < lens; j++) {
			int curr = nums[j];

			if (curr != val) {
				nums[new_ind++] = nums[j];
				newsize++;
			}
		}
		return newsize;
	}

	public static void main(String[] args) {

	}

}
