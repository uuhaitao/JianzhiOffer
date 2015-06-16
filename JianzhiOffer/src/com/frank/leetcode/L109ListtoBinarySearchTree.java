package com.frank.leetcode;

public class L109ListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		node = head;
		int lens = 0;
		ListNode m = head;
		while (m != null) {
			lens++;
			m = m.next;
		}
		return core(0, lens - 1);
	}

	ListNode node;

	public TreeNode core(int begin, int end) {
		if (begin <= end) {
			int mid = (begin + end) / 2;
			TreeNode left = core(begin, mid - 1);
			TreeNode root = new TreeNode(node.val);
			root.left = left;
			node = node.next;
			TreeNode right = core(mid + 1, end);
			root.right = right;
			return root;
		}
		return null;
	}

	
	
}
