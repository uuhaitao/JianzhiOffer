package com.frank.leetcode;

/*
 * Determine whether an integer is a palindrome. 
 * Do this without extra space.
 */

public class L9PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x<0)
			return false;
		String num=String.valueOf(x);
		return new StringBuilder(num).reverse().toString().equals(num);
	}

	public static boolean _isPalindrome(int x) {
		if (x<0)
			return false;
		int bits=0;
		int a=x;
		while(a>0){
			bits+=1;
			a/=10;
		}
		for(int i=0;i<bits/2;i++){
			int bit_low=(int) (x/(Math.pow(10, i))%10);
			int bit_high=(int)(x/(Math.pow(10,bits-i-1))%10);
			if (bit_low!=bit_high )
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		_isPalindrome(12321);
	}

}
