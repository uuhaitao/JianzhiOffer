package com.frank.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L76MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";
		String res = "";

		int len1 = s.length();
		int len2 = t.length();
		int minlen = len1 + 1;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int slow = -1;
		int quick = -1;
		for (int i = 0; i < len1; i++) {
			char a = s.charAt(i);
			if (t.indexOf(a) >= 0) {
				quick = i;
				if (map.containsKey(a)) {
					int ind = map.get(a);
					map.put(a, i);
					if (ind == slow)
						slow = getmin(map);
					if (map.size() == len2 && quick - slow + 1 < minlen) {
						res = s.substring(slow, quick + 1);
					}
				} else {
					map.put(a, i);

					if (slow == -1)
						slow = i;
					if (map.size() == len2 && quick - slow + 1 < minlen) {
						res = s.substring(slow, quick + 1);
					}
				}
			}
		}
		return res;
	}

	int getmin(Map<Character, Integer> map) {
		int min = Integer.MAX_VALUE;
		for (Integer e : map.values()) {
			if (e < min)
				min = e;
		}
		return min;
	}

	public static void main(String[] args) {
		String s = new L76MinimumWindowSubstring().minWindow("abbbbbdbca", "adb");
		System.out.println(s);
	}
}
