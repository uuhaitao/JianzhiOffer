package com.frank.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L103BinaryTreeZigzag {
	public List<List<Integer>> levelOrder(TreeNode root) {
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		boolean direction=true;
		
		if (root == null)
			return res;

		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root);
		while (!l.isEmpty()) {
			LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
			LinkedList<Integer> level = new LinkedList<Integer>();
			for (TreeNode n : l) {
				if(direction)
					level.add(n.val);
				else
					level.addFirst(n.val);
				if (n.left != null)
					tmp.add(n.left);
				if (n.right != null)
					tmp.add(n.right);
			}
			res.add(level);
			l = tmp;
			direction=!direction;
		}

		return res;
	}
}
