package com.frank.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L144TreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
		if (root == null)
			return res;
		travseral(root, res);
		return res;
	}

	void travseral(TreeNode root, List<Integer> list) {
		if (root != null) {
			list.add(root.val);
			travseral(root.left, list);
			travseral(root.right, list);
		}
	}

}
