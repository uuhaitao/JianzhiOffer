package com.frank.leetcode;

public class L151ReverseWordsinaString {
	public String reverseWords(String s) {
		if (s == null || s.trim().length() <= 1)
			return s;
		char res[] = s.trim().toCharArray();
		if(res.length==0)
			return "";
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			char c = res[start];
			res[start] = res[end];
			res[end] = c;
			start++;
			end--;
		}
		start = 0;
		end = 0;
		while (end <s.length()) {
			while(end<s.length() && res[end]!=' ' ){
				end++;
			}
			int tmp=end-1;
			while (start < tmp) {
				char c = res[start];
				res[start] = res[tmp];
				res[tmp] = c;
				start++;
				tmp--;
			}
			end++;
			start=end;
		}

		return String.valueOf(res);
	}
	
	public static void main(String[] args) {
		System.out.println(new L151ReverseWordsinaString().reverseWords(" 1"));
	}
}
