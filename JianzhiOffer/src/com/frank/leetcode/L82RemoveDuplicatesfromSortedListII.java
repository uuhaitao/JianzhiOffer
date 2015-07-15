package com.frank.leetcode;

public class L82RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead = null;
		if (head.next == null || head.val != head.next.val)
			newHead = head;

		ListNode curr = head.next;
		ListNode prenode = null;
		if (newHead != null) {
			prenode = newHead;
			prenode.next = null;
		}
		int preval = head.val;
		while (curr != null) {
			if (curr.val != preval) {
				preval = curr.val;
				if (curr.next != null && curr.next.val == curr.val) {
					curr = curr.next;
					while (curr != null && curr.val == preval)
						curr = curr.next;
				} else if (curr.next == null || curr.next.val != preval) {
					ListNode next = curr.next;
					if (newHead == null) {
						newHead = curr;
						newHead.next = null;
						prenode = newHead;
					} else {
						prenode.next = curr;
						prenode = curr;
						prenode.next=null;
					}
					curr = next;
				}
			}else
				curr=curr.next;
		}

		return newHead;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next=n4;

		new L82RemoveDuplicatesfromSortedListII().deleteDuplicates(n1);
	}
}
