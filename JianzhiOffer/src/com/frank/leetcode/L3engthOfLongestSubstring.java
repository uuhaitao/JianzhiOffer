package com.frank.leetcode;

import java.util.HashMap;

import sun.security.util.Length;

/*
 * Given a string, 
 * find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for 
 * "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", 
 * with the length of 1.
 */

public class L3engthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1)
			return s.length();
		char a[] = s.toCharArray();
		HashMap<Character, Integer> seen = new HashMap<Character, Integer>();

		int last_max_pos = 0;
		int max = 0;

		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			if (seen.containsKey(c)) {
				int pos = seen.get(c);
				if (pos >= last_max_pos) {
					int size = i - last_max_pos;
					if (size > max) {
						max = size;
					}
					last_max_pos = pos + 1;
				}
			}
			seen.put(c, i);
		}
		int size = a.length - last_max_pos;
		if (size > max)
			max = size;

		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abbacdefab"));
	}
}
