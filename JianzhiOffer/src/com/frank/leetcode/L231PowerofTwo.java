package com.frank.leetcode;

public class L231PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		if(n<=0)
			return false;
		return (n&(n-1))==0;
	}
}
