package com.frank.leetcode;

public class L125ValidPalindrome {
	boolean Isalpha(char a) {
		return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
	}

	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len <= 1)
			return true;
		int start = 0;
		int end = len - 1;
		while (start < end) {
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
				continue;
			}
			if (!(s.charAt(start) + "").equalsIgnoreCase(s.charAt(end) + "")) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new L125ValidPalindrome().isPalindrome("1a2"));
	}
}
