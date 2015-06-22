package com.frank.leetcode;

public class L112PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {

		return isValidate(root, 0, sum);
	}

	public boolean isValidate(TreeNode root, int tmp, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && tmp + root.val == sum)
			return true;
		return isValidate(root.left, tmp + root.val, sum)
				|| isValidate(root.right, tmp + root.val, sum);
	}

}
