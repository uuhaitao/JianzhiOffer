package com.frank.leetcode;

public class L124BinaryTreeMaximumPathSum {
	int global_max = 0;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		global_max = root.val;
		core(root);
		return global_max;
	}

	int core(TreeNode root) {
		if (root == null)
			return 0;
		int left = core(root.left);
		int right = core(root.right);
		int tmp = root.val;
		if (left > 0)
			tmp += left;
		if (right > 0)
			tmp += right;
		if (tmp > global_max)
			global_max = tmp;
		return root.val + Math.max(0, Math.max(left, right));
	}

}
