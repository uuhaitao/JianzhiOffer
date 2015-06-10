package com.frank.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * 
 */
public class L20ValidParentheses {

	public static boolean isValid(String s) {
		if (s.length() < 2)
			return false;

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');

		char[] a = s.toCharArray();
		LinkedList<Character> res = new LinkedList<Character>();
		res.add(a[0]);

		for (int i = 1; i < a.length; i++) {
			char ai = a[i];
			if(!res.isEmpty()){
				char last = res.getLast();
				if (map.containsKey(last) && ai == map.get(last)) 
					res.removeLast();
				else
					res.add(ai);
			}
			else
				res.add(ai);
		}

		return res.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(isValid("()]]]"));
	}

}
