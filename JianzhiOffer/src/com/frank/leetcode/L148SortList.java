package com.frank.leetcode;

public class L148SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode mid=findmid(head);
		ListNode right=mid.next;
		mid.next=null;
		
		return merge(sortList(head), sortList(right));
	}

	ListNode findmid(ListNode head) {
		ListNode slow = head;
		ListNode quick = head;
		while (quick.next != null && quick.next.next != null) {
			quick = quick.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode head = null;
		ListNode n1 = head1;
		ListNode n2 = head2;

		if (n1.val <= n2.val) {
			head = n1;
			n1 = n1.next;
		}

		else {
			head = n2;
			n2 = n2.next;
		}
		ListNode curr = head;

		while (n1 != null && n2 != null) {
			if (n1.val <= n2.val) {
				curr.next = n1;
				curr = n1;
				n1 = n1.next;
			} else {
				curr.next = n2;
				curr = n2;
				n2 = n2.next;
			}
		}
		if (n1 != null) {
			curr.next = n1;
		}
		if (n2 != null) {
			curr.next = n2;
		}

		return head;
	}
}
