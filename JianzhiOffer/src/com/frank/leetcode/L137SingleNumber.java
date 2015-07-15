package com.frank.leetcode;

public class L137SingleNumber {
	public int singleNumber(int[] nums) {
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			int mask = 1 << i;
			int c = 0;
			for (int j = 0; j < nums.length; j++) {
				int val = mask & nums[j];
				if (val != 0)
					c++;
			}
			if(c%3>0)
			ret |= mask;
		}
		return ret;
	}

	public static void main(String[] args) {
//		int res=5;
		for(int i=1;i<=100;i++)
		{
			System.out.println(Integer.toBinaryString(i));
		}
//		System.out.println(res);
	}
}
