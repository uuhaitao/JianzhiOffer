package com.frank.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class L49Anagrams {
	String sort_string(String a) {
		char[] chars = a.toCharArray();
		Arrays.sort(chars);
		return String.valueOf(chars);
	}

	public List<String> anagrams(String[] strs) {
		List<String> res = new LinkedList<String>();
		int len = strs.length;
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < len; i++) {
			String s = sort_string(strs[i]);
			if (!map.containsKey(s)) {
				map.put(s, i);
			} else {
				res.add(strs[i]);
				int preind = map.get(s);
				if (preind < len) {
					map.put(s, preind + len);
				}
			}
		}
		for (String key : map.keySet()) {
			int ind = map.get(key);
			if (ind >= len) {
				res.add(strs[ind - len]);
			}
		}

		return res;
	}
}
