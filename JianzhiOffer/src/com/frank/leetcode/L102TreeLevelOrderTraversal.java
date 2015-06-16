package com.frank.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L102TreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;

		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root);
		while (!l.isEmpty()) {
			LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
			LinkedList<Integer> level = new LinkedList<Integer>();
			for (TreeNode n : l) {
				level.add(n.val);
				if (n.left != null)
					tmp.add(n.left);
				if (n.right != null)
					tmp.add(n.right);
			}
			res.add(level);
			l = tmp;
		}

		return res;

	}
}
