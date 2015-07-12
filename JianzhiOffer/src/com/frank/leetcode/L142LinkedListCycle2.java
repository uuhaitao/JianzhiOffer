package com.frank.leetcode;

public class L142LinkedListCycle2 {
	public ListNode hasCycle(ListNode head) {
		if (head == null)
			return null;
		boolean hascircle = false;
		ListNode slow = head;
		ListNode quick = head;
		while (quick != null && quick.next != null) {
			slow = slow.next;
			quick = quick.next.next;
			if (quick == slow) {
				hascircle = true;
				break;
			}
		}
		if (hascircle) {
			quick = head;
			while (quick != slow) {
				quick = quick.next;
				slow = slow.next;
			}
			return slow;
		}

		return null;
	}
}
