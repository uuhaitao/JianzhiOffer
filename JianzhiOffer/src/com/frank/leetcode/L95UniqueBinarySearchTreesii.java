package com.frank.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L95UniqueBinarySearchTreesii {
	public List<TreeNode> generateTrees(int n) {
		return generate_core(0,n-1);
	}

	public ArrayList<TreeNode> generate_core(int start, int end) {
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		if(start>end){
			res.add(null);
			return res;
		}
		ArrayList<TreeNode> left=new ArrayList<TreeNode>();
		ArrayList<TreeNode> right=new ArrayList<TreeNode>();
		for(int i=start;i<=end;i++){
			left=generate_core(start,i-1);
			right=generate_core(i+1,end);
			for(int m=0;m<left.size();m++){
				for(int n=0;n<right.size();n++){
					TreeNode node=new TreeNode(i+1);
					node.left=left.get(m);
					node.right=right.get(n);
					res.add(node);
				}
			}
		}
		return res;
	}
}
