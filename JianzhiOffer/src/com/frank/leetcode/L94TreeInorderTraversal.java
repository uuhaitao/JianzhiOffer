package com.frank.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L94TreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (root == null)
			return res;
		core(root,res);
		return res;
	}

	void core(TreeNode root, LinkedList<Integer> list) {
		if (root == null)
			return;
		core(root.left, list);
		list.add(root.val);
		core(root.right, list);

	}
}
