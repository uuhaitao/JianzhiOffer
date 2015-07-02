package com.frank.leetcode;

public class L42TrappingRainWater {
	public int trap(int[] height) {
		int len = height.length;
		int water = 0;
		int left_most_high[] = new int[len];
		int right_most_high[] = new int[len];

		int left_highest = 0;
		for (int i = 0; i < len; i++) {
			left_most_high[i] = left_highest;
			left_highest = Math.max(height[i], left_highest);
		}

		int right_most = 0;
		for (int j = len - 1; j >= 0; j--) {
			right_most_high[j] = right_most;
			right_most = Math.max(right_most, height[j]);
		}

		for (int i = 0; i < len; i++) {
			int vol = Math.min(left_most_high[i], right_most_high[i])
					- height[i];
			if (vol > 0)
				water += vol;
		}

		return water;
	}
}
