package com.frank.leetcode;

public class L201BitwiseAND {
	public int rangeBitwiseAnd(int m, int n) {
		int offset = 0;
		while (m > 0 && n > 0) {
			if (m == n)
				return m << offset;
			m = m >> 1;
			n = n >> 1;
			offset++;
		}
		return 0;
	}
}
