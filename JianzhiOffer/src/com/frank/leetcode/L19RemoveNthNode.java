package com.frank.leetcode;

public class L19RemoveNthNode {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null)
			return null;
		ListNode quick = head;
		ListNode slow = head;
		for (int i = 0; i < n; i++) {
			quick = quick.next;
		}
		if (quick == null) {
			return head.next;
		}
		while (quick != null && quick.next != null) {
			quick = quick.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return head;
	}

	public static void main(String[] args) {

	}

}
