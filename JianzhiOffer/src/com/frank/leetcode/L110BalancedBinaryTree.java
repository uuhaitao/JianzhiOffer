package com.frank.leetcode;

public class L110BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int left = getdepth(root.left);
		int right = getdepth(root.right);
		if (Math.abs(left - right) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);

	}

	public int getdepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getdepth(root.left);
		int right = getdepth(root.right);
		return 1 + (left >= right ? left : right);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2;
		t2.right = t3;

		new L110BalancedBinaryTree().isBalanced(t1);

	}

}
