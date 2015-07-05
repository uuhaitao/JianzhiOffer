package com.frank.leetcode;

public class L91DecodeWays {
	int ways = 0;

	public int numDecodings(String s) {
		if (s == null || s.length() == 0)
			return 0;
		if (s.charAt(0) == '0')
			return 0;
		int a0 = 1;
		int a1 = 1;
		int res = 1;
		int tmp = 0;
		for (int i = 2; i <= s.length(); i++) {
			tmp = Integer.parseInt(s.substring(i - 1, i));
			if (tmp != 0) {
				res = a1;
			}
			
			if (s.charAt(i - 2) != '0') {
				tmp = Integer.parseInt(s.substring(i - 2, i));
				if (tmp <= 26 && tmp >= 1)
					res += a0;
			}
			a0 = a1;
			a1 = res;
		}
		return res;
	}

	void helper(String s, int start) {
		int len = s.length();
		if (start >= len) {
			ways++;
			return;
		}
		helper(s, start + 1);
		if (start + 2 <= len && isOk(s.substring(start, start + 2))) {
			helper(s, start + 2);
		}
	}

	boolean isOk(String s) {
		int val = Integer.valueOf(s);
		int len = s.length();
		if (len == 1)
			return val >= 1 && val <= 9;
		if (len == 2)
			return val >= 10 && val <= 26;
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(test.substring(0, 3));
		int n = new L91DecodeWays().numDecodings("11");
		System.out.println(n);
	}

}
