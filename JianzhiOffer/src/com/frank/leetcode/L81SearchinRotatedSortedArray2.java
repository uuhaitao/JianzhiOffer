package com.frank.leetcode;

public class L81SearchinRotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}

	public boolean search(int a[], int start, int end, int target) {
		if (start > end)
			return false;
		int mid = (start + end) / 2;
		int a0 = a[start];
		int a1 = a[end];
		int am = a[mid];

		if (target == am)
			return true;

		if (a0 == am && a1 == am) {
			for (int i = start; i <= end; i++) {
				if (a[i] == target)
					return true;
			}
		}

		if (am >=a0) {
			if (target > am || target < a0)
				return search(a, mid + 1, end, target);
			else
				return search(a, start, mid - 1, target);
		}

		else {
			if (target > a1 || target < am)
				return search(a, start, mid - 1, target);
			else
				return search(a, mid + 1, end, target);
		}
	}
	
	public static void main(String[] args) {
		new L81SearchinRotatedSortedArray2().search(new int[]{1,2}, 2);
	}
}
