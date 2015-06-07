package com.frank.leetcode;

/*
 * Given a string S, find the longest palindromic  substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

public class L5longestPalindrome {
	public static String longestPalindrome(String s) {
		char[] a=s.toCharArray();
		int max_len=0;
		String res=s.substring(0, 1);
		for (int i=0;i<a.length;i++){
			int p=1;
			int len=1;
			while((i-p>=0) && (i+p<=a.length-1) && (a[i-p]==a[i+p])){
				len+=2;
				if(len>max_len){
					max_len=len;
					res=s.substring(i-p,i+p+1);
				}
				p++;
			}
			
			len=0;
			p=1;
			while((i-p>=0) && (i-1+p<=a.length-1) && (a[i-p]==a[i-1+p])){
				len+=2;
				if(len>max_len){
					max_len=len;
					res=s.substring(i-p,i+p);
				}
				p++;
			}
		}
		
		
		return res;
	}
	public static void main(String[] args) {
		System.out.println(longestPalindrome("abcbaaaaaa"));
	}
}
