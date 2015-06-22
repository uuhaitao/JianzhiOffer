package com.frank.leetcode;

import java.util.HashMap;

public class L219ContainsDuplicate2 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums.length <= 1)
			return false;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (map.containsKey(key) && i - map.get(key) <= k) {
				return true;
			} else {
				map.put(key, i);
			}
		}

		return false;
	}
}
