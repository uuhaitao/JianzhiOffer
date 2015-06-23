package com.frank.leetcode;

/*
 * with n = 7 and k = 3, 
 * the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */

public class L189RotateArray {
	public void rotate(int[] nums, int k) {
		int n=nums.length;
		reverse(nums,0,n-k-1);
		reverse(nums,n-k,n-1);
		reverse(nums,0,n-1);
	}
	public void reverse(int []nums,int start,int end){
		int l=start;
		int r=end;
		int tmp=0;
		while(l<r){
			tmp=nums[l];
			nums[l]=nums[r];
			nums[r]=tmp;
			l++;
			r--;
		}
	}
}
