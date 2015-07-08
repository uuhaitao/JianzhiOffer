package com.frank.leetcode;

public class L172FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int ret = 0;
		while (n > 0) {
			ret += n / 5;
			n = n / 5;
		}
		return ret;
	}
}
