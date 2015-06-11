package com.frank.leetcode;

/*
 * Divide two integers without using multiplication, division and mod operator.
 */

public class L29DivideTwoIntegers {

	public static int divide(int dividend, int divisor) {

		long mather =Math.abs( (long)dividend);
		long son = Math.abs( (long)divisor);
		long tmp=0;
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		System.out.println(mather+" "+son);
		long res = 0;
		while (son <= mather) {
			 tmp = son;
			long cnt = 1;
			while ((tmp <<= 1) <= mather) {
				cnt <<= 1;
			}
			res += cnt;
			mather -= tmp >> 1;
		}
		if (sign>0 && res>Integer.MAX_VALUE)
			res=Integer.MAX_VALUE;
		
		return (int)(res*sign);
	}

	public static void main(String[] args) {
		System.out.println(divide(-1, 1));
		System.out.println(Integer.MAX_VALUE);
	}

}
