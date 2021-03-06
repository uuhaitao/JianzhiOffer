package com.frank.leetcode;


/*
 * Given a sorted array, 
 * remove the duplicates in place such that each element appear only once
 *  and return the new length.

 Do not allocate extra space for another array, 
 you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, 
 */

public class L26RemoveDuplicates {

	public int removeDuplicates(int[] nums) {
		int lens=nums.length;
		int newsize=1;
		int curr=nums[0];
		int new_ind=1;
		for(int j=1;j<lens;j++){
			if(curr==nums[j])
				continue;
			else{
				curr=nums[j];
				nums[new_ind]=curr;
				newsize++;
				new_ind++;
			}
			
		}
		return newsize;
	}

}
