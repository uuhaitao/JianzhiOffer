package com.frank.leetcode;

public class L215KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		return quick_select(nums, 0, nums.length-1, k);
	}

	public int quick_select(int[] nums, int start, int end, int k) {
		int x = nums[start];
		int i = start;
		int j = end;
		while (i < j) {
			while (i < j && nums[j] >= x) {
				j--;
			}
			if (i < j) {
				nums[i] = nums[j];
				i++;
			}
			while (i < j && nums[i] < x) {
				i++;
			}
			if (i < j) {
				nums[j] = nums[i];
				j--;
			}
		}
		nums[i] = x;
		if (k == end-i+1)
			return x;
		else if (k > end - i+1)
			return quick_select(nums, start, i - 1, k-(end-i+1));
		else
			return quick_select(nums, i + 1, end, k);
	}
	public static void main(String[] args) {
		int n=new L215KthLargestElement().findKthLargest(new int[]{2,1}, 2);
		System.out.println(n);
		
	}
	
}
