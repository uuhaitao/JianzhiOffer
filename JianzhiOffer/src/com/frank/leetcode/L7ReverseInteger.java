package com.frank.leetcode;

/*
 * Reverse digits of an integer.
 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */

public class L7ReverseInteger {
	public static int reverse(int x) {
		String raw=String.valueOf(x);
		String num=raw;
		boolean neg=raw.contains("-");
		if (neg){
			num=raw.substring(1);
		}
		int val=0;
		try{
			val=Integer.valueOf(new StringBuilder(num).reverse().toString());
		}
		catch(NumberFormatException e){
		}
		
		return neg? val*(-1) : val;
	}

	public static void main(String[] args) {
		System.out.println(reverse(-2003));
	}
}
