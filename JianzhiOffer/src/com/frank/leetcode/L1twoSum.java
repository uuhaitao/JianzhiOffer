package com.frank.leetcode;


/**
 * 
 * @author root
 *
 * 
 *Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */

public class L1twoSum {

	public static int[] twoSum(int[] nums, int target) {
		int result[]=new int [2];
		int lens=nums.length;
		for(int i=0;i<lens-1;i++){
			for (int j=i;j<lens;j++){
				if(nums[i]+nums[j]==target){
					result[0]=i+1;
					result[1]=j+1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
//		numbers={2, 7, 11, 15}, target=9
		int []numbers={2, 7, 11, 15};
		int target=9;
		int [] res=twoSum(numbers,target);
		System.out.println(res[0]+" "+res[1]);
	}

}
