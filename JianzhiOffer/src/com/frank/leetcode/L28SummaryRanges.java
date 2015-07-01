package com.frank.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L28SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new LinkedList<String>();
		int len = nums.length;
		if (len == 0)
			return res;
		if (len == 1) {
			res.add("" + nums[0]);
			return res;
		}

		int first = 0;
		int last = 0;
		int strlen = 0;
		for (int i = 1; i < len; i++) {
			if (nums[i] - nums[i - 1] == 1) {
				last = i;
			} else {
				strlen = last - first;
				if (strlen >= 1)
					res.add("" + nums[first] + "->" + nums[last]);
				else
					res.add("" + nums[first]);
				first = i;
				last = i;
			}
		}
		strlen = last - first;
		if (strlen >= 1)
			res.add("" + nums[first] + "->" + nums[last]);
		else
			res.add("" + nums[first]);
		return res;
	}

	public static void main(String[] args) {
		new L28SummaryRanges().summaryRanges(new int[] { 0, 1, 9 });
	}

}
