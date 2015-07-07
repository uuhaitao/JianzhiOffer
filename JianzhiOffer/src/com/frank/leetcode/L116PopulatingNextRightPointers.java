package com.frank.leetcode;

import java.util.LinkedList;

public class L116PopulatingNextRightPointers {
	public void connect_simple(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;
		LinkedList<TreeLinkNode> que = new LinkedList<TreeLinkNode>();
		que.add(root);
		while (!que.isEmpty()) {
			LinkedList<TreeLinkNode> nextline = new LinkedList<TreeLinkNode>();
			for (TreeLinkNode node : que) {
				if (node.left != null) {
					nextline.add(node.left);
				}
				if (node.right != null)
					nextline.add(node.right);
			}
			int len = nextline.size();
			for (int i = 1; i < len; i++) {
				nextline.get(i - 1).next = nextline.get(i);
			}
			if (len > 0)
				nextline.get(len - 1).next = null;
			que = nextline;
		}

	}

	public TreeLinkNode findnext(TreeLinkNode root) {
		TreeLinkNode tmp = root;
		while (tmp.next != null) {
			TreeLinkNode nextNode = tmp.next;
			if (nextNode.left != null)
				return nextNode.left;
			if (nextNode.right != null)
				return nextNode.right;
			tmp = nextNode;
		}

		return null;
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		root.next = null;

		TreeLinkNode curr = root;
		while (curr != null) {
			TreeLinkNode nextline=null;
			TreeLinkNode top = curr;
			if(top.left!=null)
				nextline= curr.left;
			else if(top.right!=null)
				nextline= curr.right;
			else
				nextline=findnext(top);
			while (top != null) {
				if (top.left != null) {
					if (top.right != null)
						top.left.next = top.right;
					else
						top.left.next = findnext(top);
				}

				if (top.right != null && top.next != null) {
					top.right.next = findnext(top);
				}
				top = top.next;
			}
			curr = nextline;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode n1 = new TreeLinkNode(9);
		TreeLinkNode n2 = new TreeLinkNode(3);
		TreeLinkNode n3 = new TreeLinkNode(2);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(4);
		TreeLinkNode n6 = new TreeLinkNode(0);
		TreeLinkNode n7 = new TreeLinkNode(-6);
		TreeLinkNode n8 = new TreeLinkNode(-5);
		
		n1.left=n2;
		n1.right=n3;
		
		n2.right=n4;
		n3.left=n5;
		n3.right=n6;
		n4.left=n7;
		n5.left=n8;
		
		new L116PopulatingNextRightPointers().connect(n1);
		
	}
}
