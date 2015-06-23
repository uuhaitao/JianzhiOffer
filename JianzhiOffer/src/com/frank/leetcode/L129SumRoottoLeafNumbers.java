package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L129SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		List<Integer> res=new ArrayList<Integer>();
		path_core(root,0,res);
		int sum=0;
		for(Integer i :res){
			sum+=i;
		}
		return sum;
	}

	public void path_core(TreeNode root, int tmp, List<Integer> res) {
		if (root == null)
			return;
		int new_=tmp * 10 + root.val;
		if (root.left == null && root.right == null) {
			res.add(new_);
		} else {
			path_core(root.left,new_,res);
			path_core(root.right,new_,res);
		}
	}

}
