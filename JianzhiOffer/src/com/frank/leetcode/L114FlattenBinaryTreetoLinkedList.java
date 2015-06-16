package com.frank.leetcode;

public class L114FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		travseral(root);
	}
	TreeNode pre=null;
	void travseral(TreeNode root ) {
		if (root != null) {
			if (pre != null)
				pre.right = root;

			pre = root;
			TreeNode left = root.left;
			TreeNode right = root.right;
			root.left = null;
			travseral(left);
			travseral(right);
		}
	}

	public static void main(String[] args) {
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		n1.left=n2;
		n1.right=n3;
		
		new L114FlattenBinaryTreetoLinkedList().flatten(n1);
	}
}
