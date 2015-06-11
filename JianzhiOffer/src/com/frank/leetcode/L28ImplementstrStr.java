package com.frank.leetcode;

/*
 * Returns the index of 
 * the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * 
 */
public class L28ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() == 0)
			return 0;

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int num = 1;
				for (int j = 1; j < needle.length(); j++) {
					if (i + j >= haystack.length())
						return -1;
					if (haystack.charAt(i + j) == needle.charAt(j)) {
						num++;
					}
				}
				if (num == needle.length())
					return i;
			}
		}
		return -1;
	}

}
