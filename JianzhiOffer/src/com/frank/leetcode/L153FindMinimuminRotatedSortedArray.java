package com.frank.leetcode;

public class L153FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {

		int len = nums.length;
		if (len == 1)
			return nums[0];
		int left = 0;
		int right = len - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[right] > nums[mid]) {
				right = mid;
			} else if (nums[right] < nums[mid]) {
				left = mid + 1;
			}
			if(nums[right] == nums[mid]){
				int val=nums[left];
				for(int i=left+1;i<=right;i++){
					if(nums[i]<val)
						val=nums[i];
				}
				return val;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		int a = new L153FindMinimuminRotatedSortedArray().findMin(new int[] {1, 3, 3 });
		System.out.println(a);
	}

}
