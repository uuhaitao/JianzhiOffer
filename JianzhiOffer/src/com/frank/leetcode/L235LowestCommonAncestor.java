package com.frank.leetcode;

public class L235LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val>q.val)
			return lowestCommonAncestor(root, q, p);
		if(root.val>=p.val && q.val>=root.val)
			return root;
		else if(root.val>p.val && root.val>q.val)
			return lowestCommonAncestor(root.left, p, q);
		else if(root.val<p.val && root.val<q.val)
			return lowestCommonAncestor(root.right, p, q);
		return null;
	}
}
