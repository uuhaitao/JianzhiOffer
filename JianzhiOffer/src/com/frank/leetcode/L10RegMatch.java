package com.frank.leetcode;

/*
 * '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 * 
 * 
 */

public class L10RegMatch {

	public boolean isMatch(String s, String p) {

		return match_core(s, p);
	}

	public boolean match_core(String s, String p) {
		if (s.equals("") && p.equals(""))
			return true;

		if (!s.equals("") && p.equals(""))
			return false;

		char p0 = p.charAt(0);

		if (s.length() >= 1) {
			char s0 = s.charAt(0);

			if (p.length() > 1 && p.charAt(1) == '*') {
				if (s0 == p0 || (p0 == '.' && !s.equals(""))) {
					return match_core(s.substring(1), p.substring(2))
							|| match_core(s.substring(1), p)
							|| match_core(s, p.substring(2));
				} else
					return match_core(s, p.substring(2));
			}
			if (s0 == p0 || (p0 == '.' && !s.equals("")))
				return match_core(s.substring(1), p.substring(1));

			
		}
		return false;
	}

	public static void main(String[] args) {
		// Last executed input: "ab", ".*c"
	}

}
