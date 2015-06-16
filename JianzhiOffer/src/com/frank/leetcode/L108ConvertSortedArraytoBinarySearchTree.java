package com.frank.leetcode;

public class L108ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		return core(nums, 0, nums.length - 1);
	}

	public TreeNode core(int[] nums, int begin, int end) {
		if (begin <= end) {
			int mid = (begin + end) / 2;
			TreeNode node = new TreeNode(nums[mid]);
			node.left = core(nums, begin, mid - 1);
			node.right = core(nums, mid + 1, end);
			return node;
		}
		return null;
	}
}
