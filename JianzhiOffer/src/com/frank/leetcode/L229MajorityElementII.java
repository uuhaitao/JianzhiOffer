package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L229MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		int num1 = 0;
		int num2 = 0;
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (counter1 == 0 || nums[i] == num1) {
				num1 = nums[i];
				counter1++;
			} else if (counter2 == 0 || nums[i] == num2) {
				num2 = nums[i];
				counter2++;
			} else {
				counter1--;
				counter2--;
			}
		}
		counter1 = 0;
		counter2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1)
				counter1++;
			else if (nums[i] == num2)
				counter2++;
		}
		if (counter1 > nums.length / 3)
			res.add(num1);
		if (counter2 > nums.length / 3)
			res.add(num2);
		return res;
	}
}
