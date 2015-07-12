package com.frank.leetcode;

public class L230KthSmallestElementinaBST {
	public int kthSmallest(TreeNode root, int k) {
		helper(root, k);
		return minval;
	}

	int minval=0;
	int curr = 1;

	void helper(TreeNode root, int k) {
		if (root.left != null)
			helper(root.left, k);
		if (k == curr) {
			minval = root.val;
			curr++;
			return;
		} 
		curr++;
		if (root.right != null)
			helper(root.right, k);
	}
	public static void main(String[] args) {
		TreeNode n1=new TreeNode(2);
		TreeNode n2=new TreeNode(1);
		n1.left=n2;
		int v=new L230KthSmallestElementinaBST().kthSmallest(n1, 1);
		System.out.println(v);
	}
	
}
