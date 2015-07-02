package com.frank.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class L128LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums.length <= 1)
			return nums.length;
		int val = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], 1);
		}

		while (!map.isEmpty() && map.size() > val) {
			Iterator<Entry<Integer, Integer>> iter = map.entrySet().iterator();
			int v = iter.next().getKey();
			map.remove(v);
			int len = 1;
			int left = v - 1;
			int right = v + 1;
			while (map.containsKey(left)) {
				len++;
				map.remove(left);
				left--;
			}
			while (map.containsKey(right)) {
				len++;
				map.remove(right);
				right++;
			}
			
			if (len > val)
				val = len;
		}

		return val;
	}

	public static void main(String[] args) {
		int n=new L128LongestConsecutiveSequence().longestConsecutive(new int[] { 9,1, 4, 7, 3, -1, 0, 5, 8, -1, 6 });
		System.out.println(n);
	}

}
