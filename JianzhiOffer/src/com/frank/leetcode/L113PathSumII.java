package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L113PathSumII {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> his = new ArrayList<Integer>();
		path_core(root, his, sum, res);
		return res;
	}

	public void path_core(TreeNode root, List<Integer> history, int sum,
			List<List<Integer>> res) {
		if (root == null)
			return;
		history.add(root.val);
		if (root.left == null && root.right == null && sum - root.val == 0)
			res.add(history);
		else {
			path_core(root.left, new ArrayList<Integer>(history), sum
					- root.val, res);
			path_core(root.right, new ArrayList<Integer>(history), sum
					- root.val, res);
		}
	}

}
