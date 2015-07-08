package com.frank.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L205IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		return core(s,t) &&core(t,s);
	}
	boolean core(String s,String t){
		if (s.length() <= 1 && t.length() <= 1)
			return true;
		if (s.length() != t.length())
			return false;
		int len = s.length();
		Map<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < len; i++) {
			char curr = s.charAt(i);
			if (map.containsKey(curr) && map.get(curr) != t.charAt(i)) {
				return false;
			} else
				map.put(curr, t.charAt(i));
		}
		return true;
	}
	
}
