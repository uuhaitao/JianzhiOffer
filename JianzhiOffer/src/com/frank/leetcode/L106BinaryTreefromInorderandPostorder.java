package com.frank.leetcode;

public class L106BinaryTreefromInorderandPostorder {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildPI(inorder, postorder, 0, inorder.length - 1, 0,
				postorder.length - 1);
	}

	public TreeNode buildPI(int[] inorder, int[] postorder, int i_s, int i_e,
			int p_s, int p_e) {
		if (p_s > p_e || i_s > i_e)
			return null;

		int pivot = postorder[p_e];

		int i = i_s;
		for (; i < i_e; i++) {
			if (inorder[i] == pivot)
				break;
		}

		TreeNode node = new TreeNode(pivot);
		
		int lenLeft = i - i_s;
		
		node.left = buildPI(inorder, postorder, i_s, i - 1, p_s, p_s + lenLeft
				- 1);
		node.right = buildPI(inorder, postorder, i + 1, i_e, p_s + lenLeft, p_e-1);
		return node;
	}

}
