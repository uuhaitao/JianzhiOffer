package com.frank.leetcode;

public class L236LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==p || root==q)
			return root;
		boolean pleft=ischild(root.left, p);
		boolean qleft=ischild(root.left, q);
		if(pleft && qleft)
			return lowestCommonAncestor(root.left, p, q);
		else if(!pleft && !qleft)
			return lowestCommonAncestor(root.right, p, q);
		return root;
	}

	public boolean ischild(TreeNode root, TreeNode son) {
		if (root == son)
			return true;
		if (root == null)
			return false;
		return ischild(root.left, son) || ischild(root.right, son);
	}
}
