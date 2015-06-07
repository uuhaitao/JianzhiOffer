package com.frank.leetcode;

/*
 * Implement atoi to convert a string to an integer.
 * It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 */

public class L8Atoi {

	public static int myAtoi(String str) {
		if (str.length() <= 0)
			return 0;
		String num = "";
		char a[] = str.trim().toCharArray();
		boolean sign = false;
		char pos = '+';
		if (a[0] == '+' || a[0] == '-') {
			sign = true;
			if (a[0] == '-')
				pos = '-';
		}

		for (int i = 0; i < a.length; i++) {
			if (i == 0 && sign) {
				continue;
			} else {
				if (a[i] >= '0' && a[i] <= '9') {
					num += a[i];
				} else {
					break;
				}
			}
		}

		if (num.length() <= 0) {
			return 0;
		}

		try {
			return Integer.parseInt(pos + num);
		} catch (Exception e) {
			if (pos == '+')
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}

	}

	public static void main(String[] args) {
		System.out.println(myAtoi("+-2"));
	}

}
