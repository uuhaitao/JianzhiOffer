package com.frank.leetcode;

public class L98ValidateBinarySearch {
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return core(root);
	}

	long curr = Long.MIN_VALUE;

	boolean core(TreeNode root) {
		if (root == null)
			return true;
		if (core(root.left)) {
			int v = root.val;
			if (v > curr) {
				curr = v;
				return core(root.right);
			}
			return false;
		}
		return false;

	}

	public static void main(String[] args) {
		TreeNode root=new TreeNode(-2147483648);
		TreeNode t1=new TreeNode(-2147483648);
		root.left=t1;
		
		boolean res=new L98ValidateBinarySearch().isValidBST(root);
		System.out.println(res);
	}
}
