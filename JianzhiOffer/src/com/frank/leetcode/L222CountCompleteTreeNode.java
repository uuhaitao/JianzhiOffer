package com.frank.leetcode;

public class L222CountCompleteTreeNode {
	public String Tobinary(int v, int n) {
		String base = Integer.toBinaryString(v);
		int len = base.length();
		while (len < n) {
			base = "0" + base;
			len++;
		}
		return base;
	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int level = 0;
		TreeNode t = root;
		while (t != null) {
			t = t.left;
			level++;
		}

		if (level == 1)
			return 1;

		int above = (int) Math.pow(2, level - 1) - 1;
		int down = 0;
		int l = 0;
		int right = above;
		while (l <= right) {

			if (right - l == 1) {
				boolean found = fund(root, level, right);
				if (found)
					return above + right + 1;
				else
					return above + down + l + 1;
			}
			int mid = (l + right) / 2;

			boolean found = fund(root, level, mid);
			if (found)
				l = mid;
			else
				right = mid;
		}
		return 0;

	}

	boolean fund(TreeNode root, int n, int ind) {
		String direction = Tobinary(ind, n - 1);
		TreeNode curr = root;
		for (int i = 0; i < n - 1; i++) {
			if (direction.charAt(i) == '0')
				curr = curr.left;
			else
				curr = curr.right;
		}
		return curr != null;
	}

}
