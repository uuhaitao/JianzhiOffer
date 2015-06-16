package com.frank.leetcode;

import java.util.LinkedList;

public class L111MinimumDepthofBinaryTree {

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;

		int level=0;
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		l.add(root);
		while (!l.isEmpty()) {
			LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
			for (TreeNode n : l) {
				if (n.left != null)
					tmp.add(n.left);
				if (n.right != null)
					tmp.add(n.right);
				if(n.left == null && n.right==null)
					return level+1;
			}
			l = tmp;
			level++;
		}
		return level;
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left = t2;

		System.out.println(minDepth(t1));

	}

}
