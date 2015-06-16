package com.frank.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L199BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		LinkedList<Integer> res = new LinkedList<Integer>();
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
			l = tmp;
			res.add(level.getLast());
		}
		return res;
	}

}
